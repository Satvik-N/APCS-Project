
/**
 * Write a description of class FinalObstacle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FinalObstacle extends Obstacles
{
    // instance variables - replace the example below with your own
    private int x;
    // health, water, and food to succeed

    /**
     * Constructor for objects of class FinalObstacle
     */
    public FinalObstacle()
    {
        // initialise instance variables
        x = 0;
    }

    public void healthDecrement(Player p)
    {
        p.subtractHealth(50);
    }
    public boolean succeedOrFail(Player p)
    {
        double constant = generateConstant();
        if(constant*p.getHealth() + constant*p.getFood() + constant*p.getWater() > 1000)
            return true;
        healthDecrement(Player p);
        
    }
    // if fail, decrement health and move to right behind the wall into a random position
    public abstract String toString();
    }
