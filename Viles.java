import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Viles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Viles extends Platform
{
    /**
     * Act - do whatever the Viles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Viles() {
        GreenfootImage platformImage = new GreenfootImage(30, 125);
        platformImage.setColor(Color.RED); 
        platformImage.fill();
        setImage(platformImage);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
