import java.awt.geom.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.Point;
/**
 * Write a description of class Famine here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Famine extends Obstacles // lvl 3
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Storm
     */
    public Famine(int x, int y)
    {
        // initialise instance variables
        changeLocation(x, y); 
    }
    
    public int healthDecrement()
    {
        return 30;
    }
    
    public int supplyDecrement()
    {
        return 3; 
    }
    
    public boolean succeedOrFail(Player player)
    {
        double constant = generateConstant();
        if(constant*player.getHealth() + constant*player.getSupplies() >= 60)
            return true;
        return false; 
    }

}
