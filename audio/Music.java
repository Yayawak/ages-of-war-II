package audio;

import java.io.File;
import java.io.IOError;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.SourceDataLine;

public class Music {
    Clip clip;
    AudioInputStream sound;

    // public void setFile(String soundFileName)
    public void setFile(String soundRelativePath) {
        String base = new File("").getAbsolutePath() + "/audio/";
        String fullPath = base + soundRelativePath;
        System.out.println(fullPath);

        try {
            File file = new File(fullPath);
            sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(sound);
        } catch (Exception e) { System.out.println(e); }
    }

    public void play() {
        clip.start();
    }

    public void stop() throws IOException {
        sound.close();
        clip.close();
        clip.stop();
    }

}
