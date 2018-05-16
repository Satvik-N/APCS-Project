
/**
 * Write a description of class Supplies here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Supplies
{
    // instance variables - replace the example below with your own
    protected int amount;

    /**
     * Constructor for objects of class Supplies
     */
    public Supplies()
    {
        amount = 0;
    }

    public abstract void add(int x);

    public abstract void subtract(int x);
    
    public abstract int getNum();
}
