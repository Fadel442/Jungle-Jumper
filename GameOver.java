import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameOver extends UI
{
    private GreenfootImage bgImage;
    
    public GameOver()
    {
        bgImage = new GreenfootImage("bg_gameover.png");
        bgImage.scale(getWidth(), getHeight());
        setBackground(bgImage); 
        
        addObject(new lg_GameOver(), getWidth()/2, 150);
        
        btn_restart restart = new btn_restart();
        addObject(restart, getWidth() / 2, 355);
        //showText("Game Over", getWidth() / 2, getHeight() / 2);
    }
}
