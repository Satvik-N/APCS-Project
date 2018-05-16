
/**
 * Write a description of class Water here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Water extends Supplies 
{
    /**
     * Water Constructor
     * Starts out with 0 water
     */
    public Water()
    {
        // initialize instance variables
        amount = 0;
    }
    
    /**
     * Water Constructor
     *
     * @param An int with the starting number of water
     */
    public Water(int num)
    {
        // initialize instance variables
        amount = num;
    }

    /**
     * Method addWater
     *
     * @param int with number of Water to add
     */
    public void add(int num)
    {
        amount += num;
    }
    
    /**
     * Method subtractWater
     *
     * @param int with number of water to subtract
     */
    public void subtract(int num)
    {
        amount -= num;
    }
    
    /**
     * Method getWater
     *
     * @return int amount of water
     */
    public int getNum()
    {
        return amount;
    }
}
