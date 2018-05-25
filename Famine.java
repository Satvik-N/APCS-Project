import java.awt.geom.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.Point;
/**
 * Write a description of class Famine here- a Level 3 obstacle.
 *
 * @author Priya K
 * @version 052518
 */
public class Famine extends Obstacles // lvl 3
{

   /**
     * Constructor for objects of class Famine - initializes the location of the famine
     */
    public Famine(int x, int y)
    {
        changeLocation(x, y); 
    }
    
     /**
   *   If player fails, the health is decremented by 30 
   *
   * @param  none  
   * @return 30 (amount to be decremented from a Level 3 obstacle) 
   */
    public int healthDecrement()
    {
        return 30;
    }
   
     /**
   *  If player fails, the supply count is decrement by 3
   *
   * @param  none  
   * @return 3 (amount to be decremented from a Level 3 obstacle) 
   */
    public int supplyDecrement()
    {
        return 3; 
    }
   
     /**
   *  Uses an equation based on health and supply to generate a random number
   *  If this random number is greater than 60, player succeeds
   *  If this random number is less than 60, player fails
   *
   * @param  Player player  
   * @return true if player succeeds, false if player fails 
   */
    public boolean succeedOrFail(Player player)
    {
        double constant = generateConstant();
        if(constant*player.getHealth() + constant*player.getSupplies() >= 60)
            return true;
        return false; 
    }
   
   public String toString()
   {
       return "famine";
   }

}
