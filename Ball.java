import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author Kai668
 * @version 10/12/2021
 */
public class Ball extends Actor
{
    //sets as ints
    private int dX = 4;
    private int dY = 4;
    private int point;
    private int bounceDelayTime;
    private int bounceDelayCounter;
    private int startDelayTime;
    private int startDelayCounter;
    /**
     * Sets the delay for bounce.
     */
    public void bounceDelayTime(int bounceTime)
    {
        bounceDelayTime = bounceTime;
    }
    
    /**
     * Sets delay for Start.
     */
    public void startDelayTime(int startTime)
    {
        startDelayTime = startTime;
    }
    
    /**
     * Ball
     */
    public Ball()
    {
        bounceDelayTime = 30;
        bounceDelayCounter = 0;
        startDelayTime = 30;
        startDelayCounter = 0;
    }
    
    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        startDelayCounter++; //tallies start delay count
        if (startDelayCounter >= startDelayTime)
        {
            move();
        }
        checkForBounce();
        paddleBounce();
        soundEffect();
        score();
        win();
        bounceDelayCounter++; //tallies bounce delay count
    }
    
    /**
     * Sets sound when it hits the paddle.
     */
    public void soundEffect()
    {
        if (isTouching(paddle.class))
        {
            GreenfootSound correct = new GreenfootSound("correct.mp3");
            correct.play();
        }
    }
    
    /**
     * Moves the ball.
     */
    public void move()
    {
        setLocation(getX() + dX, getY() + dY);
    }
    
    /**
     * If it touches the left/right it tallies up points, sets back to center,
     * and allows for the ball to pause when it resets to the center.
     */
    public void score()
    {
        if (getX() <= 0 || getX() >= getWorld().getWidth()-1)
        {
            point++;
            setLocation(getWorld().getWidth()/2, getWorld().getHeight()/2);
            startDelayCounter = 0;
        }
    }
    
    /**
     * Stops the game when one player reaches a certain amount of points.
     */
    public void win()
    {
        if (point >= 8) 
        {
            Greenfoot.stop();    
        }
    }
    
    /**
     * Helps the ball bounce off the paddle after a certain amount of time.
     * When it bounces, it can't bounce again after a certain amount of time.
     */
    public void paddleBounce()
    {
        if (bounceDelayCounter >= bounceDelayTime)
        {
            if (isTouching(paddle.class))
            {
                dX = -dX;
                dY = dY;
                bounceDelayCounter = 0;
            }
        }
    }
    
    /**
     * Checks to see if the ball is touching top and bottom of the world.
     * touch = bounce.
     */
    public void checkForBounce()
    {
    if (getX() <= 0 || getX() >= getWorld().getWidth()-1) 
        {
            dX = -dX;
        }
        
    if (getY() <= 0 || getY() >= getWorld().getHeight()-1) 
        {
            dY = -dY;
        }
    }
}
