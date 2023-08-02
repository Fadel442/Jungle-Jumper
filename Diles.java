import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Diles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Diles extends Platform
{
    private GreenfootSound screamSound;
    /**
     * Act - do whatever the Diles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Diles() {
        GreenfootImage platformImage = new GreenfootImage(150, 20);
        platformImage.setColor(Color.YELLOW);
        platformImage.fill();
        setImage(platformImage);
        
        screamSound = new GreenfootSound("sfx_scream.mp3");
    }
    
    public void act()
    {
        checkCollision();
        // Add your action code here.
    }
    
    private void checkCollision() {
        Actor jumper = getOneIntersectingObject(Jumper.class);
        if (jumper != null) {
            screamSound.play();
            ((Jumper) jumper).die();
        }
    }
}
