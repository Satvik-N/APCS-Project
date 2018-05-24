import java.awt.geom.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.Point;
/**
 * Write a description of class Animal here - a Level 2 obstacle.
 *
 * @author Priya K 
 * @version 052518
 */
public class Animal extends Obstacles // lvl 2
{
    /**
     * Constructor for objects of class Animal - initializes the location of the Animal
     */
    public Animal(int x, int y)
    {
        changeLocation(x, y); 
    }
    
     /**
   *   If player fails, the health is decremented by 20 
   *
   * @param  none  
   * @return 20 (amount to be decremented from a Level 2 obstacle) 
   */
    public int healthDecrement()
    {
        return 20;
    }
   
     /**
   *  If player fails, the supply count is decrement by 2
   *
   * @param  none  
   * @return 2 (amount to be decremented from a Level 2 obstacle) 
   */
    public int supplyDecrement()
    {
        return 2;
    }
   
     /**
   *  Uses an equation based on health and supply to generate a random number
   *  If this random number is greater than 40, player succeeds
   *  If this random number is less than 40, player fails
   *
   * @param  Player player  
   * @return true if player succeeds, false if player fails 
   */
    public boolean succeedOrFail(Player player)
    {
        double constant = generateConstant();
        if(constant*player.getHealth() + constant*player.getSupplies() >= 40)
            return true;
        return false; 
    }

}
