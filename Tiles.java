import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tiles extends Platform
{
    /**
     * Act - do whatever the Tiles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Tiles() {
        // Ganti ukuran platform sesuai keinginan
        GreenfootImage platformImage = new GreenfootImage(100, 20);
        platformImage.setColor(Color.BLUE); // Ganti warna platform sesuai keinginan
        platformImage.fill();
        setImage(platformImage);
    }
    public void act()
    {
        // Add your action code here.
    }
}
