import java.awt.geom.*;
/**
 * Write a description of class Mudslide here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Mudslide extends Obstacles // lvl 1
{
    // instance variables - replace the example below with your own
    private double constant;

    /**
     * Constructor for objects of class Mudslide
     */
    public Mudslide()
    {
        // initialise instance variables
        constant = generateConstant(); 
    }

    public int healthDecrement()
    {
        return 10;
    }
    
    public int supplyDecrement()
    {
        return 1; 
    }
    
    public boolean succeedOrFail(Player player)
    {
        constant = generateConstant();
        if(constant*player.getHealth() + constant*player.getSupplies() >= 20)
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
