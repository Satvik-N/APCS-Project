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
        if(!player.playerBiome(player.getLocation()).equals(player.playerBiome(player.getOldLocation())))
        {
            return ("You've entered the " + player.playerBiome(player.getLocation()) + " terrain!");
        }
        return null;
    }
    public String runIntoObstacle(Player player)
    {
        if(player.isAtObstacle())
            ; 
            return null;
    }
    public String fightObstacle(Player player)
    {
        return "hello";
    }
    public String runIntoSupply(Player player)
    {
        return null;
    }
        public String collectSupply(Player player)
    {
        return null;
    }
    public String randomGift(Player player)
    {
        double random = Math.random();
        if(random >= 0.9)
        {
            if(random >= 0.95)
            {
                if(random >= 0.98)
                {
                    if(player.getHealth() < 50)
                    {
                        player.addWater(45); 
                        return "You've been working hard... here's 45 more water!";
                    }
                        
                    else
                    {
                        player.addFood(100);
                        return "You look hungry... here's 100 more food!";
                    }
                }
                if(player.getHealth() < 50)
                    {
                        player.addWater(25); 
                        return "You've been working hard... here's 25 more water!";
                    }
                        
                    else
                    {
                        player.addFood(80);
                        return "You look hungry... here's 80 more food!";
                    }
            }
            if(player.getHealth() < 50)
                    {
                        player.addWater(10); 
                        return "You've been working hard... here's 10 more water!";
                    }
                        
                    else
                    {
                        player.addFood(50);
                        return "You look hungry... here's 50 more food!";
                    }
        }
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
