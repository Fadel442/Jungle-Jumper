import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Diles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Diles extends Platform
{
    private int leftWidth; // Nilai lebar kiri
    private int rightWidth; // Nilai lebar kanan
    private int speed = 1; // Kecepatan pergerakan
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
            speed = -speed; // Ubah arah pergerakan saat mencapai batasan
        }
        
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
