import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CoinBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CoinBar extends Actor
{
    private int coins;
    private GreenfootImage coinImage;

    public CoinBar() {
        coins = 0;
        coinImage = new GreenfootImage("coin.png"); // Gambar koin
        updateImage();
    }

    public void addCoin() {
        coins++;
        updateImage();
    }

    private void updateImage() {
        GreenfootImage image = new GreenfootImage(getImage());
        image.clear();
        for (int i = 0; i < coins; i++) {
            image.drawImage(coinImage, i * (coinImage.getWidth() + 5), 0); // Menggambar koin secara berderet
        }
        setImage(image);
    }

    public int getCoins() {
        return coins;
    }
}
