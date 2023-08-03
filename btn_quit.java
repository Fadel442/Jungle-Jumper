import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class btn_quit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
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
