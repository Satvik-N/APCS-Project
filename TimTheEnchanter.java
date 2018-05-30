import java.awt.Point;
/**
 * Write a description of class TimTheEnchanter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TimTheEnchanter
{
    // instance variables - replace the example below with your own
    private Point location = new Point(0, 0);
    
    // narrator
    // random gifts (food, water, or health)

    /**
     * Constructor for objects of class TimTheEnchanter
     */
    public TimTheEnchanter(int x, int y)
    {
        location.setLocation(x, y);
    }
    public String enteredNewBiome(Player player, Board board)
    {
        if(!player.getOldLocation().equals(player.getLocation()))
        {
            return ("You've entered the " + board.getBiome(player) + " terrain!");
        }
        return "";
    }
    // runIntoObstacle
    // runIntoSupply
    // randomGift
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void sampleMethod(int y)
    {
        // put your code here
        //return x + y;
    }
}
