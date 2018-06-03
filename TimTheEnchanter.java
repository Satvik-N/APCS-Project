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
    public String runIntoObstacle(Player p)
    {
        Obstacles obstacle;
        if(p.isAtObstacle())
        {
            obstacle = (Obstacles)p.playerBiome(p.getLocation()).getMaterial((int)p.convertLoc(p.getLocation()).getX(), (int)p.convertLoc(p.getLocation()).getY());
            return "Oh no! You've run into a " + obstacle.toString() + "!"
                   + "You can fight this with " + obstacle.weapon() + ", if you have some to spare..."; 
        }
        return null;
    }
    public String fightObstacle(Player player, boolean choice)
    {
        return "hello";
    }
    public String runIntoSupply(Player p)
    {
        Supplies supply;
        if(p.isAtSupply())
        {
            supply = (Supplies)p.playerBiome(p.getLocation()).getMaterial((int)p.convertLoc(p.getLocation()).getX(), (int)p.convertLoc(p.getLocation()).getY());
            return "Yay! You've just found a a " + supply.toString() + "!"; 
        }
        return null;
    }
        public void collectSupply(Player p)
    {
        Supplies supply = (Supplies)p.playerBiome(p.getLocation()).getMaterial((int)p.convertLoc(p.getLocation()).getX(), (int)p.convertLoc(p.getLocation()).getY());
        double random = Math.random(); 
        int amountToAdd = 0;
        if(random <= .50)
        {
            amountToAdd = 20;
        }
        else
        {
            amountToAdd = 40;
        }
        if(supply instanceof Metal)
        {
            p.addMetal(amountToAdd); 
        }
        else
            if(supply instanceof Wood)
            {
                p.addWood(amountToAdd); 
            }
            else
                if(supply instanceof Food)
                {
                    p.addFood(amountToAdd); 
                }
                else
                    if(supply instanceof Water)
                    {
                        p.addWater(amountToAdd); 
                    }   
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
    public Materials returnMaterial(Player p)
    {
        return p.playerBiome(p.getLocation()).getMaterial((int)p.convertLoc(p.getLocation()).getX(), (int)p.convertLoc(p.getLocation()).getY());
    }
    // runIntoObstacle
    // runIntoSupply
    // randomGift
}
