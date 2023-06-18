package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class SimpleAudioPlayer extends Option {

    public SimpleAudioPlayer(String pathName) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        audioInputStream = AudioSystem.getAudioInputStream(new File(pathName).getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);

    }

    private void optionMenu(int inputOption, String pathName) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        switch (inputOption) {
            case 1 -> pause();
            case 2 -> resumeAudio(pathName);
            case 3 -> restart(pathName);
            case 4 -> stop();
            case 5 -> {
                System.out.println("Enter time (" + 0 + ", " + clip.getMicrosecondLength() + ")");
                Scanner scanner = new Scanner(System.in);
                long input = scanner.nextLong();
                jump(input,pathName);
            }
        }

    }


    public static void main(String[] args) {

        try {
            Data data = new Data();
            data.filePath = "D://thankYouMyFriend/Raw_music_thank_you_my_friend.wav";
            System.out.println(data.filePath);
            SimpleAudioPlayer simpleAudioPlayer = new SimpleAudioPlayer(data.filePath);
            simpleAudioPlayer.play();
            Scanner scanner = new Scanner(System.in);


            while (true) {
                System.out.println("1. pause");
                System.out.println("2. resume");
                System.out.println("3. restart");
                System.out.println("4. stop");
                System.out.println("5. Jump to specific");

                int c = scanner.nextInt();
                simpleAudioPlayer.optionMenu(c, data.filePath);
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