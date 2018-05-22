import java.awt.geom.*;
/**
 * Write a description of class Famine here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Famine extends Obstacles
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Famine
     */
    public Famine()
    {
        // initialise instance variables
        x = 0;
    }

    public abstract int healthDecrement();
    
    public abstract void supplyDecrement();
    
    public abstract boolean succeedOrFail();
    
    public abstract void movePlayer();
    
    public abstract Point2D.Double currentLocation();
    
    public abstract void changeLocation(double x, double y);
}
