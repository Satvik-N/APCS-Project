import java.awt.geom.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.Point;
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
    public Mudslide(int x, int y)
    {
        // initialise instance variables
        constant = 0;
        changeLocation(x, y); 
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

}
