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
    private boolean onGround = false;
    
    private CoinBar[] coinBars;
    
    public Jumper() {
        coinBars = new CoinBar[3];
        // Inisialisasi coinBars dengan referensi ke tiga CoinBar
    }

    public void act() {
        applyGravity();
        checkKeys();
        checkCollision();
        checkCoinCollision();
        checkBottomBoundary();
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
            //setLocation(getX(), getY()+1);
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

    private void checkCollision() {
        // Cek apakah karakter menyentuh platform di bagian bawahnya
        if (isTouching(Platform.class) && verticalSpeed >= 0) {
            verticalSpeed = 0;
            onGround = true;
        } 
        else {
            onGround = false;
        }
    }
    
    private void checkCoinCollision() {
        Actor coin = getOneIntersectingObject(Coin.class);
        if (coin != null) {
            World world = getWorld();
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
    
    private void checkBottomBoundary() {
        if (getY() >= getWorld().getHeight()) {
            // Karakter menyentuh batas bawah, panggil metode karakter mati
            die();
        }
    }
    
    public void die() {
        // Aksi ketika karakter mati
        //Greenfoot.playSound("game-over.wav"); // Mainkan suara game over
        getWorld().removeObject(this); // Hapus karakter dari dunia
        //Greenfoot.setWorld(new GameOverWorld()); // Ganti ke dunia game over
    }
}
