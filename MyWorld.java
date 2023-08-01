import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private Jumper jumper;
    private int cameraOffsetX;
    private int cameraOffsetY;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 450, 1); 
        prepare();
    }
    
    private void prepare() {
        jumper = new Jumper();
        addObject(jumper, getWidth() - 720, getHeight() - 225); // Letakkan Jumper di bawah layar pada posisi tengah

        addPlatforms();
        coin();
    }
    
    // public void act() {
        // // Mengatur offset kamera secara horizontal mengikuti pergerakan karakter
        // cameraOffsetX = getWidth() / 2 - jumper.getX();

        // // Batasi pergeseran kamera agar tetap dalam batas dunia
        // int worldWidth = getWidth();
        // int worldHeight = getHeight();
        // int halfWidth = worldWidth / 2;

        // // Batasi pergeseran kamera agar tidak keluar dari batas layar kiri dan kanan
        // if (cameraOffsetX > 0) {
            // cameraOffsetX = 0;
        // } else if (cameraOffsetX < -(worldWidth - halfWidth)) {
            // cameraOffsetX = -(worldWidth - halfWidth);
        // }

        // // Menggeser seluruh dunia dengan offset kamera
        // shiftWorld();
    // }

    // private void shiftWorld() {
        // for (Object obj : getObjects(null)) {
            // Actor actor = (Actor) obj;
            // actor.setLocation(actor.getX() + cameraOffsetX, actor.getY());
        // }
    // }
    
    private void coin() {
        Coin coin1 = new Coin();
        addObject(coin1, 180, 360 );
    }
    
    private void addPlatforms() {
        int startingY = getHeight() - 100;
        int startingX = getWidth() - 700;
        
        StartPlatform platform = new StartPlatform();
        //addObject(platform, getWidth() / 2, getHeight());
        
       // for(int i = 0; i < 3; i++){
        //    Tiles tiles = new Tiles();
        //    addObject(tiles, startingX , startingY - (i * 135));
        //}
        
        Tiles tiles1 = new Tiles();
        addObject(tiles1, 80, 287);
        
        Tiles tiles2 = new Tiles();
        addObject(tiles2, 180, 394);
        
        Tiles tiles3 = new Tiles();
        addObject(tiles3, 226, 140);
        
        Tiles tiles4 = new Tiles();
        addObject(tiles4, 344, 316);
        
        Tiles tiles5 = new Tiles();
        addObject(tiles5, 500, 165);
        
        Tiles tiles6 = new Tiles();
        addObject(tiles6, 515, 366);
        
        Tiles tiles7 = new Tiles();
        addObject(tiles7, 650, 415);
        
        Tiles tiles8 = new Tiles();
        addObject(tiles8, 695, 306);
        
        Tiles tiles9 = new Tiles();
        addObject(tiles9, 625, 85);
        
        Tiles tiles10 = new Tiles();
        addObject(tiles10, 579, 235);
        
        
        Viles viles1 = new Viles();
        addObject(viles1, 389, 155);
        
        Viles viles2 = new Viles();
        addObject(viles2, 729, 185);
    }
}
