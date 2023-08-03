import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Win here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Win extends UI
{
    private GreenfootImage bgImage;
    
    public Win()
    {
        bgImage = new GreenfootImage("bg_win.png");
        bgImage.scale(getWidth(), getHeight());
        setBackground(bgImage);
        
        addObject(new lg_Win(), getWidth()/2, 150);
        
        btn_quit quit = new btn_quit();
        addObject(quit, 550, 355);
        
        btn_restart restart = new btn_restart();
        addObject(restart, 250, 355);
        //showText("Win!", getWidth() / 2, getHeight() / 2);
    }
}
