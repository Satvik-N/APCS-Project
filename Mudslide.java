import java.awt.geom.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.Point;
/**
 * Write a description of class Mudslide here - a Level 1 Obstacle
 *
 * @author PriyaK
 * @version 052518
 */
public class Mudslide extends Obstacles
{
   // toString
   // get option1 (fight or flight)
   // get option2
   // do option 1
   // do option 2
   /**
     * Constructor for objects of class Mudslide - initializes the location of the mudslide
     */
    public Mudslide(int x, int y)
    {
        changeLocation(x, y); 
    }

    /**
   *   If player fails, the health is decremented by 10 
   *
   * @param  none  
   * @return 10 (amount to be decremented from a Level 1 obstacle) 
   */
    public int healthDecrement()
    {
        return 10;
    }
   
    /**
   *  If player fails, the supply count is decrement by 1
   *
   * @param  none  
   * @return 1 (amount to be decremented from a Level 1 obstacle) 
   */
    public int supplyDecrement()
    {
        return 1; 
    }
    
    /**
   *  Uses an equation based on health and supply to generate a random number
   *  If this random number is greater than 20, player succeeds
   *  If this random number is less than 20, player fails
   *
   * @param  Player player  
   * @return true if player succeeds, false if player fails 
   */
    public boolean succeedOrFail(Player player)
    {
        double constant = generateConstant();
        if(constant*player.getHealth() + constant*player.getSupplies() >= 20)
            return true;
        return false; 
    }
    

}
