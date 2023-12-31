import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class CoinBar extends Actor
{
    private int targetCoins;
    private int coins;
    private GreenfootImage coinImage;

    public CoinBar() {
        coins = 0;
        coinImage = new GreenfootImage("apple1.png"); 
        updateImage();
    }

    public void addCoin() {
        coins++;
        updateImage();
    }
    
    public boolean isFilled() {
        return coins >= targetCoins;
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
