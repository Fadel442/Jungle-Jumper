import greenfoot.*;

public class BackgroundSound {
    private GreenfootSound sound;

    public BackgroundSound(String soundFile) {
        sound = new GreenfootSound(soundFile);
    }

    public void playLoop() {
        if (!sound.isPlaying()) {
            sound.playLoop();
        }
    }

    public void stop() {
        sound.stop();
    }
}