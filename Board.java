
/**
 * Write a description of class Map here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Board
{
    private Desert desert;
    private Grassland grassland;
    private Rainforest rainforest;
    public Board()
    {
        desert = new Desert();
        grassland = new Grassland();
        rainforest = new Rainforest();
    }
    
    public String getBiome(Player p)
    {
        String s;
        if (p.getLocation().getY() < 80)
            s = "Desert";
        else
            if (p.getLocation().getX() < 100)
                s = "Rainforest";
            else   
                s = "Grassland";
        return s;
    }
}
