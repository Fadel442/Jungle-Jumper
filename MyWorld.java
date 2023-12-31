import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    private Jumper jumper;
    private Gate gate;
    
    private boolean areCoinsCleared = false;
    private boolean isJumperTouchingGate = false;
    private boolean isGameStarted = false;
    private boolean isGameOver = false;
    
    private GreenfootSound backgroundSound;
    private GreenfootImage bgImage;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 450, 1); 
        bgImage = new GreenfootImage("Trees 1.png");
        bgImage.scale(getWidth(), getHeight());
        setBackground(bgImage);
        
        setPaintOrder(Platform.class, Jumper.class, Gate.class);
    }
    
     public void act() {
        prep();
        gameOverCheck();
    }
    
    private void prep() {
        if (!isGameStarted && !isGameOver) {
            showText("Press SPACE to Start", getWidth() / 2, getHeight() / 2);
            
            if (Greenfoot.isKeyDown("space")) {
                isGameStarted = true;
                startGame();
            } 
        }   else {
            showText("", getWidth() / 2, getHeight() / 2);

            if (!areCoinsCleared) {
            areCoinsCleared = areAllCoinsCleared();
            }

            if (areCoinsCleared && jumper.isTouchingGate()) {
            backgroundSound.stop();
            Greenfoot.setWorld(new LevelWorld());
            }
            
            if (backgroundSound == null) {
                backgroundSound = new GreenfootSound("bgs_jungle.wav");
                backgroundSound.playLoop();
            }
        }
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
    
    private void startGame() {
        jumper = new Jumper();
        addObject(jumper, getWidth() - 720, getHeight() - 225); 
        gate = new Gate();
        addObject(gate, 625, 45);
        
        setupGame();
    }

    private void setupGame() {
        addPlatforms();
        coin();
    }
    
    public void gameOver() {
        isGameOver = true;
    }
    
    private void coin() {
        Coin coin1 = new Coin();
        addObject(coin1, 180, 360 );
        
        Coin coin2 = new Coin();
        addObject(coin2, 500, 130);
        
        Coin coin3 = new Coin();
        addObject(coin3, 226, 110);
    }
    
    public boolean areAllCoinsCleared() {
        return getObjects(Coin.class).isEmpty();
    }
    
    public void setCoinsClearedStatus(boolean cleared) {
        areCoinsCleared = cleared;
    }
    
    public void moveToNextLevel() {
        Greenfoot.setWorld(new LevelWorld()); 
    }
    
    private void addPlatforms() {
        int startingY = getHeight() - 100;
        int startingX = getWidth() - 700;
        
        StartPlatform platform = new StartPlatform();
        addObject(platform, getWidth()/2, getHeight());
        
        //Horizontal Tiles
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
        
        //Vertical Tiles
        Viles viles1 = new Viles();
        addObject(viles1, 389, 155);
        
        Viles viles2 = new Viles();
        addObject(viles2, 729, 185);
        
        //Death VerTiles
        Wiles wiles1 = new Wiles(0,0);
        addObject(wiles1,256, 340);
    }
}
