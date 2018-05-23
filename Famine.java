import java.awt.geom.*;
/**
 * Write a description of class Famine here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Famine extends Obstacles // lvl 3
{
    // instance variables - replace the example below with your own
    private double constant;

    /**
     * Constructor for objects of class Storm
     */
    public Famine()
    {
        // initialise instance variables
        constant = generateConstant(); 
    }
    
    public int healthDecrement()
    {
        return 30;
    }
    
    public int supplyDecrement()
    {
        return 3; 
    }
    
    public boolean succeedOrFail()
    {
        constant = generateConstant();
        if(constant*player.getHealth() + constant*player.getSupplies() >= 60)
            return true;
        return false; 
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
