import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wiles extends Platform
{
    private GreenfootSound screamSound;
    
    public Wiles() {
        GreenfootImage platformImage = new GreenfootImage(20, 110);
        platformImage.setColor(Color.BLACK); 
        platformImage.fill();
        setImage(platformImage);
        
        screamSound = new GreenfootSound("sfx_scream.mp3");
    }
    
    public void act()
    {
        checkCollision();
    }
    
    private void checkCollision() {
        Actor jumper = getOneIntersectingObject(Jumper.class);
        if (jumper != null) {
            screamSound.play();
            ((Jumper) jumper).die();
        }
    }
}
