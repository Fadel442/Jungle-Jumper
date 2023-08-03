import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tiles extends Platform
{
    private GreenfootImage platformImage;
    
    /**
     * Act - do whatever the Tiles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Tiles() {
        platformImage = new GreenfootImage("horizontal_tiles.png");
        setImage(platformImage);
    }
    public void act()
    {
        // Add your action code here.
    }
}
