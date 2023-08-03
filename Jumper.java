import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Jumper extends Actor
{
    private int verticalSpeed = 0;
    private int jumpStrength = -15; 
    private int acceleration = 1; 
    private int moveSpeed = 4; 
    private int moveVertical = 4;
    private boolean onGround = false;
    private boolean onVerticalPlatform = false; 
    
    private CoinBar[] coinBars;
    
    private GreenfootSound jumpSound;
    
    private GreenfootSound getCoinSound;
    
    public Jumper() {
        coinBars = new CoinBar[3];
    
        jumpSound = new GreenfootSound("sfx_jump.mp3");
        getCoinSound = new GreenfootSound("sfx_coin.mp3");
    }

    public void act() {
        applyGravity();
        checkKeys();
        checkCollision();
        checkCoinCollision();
    }

    private void applyGravity() {
        if (!onGround) {
            verticalSpeed += acceleration;
        }
        setLocation(getX(), getY() + verticalSpeed);
    }

    private void checkKeys() {
        if (Greenfoot.isKeyDown("space") && onGround) {
            jump();
            jumpSound.play();
            //setLocation(getX(), getY()+1);
        }
        
        else if(Greenfoot.isKeyDown("up") && onVerticalPlatform) {
            moveUpDown();
            setLocation(getX(), getY() - 1);
        }
        
        else if(Greenfoot.isKeyDown("down") && onVerticalPlatform) {
            moveUpDown(); 
            setLocation(getX(), getY() + 1);
        }

        else if (Greenfoot.isKeyDown("left")) {
            move(-moveSpeed); 
            //setLocation(getX() - 1, getY());
        }

        else if (Greenfoot.isKeyDown("right")) {
            move(moveSpeed); 
            //setLocation(getX() + 1, getY());
        }
    }

    private void jump() {
        verticalSpeed = jumpStrength;
        onGround = false;
    }
    
    private void moveUpDown() {
        verticalSpeed = moveVertical; 
        onGround = false;
        onVerticalPlatform = false; 
    }

    private void checkCollision() {
        if (isTouching(Platform.class) && verticalSpeed >= 0) {
            verticalSpeed = 0;
            onGround = true;
        } 
        else {
            onGround = false;
        }
        
        if (isTouching(Viles.class) && verticalSpeed >= 0) {
            verticalSpeed = 0;
            onGround = true;
            onVerticalPlatform = true; 
        }
    }
    
    private void checkCoinCollision() {
        Actor coin = getOneIntersectingObject(Coin.class);
        if (coin != null) {
            World world = getWorld();
            getCoinSound.play();
            world.removeObject(coin);

            for (int i = 0; i < coinBars.length; i++) {
                if (coinBars[i] == null || coinBars[i].getCoins() == 0) {
                    if (coinBars[i] == null) {
                        coinBars[i] = new CoinBar();
                        world.addObject(coinBars[i], 100 + i * 45, 55); // Atur posisi coinBar 
                    }
                    coinBars[i].addCoin();
                    break;
                }
            }
        }
    }
    
    public boolean isTouchingGate() {
        return isTouching(Gate.class);
    }
    
    public void die() {
        World currWorld = getWorld();
        
        if(currWorld instanceof MyWorld) {
            ((MyWorld) getWorld()).gameOver();
        } 
        else if(currWorld instanceof LevelWorld) {
            ((LevelWorld) getWorld()).gameOver();
        }
        else if(currWorld instanceof WorldTiga) {
            ((WorldTiga) getWorld()).gameOver();
        }
        getWorld().removeObject(this); 
    }
}
