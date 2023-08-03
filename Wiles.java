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
    
    private int topHeight; // Nilai tinggi atas
    private int bottomHeight; // Nilai tinggi bawah
    private int speed = 1; // Kecepatan pergerakan
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
            speed = -speed; // Ubah arah pergerakan saat mencapai batasan
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
