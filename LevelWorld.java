import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelWorld extends World
{
    private Jumper jumper;

    /**
     * Constructor for objects of class LevelWorld.
     * 
     */
    public LevelWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 450, 1);
        
        prepare();
    }
    
    private void prepare() {
        jumper = new Jumper();
        addObject(jumper, 80, 100);
        
        addPlatform();
    }
    
    private void addPlatform() {
        Tiles tiles1 = new Tiles();
        addObject(tiles1, 80, 140);
        
        
    }
}
