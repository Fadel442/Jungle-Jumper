import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MainMenu extends UI
{
    private GreenfootImage bgImage;

    public MainMenu()
    {
        bgImage = new GreenfootImage("main_menu.png");
        bgImage.scale(getWidth(), getHeight());
        setBackground(bgImage);  
        
        addObject(new lg_MainMenu(), getWidth()/2, 150);
        
        btn_play play = new btn_play();
        addObject(play, getWidth() / 2, 355);
    }
}
