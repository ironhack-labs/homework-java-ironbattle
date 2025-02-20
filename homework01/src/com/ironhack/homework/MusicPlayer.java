package com.ironhack.homework;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayer {
    private Clip clip;
    private File audioFile;
    private AudioInputStream audioStream;
    private boolean isPlaying;

    public MusicPlayer(String filePath) {
        this.audioFile = new File(filePath);
        loadFile();
    }

    private void loadFile() {
        try {
            if (clip != null) {
                clip.close();
            }
            audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void setFile(String filePath) {
        this.audioFile = new File(filePath);
        loadFile();
        if (isPlaying) {
            startPlaying();
        }
    }

    public void startPlaying() {
        if (clip != null) {
            clip.start();
            isPlaying = true;
        }
    }

    public void pause() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            isPlaying = false;
        }
    }

    public void stopPlaying() {
        if (clip != null) {
            clip.stop();
            clip.close();
            try {
                audioStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            isPlaying = false;
        }
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer("path/to/your/audio/file1.wav");        player.startPlaying();
        // Wait for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        player.pause();
        // Wait for 2 seconds
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        player.setFile("path/to/your/audio/file2.wav");
        player.startPlaying();
        // Wait for 5 seconds

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        player.stopPlaying();
    }
}