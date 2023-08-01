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

    public void act() {
        applyGravity();
        checkKeys();
        checkCollision();
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
}