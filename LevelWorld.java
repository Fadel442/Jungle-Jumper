import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelWorld extends World
{
    private Jumper jumper;
    private Gate gate;
    private boolean isGameOver = false;
    private boolean areCoinsCleared = false;
    private boolean isJumperTouchingGate = false;
    
    private GreenfootSound backgroundSound;

    /**
     * Constructor for objects of class LevelWorld.
     * 
     */
    public LevelWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 450, 1);
        
        setPaintOrder(Platform.class, Jumper.class, Gate.class);
        prepare();
    }
    
    private void prepare() {
        jumper = new Jumper();
        addObject(jumper, 80, 100);
        gate = new Gate();
        addObject(gate, 478, 334);
        
        addCoin();
        addPlatform();
    }
    
    public void act(){
        if (backgroundSound == null) {
                backgroundSound = new GreenfootSound("bgs_jungle.wav");
                backgroundSound.playLoop();
            }
        
        coinCheck();
        gameOverCheck();
    }
    
    private void gameOverCheck() {
        if (isGameOver) {
            if (backgroundSound != null) {
                backgroundSound.stop();
            }
            Greenfoot.delay(100);
            Greenfoot.setWorld(new GameOver());
            Greenfoot.playSound("bgs_gameOver.mp3");
        } 
    }
    
    private void coinCheck() {
        if (!areCoinsCleared) {
            // Periksa apakah semua koin telah dihapus
            areCoinsCleared = areAllCoinsCleared();
            }

            if (areCoinsCleared && jumper.isTouchingGate()) {
            // Berpindah ke LevelWorld setelah semua koin dihapus dan karakter menyentuh Gate
            backgroundSound.stop();
            Greenfoot.setWorld(new WorldTiga());
            }
    }
    
    public void gameOver() {
        isGameOver = true;
    }
    
    public boolean areAllCoinsCleared() {
        return getObjects(Coin.class).isEmpty();
    }
    
    public void setCoinsClearedStatus(boolean cleared) {
        areCoinsCleared = cleared;
    }
    
    private void addCoin() {
        Coin coin1 = new Coin();
        addObject(coin1, 160, 320);
        
        Coin coin2 = new Coin();
        addObject(coin2, 645, 110);
        
        Coin coin3 = new Coin();
        addObject(coin3, 700, 350);
    }
    
    private void addPlatform() {
        //Horizontal Tiles
        Tiles tiles1 = new Tiles();
        addObject(tiles1, 95, 140);
        
        Tiles tiles2 = new Tiles();
        addObject(tiles2, 160, 350);
        
        Tiles tiles3 = new Tiles();
        addObject(tiles3, 435, 215);

        Tiles tiles4 = new Tiles();
        addObject(tiles4, 478, 374);
        
        Tiles tiles5 = new Tiles();
        addObject(tiles5, 645, 140);
        
        Tiles tiles6 = new Tiles();
        addObject(tiles6, 700, 380);
        
        //Vertical Tiles
        Viles viles1 = new Viles();
        addObject(viles1, 285, 235);
        
        Viles viles2 = new Viles();
        addObject(viles2, 615, 280);
        
        //Death Tiles
        Diles diles1 = new Diles(0, 0);
        addObject(diles1,705, 190);
        
        Diles diles2 = new Diles(80, 150);
        addObject(diles2,120, 220);        
        //
        Wiles wiles1 = new Wiles(150,325);
        addObject(wiles1, 335, 235);
        
        Wiles wiles2 = new Wiles(120,250);
        addObject(wiles2, 555, 190);
        
        //End Tiles
        StartPlatform platform = new StartPlatform();
        addObject(platform, getWidth()/2, getHeight());
    }
}
