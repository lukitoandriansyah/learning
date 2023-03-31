package JavaObjectOriented.SimpleAudioPlayer.src.main.java.org.example;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Option extends Data {
    public void play(){
        clip.start();
        status="play";
    }
    public void pause(){
        if (status.equals("paused")){
            System.out.println("Audio paused");
            return;
        }
        this.currentFrame = this.clip.getMicrosecondPosition();
        clip.stop();
        status="paused";
    }

    public void resumeAudio() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if (status.equals("play")) {
            System.out.println("Audio is already being played");
        }
        clip.close();
        resetAudioStream();
        clip.setMicrosecondPosition(currentFrame);
        this.play();
    }

    public void restart() throws IOException, LineUnavailableException, UnsupportedAudioFileException{
        clip.stop();
        clip.close();
        resetAudioStream();
        currentFrame = 0L;
        clip.setMicrosecondPosition(0);
        this.play();
    }

    public void stop() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        currentFrame = 0L;
        clip.stop();
        clip.close();
    }

    public void jump(long c) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        if (c>0&&c<clip.getMicrosecondLength()){
            clip.stop();
            clip.close();
            resetAudioStream();
            currentFrame=c;
            clip.setMicrosecondPosition(c);
            this.play();

        }
    }

    public void resetAudioStream() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
