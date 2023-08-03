import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Viles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Viles extends Platform
{
    private GreenfootImage platformImage;
    
    /**
     * Act - do whatever the Viles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Viles() {
        platformImage = new GreenfootImage("wood_tile.png");
        setImage(platformImage);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
