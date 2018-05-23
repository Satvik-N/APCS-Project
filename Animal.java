import java.awt.geom.*;
/**
 * Write a description of class Animal here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Animal extends Obstacles // lvl 2
{
    // instance variables - replace the example below with your own
    private double constant;

    /**
     * Constructor for objects of class Storm
     */
    public Animal()
    {
        // initialise instance variables
        constant = generateConstant(); 
    }
    
    public int healthDecrement()
    {
        return 20;
    }
    
    public int supplyDecrement()
    {
        return 2;
    }
    
    public boolean succeedOrFail()
    {
        constant = generateConstant();
        if(constant*player.getHealth() + constant*player.getSupplies() >= 40)
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
