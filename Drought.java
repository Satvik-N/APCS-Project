import java.awt.geom.*;
/**
 * Write a description of class Drought here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Drought extends Obstacles // lvl 4
{
    // instance variables - replace the example below with your own
    private double constant;

    /**
     * Constructor for objects of class Storm
     */
    public Drought()
    {
        // initialise instance variables
        constant = generateConstant(); 
    }
    
    public int healthDecrement()
    {
        return 40;
    }
    
    public int supplyDecrement()
    {
        return 4; 
    }
    
    public boolean succeedOrFail()
    {
        constant = generateConstant();
        if(constant*player.getHealth() + constant*player.getSupplies() >= 80)
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
