package org.example;
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

    public void resumeAudio(String pathName) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if (status.equals("play")) {
            System.out.println("Audio is already being played");
        }
        clip.close();
        resetAudioStream(pathName);
        clip.setMicrosecondPosition(currentFrame);
        this.play();
    }

    public void restart(String pathName) throws IOException, LineUnavailableException, UnsupportedAudioFileException{
        clip.stop();
        clip.close();
        resetAudioStream(pathName);
        currentFrame = 0L;
        clip.setMicrosecondPosition(0);
        this.play();
    }

    public void stop() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        currentFrame = 0L;
        clip.stop();
        clip.close();
    }

    public void jump(long c, String pathName) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        if (c>0&&c<clip.getMicrosecondLength()){
            clip.stop();
            clip.close();
            resetAudioStream(pathName);
            currentFrame=c;
            clip.setMicrosecondPosition(c);
            this.play();

        }
    }

    public void resetAudioStream(String pathName) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        audioInputStream = AudioSystem.getAudioInputStream(new File(pathName).getAbsoluteFile());
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
