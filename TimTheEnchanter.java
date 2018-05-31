/**
 * Write a description of class TimTheEnchanter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TimTheEnchanter
{
    // instance variables - replace the example below with your own
    
    // narrator
    // random gifts (food, water, or health)
    // build supply?

    /**
     * Constructor for objects of class TimTheEnchanter
     */
    public TimTheEnchanter()
    {
        
    }
    public String enteredNewBiome(Player player)
    {
        if(!player.getOldLocation().equals(player.getLocation()))
        {
            return ("You've entered the " + player.playerBiome() + " terrain!");
        }
        return null;
    }
    public String runIntoObstacle(Player player)
    {
        if(player.isAtObstacle())
            ; 
    }
    public String runIntoSupply(Player player)
    {
        return null;
    }
    public String randomGift(Player player)
    {
        return null; 
    }
    public String buildSupply(Player player)
    {
        return null;
    }
    // runIntoObstacle
    // runIntoSupply
    // randomGift
}
