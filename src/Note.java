/**
 * by Sam Halperin
 * sam@samhalperin.com
 * http://github.com/shalperin
 *
 * @sam_halperin Date: 10/9/13
 * Time: 9:08 AM
 */
public class Note {
    private int value;
    private String noteName;
    private int duration;


    public Note(String noteName, int duration) {
        this.value = MidiNoteMap.MIDI_NOTES.get(noteName);
        this.noteName = noteName;
        this.duration = duration;
    }

    public Note (int midiVal) {
        this.duration = App.quarter;
        this.value = midiVal;
        this.noteName = "todo";
    }

    public int midiVal() {
        return value;
    }

    public String name() {
        return noteName;
    }

    public int duration()  {
        return duration;
    }

    // this is the same as midi val for now.
    // the paper uses a slightly different mapping.
    public int val() {
        return value;
    }

}
