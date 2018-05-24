import java.awt.geom.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.Point;
/**
 * Write a description of class Sandstorm here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sandstorm extends Obstacles // lvl 4
{
    // instance variables - replace the example below with your own
    private double constant;
    private Point location; 

    /**
     * Constructor for objects of class Sandstorm
     */
    public Sandstorm(int x, int y)
    {
        // initialise instance variables
        constant = 0;  
        location = new Point(x, y);
    }

    public int healthDecrement()
    {
        return 40;
    }
    
    public int supplyDecrement()
    {
        return 4; 
    }
    
    public boolean succeedOrFail(Player player)
    {
        constant = generateConstant();
        if(constant*player.getHealth() + constant*player.getSupplies() >= 80)
            return true;
        return false; 
    }
    
    public void movePlayer()
    {
        
    }
    
    public Point currentLocation()
    {
        return location; 
    }
    
    public void changeLocation(double x, double y)
    {
        
    }
}
