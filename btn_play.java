import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class btn_play extends Button
{
    public btn_play() {
        GreenfootImage image = new GreenfootImage("btn_play.png");
        setImage(image);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            playGame();
        }
    }

    private void playGame() {
        World currentWorld = getWorld();
        World newWorld = new MyWorld(); 
        Greenfoot.setWorld(newWorld);
    }
}
