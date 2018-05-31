import java.util.List;
import java.util.ArrayList;
import java.awt.Point;
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    // instance variables - replace the example below with your own
    private int metal;
    private int wood;
    private int food;
    private int water;
    private int bowAndArrow;
    private int spear;
    private int armor;
    private int pickaxe;
    private int sword;
    private int rope;
    private int trap;
    private int health;
    private String name;
    private Point pos;
    private Point oldPos;
    private Board board;
    private Grassland grassland;
    private Rainforest rainforest;
    private Desert desert;

    // make a health/supply increment/decrement

    /**
     * Constructor for objects of class Player
     */
    public Player(String playerName)
    {
        health = 100;
        metal = 0;
        wood = 0;
        food = 0;
        water = 0;
        bowAndArrow = 0;
        spear = 0;
        armor = 0;
        pickaxe = 0;
        sword = 0;
        rope = 0;
        trap = 0;
        name = playerName;
        pos = new Point((int)(Math.random()*201),  (int)(Math.random()*176 + 25));
        oldPos = pos;
        board = new Board();
        grassland = new Grassland();
        rainforest = new Rainforest();
        desert = new Desert();
    }

    public Player(int x, int y, String playerName)
    {
        health = 100;
        metal = 0;
        wood = 0;
        food = 0;
        water = 0;
        bowAndArrow = 0;
        spear = 0;
        armor = 0;
        pickaxe = 0;
        sword = 0;
        rope = 0;
        trap = 0;
        name = playerName;
        pos = new Point(x, y);
        oldPos = pos;
        board = new Board();
    }

    public void setName(String s)
    {
        name = s;
    }
    // LOTS OF METHODS TO ADD TO THIS CLASS CHANGING THE AMOUNT OF SUPPLIES

    public void move(int x, int y)
    {
        if(pos != null)
            setOldPosition(); 
        pos.setLocation(x, y);
    }
    
    public void setOldPosition()
    {
        oldPos.setLocation(pos.getX(), pos.getY());
    }
    
    public boolean isAtObstacle()
    {
        if (playerBiome().equalsIgnoreCase("Desert"))
        {
            return desert.isObstacle((int)pos.getX(), (int)pos.getY());
        }
        else
            if (playerBiome().equalsIgnoreCase("Rainforest"))
            {
                return rainforest.isObstacle((int)pos.getX(), (int)(pos.getY() - 80));
            }
            else
                return grassland.isObstacle((int)(pos.getX()-100), (int)(pos.getY() - 80));
    }
    
    public boolean isAtSupply()
    {
        boolean supply = false;
        if (playerBiome().equalsIgnoreCase("Rainforest"))
            supply = rainforest.isAtSupply((int)pos.getX(), (int)(pos.getY() - 80));
        else
            if (playerBiome().equalsIgnoreCase("Grassland"))
                supply = grassland.isAtSupply((int)(pos.getX() - 100), (int)(pos.getY() - 80));
        return supply;
    }
    
    public String playerBiome()
    {
        String s;
        if (getLocation().getY() < 80)
            s = "DESERT";
        else 
            if (getLocation().getX() < 100)
                s = "RAINFOREST";
            else
                s = "GRASSLAND";
        return s;
    }

    public Point getLocation()
    {
        return pos;
    }
    
    public Point getOldLocation()
    {
        return oldPos; 
    }

    public int getHealth()
    {
        return health;
    }

    public int getSupplies()
    {
        return 0; 
    }
}
