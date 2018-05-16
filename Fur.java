
/**
 * Write a description of class Fur here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Fur extends Supplies
{
    /**
     * Fur Constructor
     * Starts out with 0 fur
     */
    public Fur()
    {
        // initialize instance variables
        amount = 0;
    }
    
    /**
     * Fur Constructor
     *
     * @param An int with the starting number of fur
     */
    public Fur(int num)
    {
        // initialize instance variables
        amount = num;
    }

    /**
     * Method addFur
     *
     * @param int with number of fur to add
     */
    public void add(int num)
    {
        amount += num;
    }
    
    /**
     * Method subtractFur
     *
     * @param int with number of fur to subtract
     */
    public void subtract(int num)
    {
        amount -= num;
    }
    
    /**
     * Method getFur
     *
     * @return int amount of fur
     */
    public int getNum()
    {
        return amount;
    }
}
