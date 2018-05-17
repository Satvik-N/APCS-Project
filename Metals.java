
/**
 * Write a description of class Metals here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Metals extends Supplies
{
    /**
     * Metals Constructor
     * Starts out with 0 metals
     */
    public Metals()
    {
        // initialize instance variables
        super();
    }
    
    /**
     * Metals Constructor
     *
     * @param An int with the starting number of metals
     */
    public Metals(int num)
    {
        // initialize instance variables
        super(num);
    }

    /**
     * Method addMetals
     *
     * @param int with number of metals to add
     */
    public void add(int num)
    {
        super.add(num);
    }
    
    /**
     * Method subtractMetals
     *
     * @param int with number of metals to subtract
     */
    public void subtract(int num)
    {
        super.subtract(num);
    }
    
    /**
     * Method getMetals
     *
     * @return int amount of metals
     */
    public int getNum()
    {
        return super.getNum();
    }
}
