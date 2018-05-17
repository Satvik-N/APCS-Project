
/**
 * Write a description of class Food here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Food extends Supplies
{
    /**
     * Food Constructor
     * Starts out with 0 food
     */
    public Food()
    {
        // initialize instance variables
        super();
    }
    
    /**
     * Food Constructor
     *
     * @param An int with the starting number of food
     */
    public Food(int num)
    {
        // initialize instance variables
        super(num);
    }

    /**
     * Method addFood
     *
     * @param int with number of food to add
     */
    public void add(int num)
    {
        super.add(num);
    }
    
    /**
     * Method subtractFood
     *
     * @param int with number of food to subtract
     */
    public void subtract(int num)
    {
        super.subtract(num);
    }
    
    /**
     * Method getFood
     *
     * @return int amount of food
     */
    public int getNum()
    {
        return super.getNum();
    }
}
