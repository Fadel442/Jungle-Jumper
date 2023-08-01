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
        //checkCompletion();
        //checkCollisionWithJumper();
    }
    
    private void checkCollisionWithJumper() {
        Actor jumper = getOneIntersectingObject(Jumper.class);
        if (jumper != null) {
            // Hapus objek Gate saat karakter menyentuhnya
            getWorld().removeObject(this);
            // Panggil method setCoinsClearedStatus() dari kelas MyWorld dan set nilai menjadi true
            MyWorld world = (MyWorld) getWorld();
            world.setCoinsClearedStatus(true);
        }
    }


    private void checkCompletion() {
        MyWorld world = (MyWorld) getWorld();
        if (world.areAllCoinsCleared()) {
            world.moveToNextLevel();
        }
    }
}
