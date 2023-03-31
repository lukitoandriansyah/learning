package JavaObjectOriented.SimpleAudioPlayer.src.main.java.org.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class SimpleAudioPlayer extends Option {

    public SimpleAudioPlayer() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);

    }

    private void optionMenu(int inputOption) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        switch (inputOption) {
            case 1 -> pause();
            case 2 -> resumeAudio();
            case 3 -> restart();
            case 4 -> stop();
            case 5 -> {
                System.out.println("Enter time (" + 0 + ", " + clip.getMicrosecondLength() + ")");
                Scanner scanner = new Scanner(System.in);
                long input = scanner.nextLong();
                jump(input);
            }
        }

    }


    public static void main(String[] args) {

        Data data = new Data();

        try {
            data.filePath = "D:/upload music/Arc Revise without piano.wav";
            SimpleAudioPlayer simpleAudioPlayer = new SimpleAudioPlayer();
            simpleAudioPlayer.play();
            Scanner scanner = new Scanner(System.in);


            while (true) {
                System.out.println("1. pause");
                System.out.println("2. resume");
                System.out.println("3. restart");
                System.out.println("4. stop");
                System.out.println("5. Jump to specific");

                int c = scanner.nextInt();
                simpleAudioPlayer.optionMenu(c);
                if (c == 4) {
                    break;
                }
            }

        } catch (Exception exception) {
            System.out.println("Error with playing sound");
            exception.printStackTrace();
        }
    }
}