import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
        Greenfoot.delay(100);
        Greenfoot.setWorld(newWorld);
    }
}
