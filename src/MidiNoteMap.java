import java.util.HashMap;

/**
 * by Sam Halperin
 * sam@samhalperin.com
 * http://github.com/shalperin
 *
 * @sam_halperin Date: 10/9/13
 * Time: 9:24 AM
 */
public class MidiNoteMap {
    public static HashMap<String, Integer> MIDI_NOTES = new HashMap<String, Integer>();
    static {
        MIDI_NOTES.put("C2", 48);
        MIDI_NOTES.put("C#2", 49);
        MIDI_NOTES.put("D2", 50);
        MIDI_NOTES.put("Eb2", 51);
        MIDI_NOTES.put("E2", 52);
        MIDI_NOTES.put("F2", 53);
        MIDI_NOTES.put("F#2", 54);
        MIDI_NOTES.put("G2", 55);
        MIDI_NOTES.put("G#2", 56);
        MIDI_NOTES.put("A2", 57);
        MIDI_NOTES.put("Bb2", 58);
        MIDI_NOTES.put("B2", 59);
        MIDI_NOTES.put("C3", 60);

    }
    public static HashMap<Integer, String> REV = new HashMap<Integer, String>();
    static {
        REV.put(48, "C2");
        REV.put(49, "C#2");
        REV.put(50, "D2");
        REV.put(51, "Eb2");
        REV.put(52, "E2");
        REV.put(53, "F2");
        REV.put(54, "F#2");
        REV.put(55, "G2");
        REV.put(56, "G#2");
        REV.put(57, "A2");
        REV.put(58, "Bb2");
        REV.put(59, "B2");
        REV.put(60, "C3");

    }

    public static int min = 48;
    public static int max = 60;

}
