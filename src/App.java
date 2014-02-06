import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * by Sam Halperin
 * sam@samhalperin.com
 * http://github.com/shalperin
 *
 * @sam_halperin Date: 10/9/13
 * Time: 9:20 AM
 */
public class App {

    //msec
    static int whole = 1200;
    static int half = whole/2;
    static int quarter = whole/4;
    static int eight = whole/8;

    public static final Random rand = new Random();


    public static void main(String[] args) {


        int bars = 4*8; // of quarter note//
        Note[] score2 = new Note[bars];
        for (int i = 0 ; i< bars; i++){
            score2[i] = new Note("C2", quarter);
        }
        GA ga = new GA(score2);
        ga.run(.03f, 2, 500);
    }
}
