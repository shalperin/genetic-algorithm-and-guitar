/**
 * by Sam Halperin
 * sam@samhalperin.com
 * http://github.com/shalperin
 *
 * @sam_halperin Date: 10/9/13
 * Time: 9:55 AM
 */
public class RuleEngine {
    // a = score note
    // b = ga note
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
        } else if (gaNote.midiVal() == prev.midiVal()) {
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
