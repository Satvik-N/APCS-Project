
/**
 * Write a description of class Supplies here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Supplies
{
    // instance variables - replace the example below with your own
    private int myAmount;

    /**
     * Constructor for objects of class Supplies
     */
    public Supplies()
    {
        myAmount = 0;
    }
    
    /**
     * Constructor that initializes myAmount to the amount specified
     * @param amount amount of supply initially
     */
    public Supplies(int amount)
    {
        myAmount = amount;
    }

    public void add(int x)
    {
        myAmount += x;
    }

    public void subtract(int x)
    {
        myAmount -= x;
    }
    
    public int getNum()
    {
        return myAmount;
    }
}
