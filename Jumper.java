import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jumper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jumper extends Actor
{
    /**
     * Act - do whatever the Jumper wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int verticalSpeed = 0;
    private int jumpStrength = -15; // Kekuatan lompatan
    private int acceleration = 1; // Kecepatan gravitasi
    private int moveSpeed = 4; // Kecepatan bergerak ke kiri dan kanan
    private int moveVertical = 4;
    private boolean onGround = false;
    private boolean onVerticalPlatform = false; 
    
    private CoinBar[] coinBars;
    
    private GreenfootSound jumpSound;
    
    private GreenfootSound getCoinSound;
    
    public Jumper() {
        coinBars = new CoinBar[3];
        // Inisialisasi coinBars dengan referensi ke tiga CoinBar
        jumpSound = new GreenfootSound("sfx_jump.mp3");
        getCoinSound = new GreenfootSound("sfx_coin.mp3");
        
    }

    public void act() {
        applyGravity();
        checkKeys();
        checkCollision();
        checkCoinCollision();
        //checkBottomBoundary();
        
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
            moveUpDown(); // Bergerak ke bawah
            setLocation(getX(), getY() + 1);
        }

        else if (Greenfoot.isKeyDown("left")) {
            move(-moveSpeed); // Bergerak ke kiri
            //setLocation(getX() - 1, getY());
        }

        else if (Greenfoot.isKeyDown("right")) {
            move(moveSpeed); // Bergerak ke kanan
            //setLocation(getX() + 1, getY());
        }
    }

    private void jump() {
        verticalSpeed = jumpStrength;
        onGround = false;
    }
    
    private void moveUpDown() {
        verticalSpeed = moveVertical; // Mengatur kecepatan vertikal untuk bergerak ke bawah
        onGround = false;
        onVerticalPlatform = false; // Reset penanda saat bergerak ke bawah
    }

    private void checkCollision() {
        // Cek apakah karakter menyentuh platform di bagian bawahnya
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
            onVerticalPlatform = true; // Set penanda saat berada di atas VerticalPlatform
        }
    }
    
    // private void chceckGateCollision() {
        // Actor gate = getOneIntersectingObject(Gate.class);
    // }
    
    private void checkCoinCollision() {
        Actor coin = getOneIntersectingObject(Coin.class);
        if (coin != null) {
            World world = getWorld();
            getCoinSound.play();
            world.removeObject(coin);

            // Cek coinBar mana yang kosong dan tambahkan koin ke coinBar tersebut
            for (int i = 0; i < coinBars.length; i++) {
                if (coinBars[i] == null || coinBars[i].getCoins() == 0) {
                    if (coinBars[i] == null) {
                        coinBars[i] = new CoinBar();
                        world.addObject(coinBars[i], 100 + i * 75, 50); // Atur posisi coinBar yang baru
                    }
                    coinBars[i].addCoin();
                    break;
                }
            }
        }
    }
    
    // private void checkBottomBoundary() {
        // if (getY() >= getWorld().getHeight()) {
            // // Karakter menyentuh batas bawah, panggil metode karakter mati
            // die();
        // }
    // }
    
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
        // Aksi ketika karakter mati
        //((MyWorld) getWorld()).gameOver();
        //((LevelWorld) getWorld()).gameOver();
        getWorld().removeObject(this); // Hapus karakter dari dunia
        //Greenfoot.setWorld(new GameOverWorld()); // Ganti ke dunia game over
    }
}
