/**
 * by Sam Halperin
 * sam@samhalperin.com
 * http://github.com/shalperin
 *
 * @sam_halperin Date: 10/9/13
 * Time: 9:14 AM
 */
public class Chromosome implements Comparable<Chromosome>{
    private Note[] score;
    private Note[] gaPart;
    public int fitness;

    public void refreshFitness() {
        fitness = evaluate();
    }

    public Chromosome (Note[] score) {
        this.score = score;
        this.gaPart = new Note[score.length];
    }
    public Chromosome (Note[] score, Note[] gaPart) {
        this.score = score;
        this.gaPart = gaPart;
    }

    public Note[] getScore() {
        return score;
    }
    public Note[] getGAPart() {
        return gaPart;
    }

    private Note randomNote() {
        int newNote = App.rand.nextInt(MidiNoteMap.max - MidiNoteMap.min) + MidiNoteMap.min;
        return new Note(newNote);
    }
    public void randomize() {
        for (int i = 0; i<gaPart.length; i++) {
             gaPart[i] = randomNote();
        }
    }
    public void mutate(float mutProb, int nToMutate) {
        if (App.rand.nextFloat() <= mutProb) {
            for (int i = 0; i< nToMutate; i++) {
                gaPart[App.rand.nextInt(gaPart.length)] = randomNote();
            }
        }
    }
    public int evaluate() {
        int sum = 0;
        Note previous = null;
        for (int i = 0; i< gaPart.length; i++) {

            sum += RuleEngine.points(score[i], gaPart[i], previous);
            previous = gaPart[i];
       }
        return sum;
    }

    @Override
    public int compareTo(Chromosome chromosome) {
        double c0 = this.fitness;
        double c1 = chromosome.fitness;
        if (c0 > c1) {
            return -1;
        } else if (c0 == c1) {
            return 0;
        } else {
            return 1;
        }
    }

    public Chromosome cross(Chromosome c2, float crossoverPoint)  {
        int crossoverIndex = (int)(c2.gaPart.length * crossoverPoint);
        Chromosome child = new Chromosome(score);

        // set child's data to this.data for indexes < crossover point
        for (int i = 0; i< crossoverIndex; i++) {
            child.gaPart[i]=this.gaPart[i];
        }

        // and set its data to c2.data for indexes >= crossover point
        for (int i = crossoverIndex; i<c2.gaPart.length; i++) {
            child.gaPart[i] = c2.gaPart[i];
        }

        //child.refreshFitness();
        return child;
    }

}
