import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class btn_restart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class btn_restart extends Button
{
    public btn_restart() {
        GreenfootImage image = new GreenfootImage("btn_restart.png");
        setImage(image);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            restartGame();
        }
    }

    private void restartGame() {
        World currentWorld = getWorld();
        World newWorld = new MyWorld(); 
        Greenfoot.setWorld(newWorld);
    }
}
