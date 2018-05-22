import java.awt.geom.*;
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
     * Constructor for objects of class Storm
     */
    public Drought()
    {
        // initialise instance variables
        x = 0;
    }
    
    public int healthDecrement()
    {
        return 0;
    }
    
    public void supplyDecrement()
    {
        
    }
    
    public boolean succeedOrFail()
    {
        return true;
    }
    
    public void movePlayer()
    {
        
    }
    
    public Point2D.Double currentLocation()
    {
        return null;
    }
    
    public void changeLocation(double x, double y)
    {
        
    }
}
