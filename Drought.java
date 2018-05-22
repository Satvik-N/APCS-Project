
/**
 * Write a description of class Drought here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Drought extends Obstacles
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Drought
     */
    public Drought()
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
