import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class btn_quit extends Button
{
    public btn_quit() {
        GreenfootImage image = new GreenfootImage("btn_quit.png");
        setImage(image);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            quitGame();
        }
    }

    private void quitGame() {
        Greenfoot.stop();
    }
}
