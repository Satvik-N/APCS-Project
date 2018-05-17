import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    // instance variables - replace the example below with your own
    private List<Supplies> supplies = new ArrayList<Supplies>();
    private final int NUM_SUPPLIES;
    private int health;

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        NUM_SUPPLIES = 5;
        health = 10;
        
        supplies.add(new Food());
        supplies.add(new Fur());
        supplies.add(new Water());
        supplies.add(new Wood());
        supplies.add(new Metals());
    }
    
    // LOTS OF METHODS TO ADD TO THIS CLASS CHANGING THE AMOUNT OF SUPPLIES
    
}
