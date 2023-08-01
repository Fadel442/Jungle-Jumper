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
        int coinSpacing = 2; // Jarak antar koin (ganti angka ini sesuai keinginan)
    int coinWidth = coinImage.getWidth(); // Mengambil lebar pixel gambar koin asli
    int totalWidth = coins * coinWidth + (coins - 1) * coinSpacing;
    int startX = (getImage().getWidth() - totalWidth) / 2;

    for (int i = 0; i < coins; i++) {
        int x = startX + (coinWidth + coinSpacing) * i;
        image.drawImage(coinImage, x, 0); // Menggambar koin secara berderet dengan jarak yang telah ditentukan
    }
        setImage(image);
    }

    public int getCoins() {
        return coins;
    }
}
