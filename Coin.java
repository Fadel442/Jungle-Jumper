import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Coin extends Actor
{
    private GreenfootSound getCoinSound;
    
    public void act()
    {
        checkCollision();
    }
    
    private void checkCollision() {
        Actor jumper = getOneIntersectingObject(Jumper.class);
        if (jumper != null) {
            World world = getWorld();
            world.removeObject(this); 
        }
    }
}
