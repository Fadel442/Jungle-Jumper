import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Diles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Diles extends Platform
{
    /**
     * Act - do whatever the Diles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Diles() {
        // Ganti ukuran platform sesuai keinginan
        GreenfootImage platformImage = new GreenfootImage(150, 20);
        platformImage.setColor(Color.YELLOW); // Ganti warna platform sesuai keinginan
        platformImage.fill();
        setImage(platformImage);
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
            ((Jumper) jumper).die();
        }
    }
}
