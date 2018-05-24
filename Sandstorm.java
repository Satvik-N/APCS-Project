import java.awt.geom.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.Point;
/**
 * Write a description of class Sandstorm here - a Level 4 Obstacle
 *
 * @author Priya K
 * @version 052518
 */
public class Sandstorm extends Obstacles // lvl 4
{
   /**
     * Constructor for objects of class Sandstorm - initializes the location of the sandstorm
     */
    public Sandstorm(int x, int y)
    {
        // initialise instance variables
        changeLocation(x, y); 
    }
    
     /**
   *   If player fails, the health is decremented by 40 
   *
   * @param  none  
   * @return 40 (amount to be decremented from a Level 4 obstacle) 
   */
    public int healthDecrement()
    {
        return 40;
    }
   
     /**
   *  If player fails, the supply count is decrement by 4
   *
   * @param  none  
   * @return 4 (amount to be decremented from a Level 4 obstacle) 
   */
    public int supplyDecrement()
    {
        return 4; 
    }
   
    /**
   *  Uses an equation based on health and supply to generate a random number
   *  If this random number is greater than 80, player succeeds
   *  If this random number is less than 80, player fails
   *
   * @param  Player player  
   * @return true if player succeeds, false if player fails 
   */
    public boolean succeedOrFail(Player player)
    {
        double constant = generateConstant();
        if(constant*player.getHealth() + constant*player.getSupplies() >= 80)
            return true;
        return false; 
    }

}
