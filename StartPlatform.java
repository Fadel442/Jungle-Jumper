import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartPlatform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartPlatform extends Platform
{
    private GreenfootSound deadSound;
    /**
     * Act - do whatever the StartPlatform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public StartPlatform() {
        // Ganti ukuran platform sesuai keinginan
        GreenfootImage platformImage = new GreenfootImage(800, 20);
        platformImage.setColor(Color.GREEN); // Ganti warna platform sesuai keinginan
        platformImage.fill();
        setImage(platformImage);
        
        deadSound = new GreenfootSound("sfx_water.mp3");
    }
    
    public void act()
    {
        checkCollision();
        // Add your action code here.
    }
    
    private void checkCollision() {
        Actor jumper = getOneIntersectingObject(Jumper.class);
        if (jumper != null) {
            // Musuh menyentuh karakter, panggil metode karakter mati
            deadSound.play();
            ((Jumper) jumper).die();
        }
    }
}
