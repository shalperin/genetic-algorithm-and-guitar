// Adapted from http://www.javakode.com/apps/music1/

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.MidiChannel;

public class Player {

    public static void play(Note[] score) {
        int channel = 0; // 0 is a piano, 9 is percussion, other channels are for other instruments
        int volume = 80; // between 0 et 127
        int duration = 200; // in milliseconds

        try {
            Synthesizer synth = MidiSystem.getSynthesizer();
            synth.open();
            MidiChannel[] channels = synth.getChannels();

            for (int i = 0; i<score.length; i++) {
                Note note = score[i];
                channels[channel].noteOn( note.midiVal(), volume );
                if (i == score.length -1 ) {
                    Thread.sleep( App.whole *2);
                } else {
                    Thread.sleep( note.duration());
                }
                channels[channel].noteOff( note.duration()  );
            }
            synth.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}


