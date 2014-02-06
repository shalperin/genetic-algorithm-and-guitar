import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * by Sam Halperin
 * sam@samhalperin.com
 * http://github.com/shalperin
 *
 * @sam_halperin Date: 9/22/13
 * Time: 2:54 PM
 */
public class GA {

    Population population;

    int POPULATION_SIZE = 100;

    public GA (Note[] score) {
        population = new Population();
        for (int i = 0; i< POPULATION_SIZE; i++) {
            Chromosome newChrom = new Chromosome(score);
            newChrom.randomize();
            population.add(newChrom);
        }
        population.finalize();
    }

    public void run(float mutProb, int quantMut, int ITERS) {
        int currentIter = 0;
        while (currentIter < ITERS ) {
            System.out.println(currentIter);
            Population newPopulation = new Population();
            for (int i = 0; i<population.size(); i++) {
                Chromosome parent1 = select(population);
                Chromosome parent2 = select(population);
                Chromosome child = parent1.cross(parent2, .5f);
                child.mutate(mutProb, quantMut);
                newPopulation.add(child);
            }
            newPopulation.finalize();
            //System.out.println(newPopulation.getFittest());
            //System.out.println(newPopulation.getFittest());
            //Player.play(newPopulation.getFittest().getGAPart());
            population = newPopulation;
            System.out.println(newPopulation.getFittest().evaluate());
            currentIter++;
            if (currentIter == 30 || currentIter == 50 || currentIter %100 == 0 ) {
                Player.play(newPopulation.getFittest().getGAPart());
            }

        }
        Player.play(population.getFittest().getGAPart());
        Player.play(population.getFittest().getGAPart());
        Player.play(population.getFittest().getGAPart());
    }

    /*
    tournament selection
    */
    public Chromosome select(Population population) {
        Chromosome fittest = null;

        for (int i = 0; i< 10; i++) {
            Chromosome suitor = population.getRandom();
            if (fittest == null || suitor.fitness > fittest.fitness) {
                fittest = suitor;
            }
        }
        return fittest;
    }
}
