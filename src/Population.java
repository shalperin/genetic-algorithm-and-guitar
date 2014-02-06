
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * by Sam Halperin
 * sam@samhalperin.com
 * http://github.com/shalperin
 *
 * @sam_halperin Date: 10/2/13
 * Time: 9:29 PM
 */
public class Population {
    private ArrayList<Chromosome> p = new ArrayList<Chromosome>();

    public Population() {

    }

    public void add(Chromosome c) {
        p.add(c);
    }

    // not calling c.refreshFitness here is an optimization,
    // but will probably also be a source of future bugs.
    // always call finalize before getFittest.
    // ? Refactor
    // Add a dirty bit that is set on add, and cleared on finalize and throw
    // if dirty here.
    public Chromosome getFittest() {
        return p.get(0);
    }

    public void finalize() {
        for (Chromosome c : p) {
            c.refreshFitness();
        }
        Collections.sort(p);
    }

    public int size() {
        return p.size();
    }

    public Chromosome getRandom() {
        return p.get(App.rand.nextInt(p.size()));
    }
}
