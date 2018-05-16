
/**
 * Write a description of class Wood here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Wood extends Supplies
{
    /**
     * Wood Constructor
     * Starts out with 0 wood
     */
    public Wood()
    {
        // initialize instance variables
        amount = 0;
    }
    
    /**
     * Wood Constructor
     *
     * @param An int with the starting number of wood
     */
    public Wood(int num)
    {
        // initialize instance variables
        amount = num;
    }

    /**
     * Method addWood
     *
     * @param int with number of wood to add
     */
    public void add(int num)
    {
        amount += num;
    }
    
    /**
     * Method subtractWood
     *
     * @param int with number of wood to subtract
     */
    public void subtract(int num)
    {
        amount -= num;
    }
    
    /**
     * Method getWood
     *
     * @return int amount of wood
     */
    public int getNum()
    {
        return amount;
    }
}
