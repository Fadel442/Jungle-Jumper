import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class StartPlatform extends Platform
{
    private GreenfootSound deadSound;
    private GreenfootImage platformImage;

    public StartPlatform() {
        platformImage = new GreenfootImage("end_tiles.png");
        setImage(platformImage);
        
        deadSound = new GreenfootSound("sfx_water.mp3");
    }
    
    public void act()
    {
        checkCollision();
    }
    
    private void checkCollision() {
        Actor jumper = getOneIntersectingObject(Jumper.class);
        if (jumper != null) {
            deadSound.play();
            ((Jumper) jumper).die();
        }
    }
}
