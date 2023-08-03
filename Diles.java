import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Diles extends Platform
{
    private int leftWidth; 
    private int rightWidth; 
    private int speed = 1; 
    private GreenfootImage platformImage;
    
    private GreenfootSound screamSound;
    /**
     * Act - do whatever the Diles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Diles(int leftWidth, int rightWidth) {
        this.leftWidth = leftWidth;
        this.rightWidth = rightWidth;
        
        GreenfootImage platformImage = new GreenfootImage("death_horizontal_tiles.png");
        setImage(platformImage);
        
        screamSound = new GreenfootSound("sfx_scream.mp3");
    }
    
    public void act()
    {
        setLocation(getX() + speed, getY());
        if (getX() <= leftWidth || getX() >= rightWidth) {
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
