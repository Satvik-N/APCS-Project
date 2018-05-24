import java.awt.geom.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.Point;
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
    public Animal(int x, int y)
    {
        // initialise instance variables
        constant = 0; 
        changeLocation(x, y); 
    }
    
    public int healthDecrement()
    {
        return 20;
    }
    
    public int supplyDecrement()
    {
        return 2;
    }
    
    public boolean succeedOrFail(Player player)
    {
        constant = generateConstant();
        if(constant*player.getHealth() + constant*player.getSupplies() >= 40)
            return true;
        return false; 
    }

}
