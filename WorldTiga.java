import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class WorldTiga extends World
{
    private Jumper jumper;
    private Gate gate;
    private boolean isGameOver = false;
    private boolean areCoinsCleared = false;
    private boolean isJumperTouchingGate = false;
    
    private GreenfootSound backgroundSound;
    private GreenfootImage bgImage;

    /**
     * Constructor for objects of class WorldTiga.
     * 
     */
    public WorldTiga()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 450, 1);
        bgImage = new GreenfootImage("Trees 3.png");
        bgImage.scale(getWidth(), getHeight());
        setBackground(bgImage);
        
        setPaintOrder(Platform.class, Jumper.class, Gate.class);
        prepare();
    }
    
    private void prepare() {
        jumper = new Jumper();
        addObject(jumper, getWidth() / 2, 115);
        gate = new Gate();
        addObject(gate,525, 285);
        
        addCoin();
        addPlatform();
    }
    
    public void act() {
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
            areCoinsCleared = areAllCoinsCleared();
            }

            if (areCoinsCleared && jumper.isTouchingGate()) {
            backgroundSound.stop();
            Greenfoot.setWorld(new Win());
            Greenfoot.playSound("sfx_win.mp3");
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
        addObject(coin1, 103, 105);
        
        Coin coin2 = new Coin();
        addObject(coin2, 385, 365);
        
        Coin coin3 = new Coin();
        addObject(coin3, 655, 85);
    }
    
    private void addPlatform() {
        //Horizontal Tiles
        Tiles tiles1 = new Tiles();
        addObject(tiles1, getWidth() / 2, 150);
        
        Tiles tiles2 = new Tiles();
        addObject(tiles2, 286, 275);
        
        Tiles tiles3 = new Tiles();
        addObject(tiles3, 103, 403);
        
        Tiles tiles4 = new Tiles();
        addObject(tiles4, 103, 135);
        
        Tiles tiles5 = new Tiles();
        addObject(tiles5, 655, 115);
        
        Tiles tiles6 = new Tiles();
        addObject(tiles6, 715, 375);
        
        Tiles tiles7 = new Tiles();
        addObject(tiles7, 525, 325);
        
        Tiles tiles8 = new Tiles();
        addObject(tiles8, 385, 395);
        
        //vertical Tile
        Viles viles1 = new Viles();
        addObject(viles1,40, 275);
        
        Viles viles2 = new Viles();
        addObject(viles2,525, 135);
        
        //Death Tiles
        Diles diles1 = new Diles(0,0);
        addObject(diles1,525, 355 );
        
        //Diles diles2 = new Diles(430,580);
        //addObject(diles2,450, 225 );
        
        Wiles wiles1 = new Wiles(210, 300);
        addObject(wiles1,133, 235);
        
        Wiles wiles2 = new Wiles(190, 300);
        addObject(wiles2,685, 210);
        
        //End Tiles
        StartPlatform platform = new StartPlatform();
        addObject(platform, getWidth()/2, getHeight());
    }
}
