import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Wiles extends Platform
{
    private GreenfootSound screamSound;
    
    private int topHeight; 
    private int bottomHeight; 
    private int speed = 1; 
    private GreenfootImage platformImage;
    
    public Wiles(int topHeight, int bottomHeight) {
        this.topHeight = topHeight;
        this.bottomHeight = bottomHeight;
        
        platformImage = new GreenfootImage("death_vertical_tiles.png");
        setImage(platformImage);
        
        screamSound = new GreenfootSound("sfx_scream.mp3");
    }
    
    public void setPlatformImage(String imageFileName) {
        platformImage = new GreenfootImage(imageFileName);
        setImage(platformImage);
    }
    
    public void act()
    {
        setLocation(getX(), getY() + speed);
        if (getY() <= topHeight || getY() >= bottomHeight) {
            speed = -speed; 
        }
        
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
