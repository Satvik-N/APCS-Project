
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
        super();
    }
    
    /**
     * Wood Constructor
     *
     * @param An int with the starting number of wood
     */
    public Wood(int num)
    {
        // initialize instance variables
        super(num);
    }

    /**
     * Method addWood
     *
     * @param int with number of wood to add
     */
    public void add(int num)
    {
        super.add(num);
    }
    
    /**
     * Method subtractWood
     *
     * @param int with number of wood to subtract
     */
    public void subtract(int num)
    {
        super.subtract(num);
    }
    
    /**
     * Method getWood
     *
     * @return int amount of wood
     */
    public int getNum()
    {
        return super.getNum();
    }
}
