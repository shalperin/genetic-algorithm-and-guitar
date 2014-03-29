[![Soundcloud](designAssets/soundcloud.png)](https://soundcloud.com/sam-halperin/composition-for-genetic)

This was an AI experiment in using a Genetic Algorithm for computational musical creativity.

<p>Implementing part of an algorithm specified in a paper by Liu et. al. [1] and building on a Java sound demo from javakode.com[2], I created this short duet between tones created by a genetic algorithm and a classical guitar.</p>


<p>Here is the fitness function that I used for the GA, based on [1].  A general overview of GA's follows.</p>


<pre><code class="language-java">
public class RuleEngine {
    // a = score note
    // b = ga note
    // prev = previous ga note
    public static int points(Note a, Note b, Note prev) {
        return  unison(a, b) +
                minorSecond(a, b) +
                majorSecond(a, b) +
                minorThird(a, b) +
                majorThird(a, b) +
                perfectFourth(a, b) +
                diminishedFifth(a, b) +
                perfectFifth(a, b) +
                minorSixth(a, b) +
                majorSixth(a, b) +
                minorSeventh(a, b) +
                majorSeventh(a, b) +
                octave(a, b) +
                diversity(b, prev);
        }
    public static int diversity(Note gaNote, Note prev) {
        if (prev == null) {
            return 0;
        } else if (gaNote.val() == prev.val()) {
            return -2;
        } else {
            return 0;
        }
    }
    public static int unison(Note a, Note b) {
        int points = a.val() == b.val() ? 8 : 0;
        return points;
    }
    public static int minorSecond(Note a, Note b) {
        int points = Math.abs(a.val() - b.val()) == 1 ? -20 : 0;
        return points;
    }
    public static int majorSecond(Note a, Note b) {
        int points = Math.abs(a.val() - b.val()) == 2 ? -20 : 0;
        return points;
    }
    public static int minorThird(Note a, Note b) {
        int points = Math.abs(a.val() - b.val()) == 3 ? -20 : 0;
        return points;
    }
 
    public static int majorThird(Note a, Note b) {
        int points = Math.abs(a.val() - b.val()) == 4 ? 8 : 0;
        return points;
    }
    public static int perfectFourth(Note a, Note b) {
        int points = Math.abs(a.val() - b.val()) == 5 ? 15 : 0;
        return points;
    }
    public static int diminishedFifth(Note a, Note b) {
        int points = Math.abs(a.val() - b.val()) ==6  ? -30 : 0;
        return points;
    }
    public static int perfectFifth(Note a, Note b) {
        int points = Math.abs(a.val() - b.val()) == 7 ? 15 : 0;
        return points;
    }
    public static int minorSixth(Note a, Note b) {
        int points = Math.abs(a.val() - b.val()) == 8 ? 8 : 0;
        return points;
    }
    public static int majorSixth(Note a, Note b) {
        int points = Math.abs(a.val() - b.val()) == 9 ? 8 : 0;
        return points;
    }
    public static int minorSeventh(Note a, Note b) {
        int points = Math.abs(a.val() - b.val()) == 10 ? -20 : 0;
        return points;
    }
    public static int majorSeventh(Note a, Note b) {
        int points = Math.abs(a.val() - b.val()) == 11 ? -20 : 0;
        return points;
    }
    public static int octave(Note a, Note b) {
        int points = a.val() % b.val() == 0 ? 8 :0;
        return points;
    }
}
</code></pre>


<p>A genetic algorithm based solution is useful where you have  a problem space where it is not possible to combinatorially try every possible solution, so you use a stochastic process to generate approximate solutions.  For the composition above, it was also useful for generating different creative solutions based on a set of rules. (Rules like, prefer a perfect 4th over a minor 2nd interval.)</p>

<p>The basic process for an Evolutionary solution is:
<ol>
    <li>Create an encoding of the problem solution, IE a design for a "chromosome".  For example a bitmask where an "on" bit indicates that a point is included in a solution set, and an "off" bit indicates that it is excluded, or an array of numbers from 1-12, representing the notes in a scale.</li>
    <li>Create a fitness function that takes as its input the chromosome, and returns a numerical fitness value.</li>
    <li>Create a random population of potential solutions.</li>
    <li>Select pairs from this population using some selection algorithm (tournament selection, roulette wheel selection) whereby "fitter" chromosomes are selected with higher frequency.</li>
    <li>"Breed" offspring from these parent pairs, by incorporating DNA from each parent at  a set or variable crossover point. (Imagine two 10 element arrays, where the child has the left 5 elements of parent 1, and the right 5 of parent 2)</li>
    <li>So as not to get stuck at a local sub-optimal solution, mutate the offspring by randomly changing the chromosome using some scheme. </li>
    <li>Iterate on successive populations until an optimum is achieved.</li>
</ol>
</p>

<br><br>
[NOTES]<br>
<ul>
<li>[1] Liu, C. H., & Ting, C. K. (2012, June). <a href="http://ieeexplore.ieee.org/xpl/login.jsp?tp=&arnumber=6252869&url=http%3A%2F%2Fieeexplore.ieee.org%2Fxpls%2Fabs_all.jsp%3Farnumber%3D6252869">Polyphonic accompaniment using genetic algorithm with music theory.</a> In Evolutionary Computation (CEC), 2012 IEEE Congress on (pp. 1-7). IEEE.</li>
<li>[2] Playing MIDI Music with the Java API: Some Simple Examples (N.D.) retrieved 10/9/2013 from <a href="http://www.javakode.com/apps/music1">http://www.javakode.com/apps/music1/</a></li>

</ul>