import javax.sound.sampled.*;
import java.io.File;

public class MusicPlayer 
{
    private Clip clip;
    
    public void play(String filename)
    {
        new Thread(() -> {
            try {
                File audioFile = new File(filename);
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                clip = AudioSystem.getClip();
                clip.open(audioStream);
                // Can remove loop continuously to only play once. 
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                // Can add clip.loop(3) to play 3 times. Etc.
                clip.start();
            } catch (Exception e) {
                System.out.println("Could not play music: " + e.getMessage());
            }
        }).start();
    }
    
    public void stop()
    {
        if (clip != null && clip.isRunning())
        {
            clip.stop();
            clip.close();
        }
    }
}
