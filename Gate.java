import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gate extends Actor
{
    /**
     * Act - do whatever the Gate wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        checkCompletion();
    }
    
    

    private void checkCompletion() {
        MyWorld world = (MyWorld) getWorld();
        if (world.areAllCoinsCleared()) {
            world.moveToNextLevel();
        }
    }
}
