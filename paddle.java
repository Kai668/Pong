import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class paddle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class paddle extends Actor
{
    private boolean isKeyDown;
    private String up;
    private String down;
    private int dY = 4;
    private int dX = 4;
    int paddleType;
    /**
     * Move the paddels up and down
     */
    public paddle(int paddleType)
    {
        this.paddleType = paddleType;
    }

    /**
     * Act - do whatever the paddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        keyCheck();
    }

    public void keyCheck()
    {
        if(paddleType == 1)
        {
            if(Greenfoot.isKeyDown("s"))
            {
                setLocation(getX() , getY() + dY);
            }
            if(Greenfoot.isKeyDown("w"))
            {
                setLocation(getX() , getY() - dY);   
            }
        }
        
        if(paddleType == 2)
        {
            if(Greenfoot.isKeyDown("down"))
            {
                setLocation(getX() , getY() + dY);
            }
            if(Greenfoot.isKeyDown("up"))
            {
                setLocation(getX() , getY() - dY);   
            }
        }
    }
}
