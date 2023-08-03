import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Actor
{
    private GreenfootSound getCoinSound;
    
    public void act()
    {
        checkCollision();
        // Add your action code here.
    }
    
    private void checkCollision() {
        Actor jumper = getOneIntersectingObject(Jumper.class);
        if (jumper != null) {
            World world = getWorld();
            world.removeObject(this); 
        }
    }
}
