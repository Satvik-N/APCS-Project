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
    private int bowAndArrow; //lvl 2
    private int spear; //lvl 1
    private int armor; //lvl 2
    private int pickaxe; //lvl 1
    private int sword; //lvl 2
    private int rope; //lvl 1
    private int health;
    private final int WOOD_DECREMENT = 50;
    private final int METAL_DECREMENT = 50;
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
        name = playerName;
        pos = new Point(x, y);
        oldPos = pos;
        board = new Board();
    }
    
    public int getSupplies()
    {
        return 0;
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
        if (playerBiome(pos).equalsIgnoreCase("Desert"))
        {
            return desert.isObstacle((int)pos.getX(), (int)pos.getY());
        }
        else
            if (playerBiome(pos).equalsIgnoreCase("Rainforest"))
            {
                return rainforest.isObstacle((int)pos.getX(), (int)(pos.getY() - 80));
            }
            else
                return grassland.isObstacle((int)(pos.getX()-100), (int)(pos.getY() - 80));
    }
    
    public boolean isAtSupply()
    {
        boolean supply = false;
        if (playerBiome(pos).equalsIgnoreCase("Rainforest"))
            supply = rainforest.isAtSupply((int)pos.getX(), (int)(pos.getY() - 80));
        else
            if (playerBiome(pos).equalsIgnoreCase("Grassland"))
                supply = grassland.isAtSupply((int)(pos.getX() - 100), (int)(pos.getY() - 80));
        return supply;
    }
    
    public String playerBiome(Point pos)
    {
        String s;
        if (pos.getY() < 80)
            s = "DESERT";
        else 
            if (pos.getX() < 100)
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

    public int getMetal()
    {
        return metal;
    }
    
    public int getWood()
    {
        return wood;
    }
    
    public int getWater()
    {
        return wood;
    }
    
    public int getFood()
    {
        return food;
    }
    
    public int getBowAndArrow()
    {
        return bowAndArrow;
    }
    
    public int getSpear()
    {
        return spear;
    }
    
    public int getArmor()
    {
        return armor;
    }
    
    public int getPickaxe()
    {
        return pickaxe;
    }
    
    public int getSword()
    {
        return sword;
    }
    
    public int getRope()
    {
        return rope;
    }
    
    public void addMetal(int myMetal)
    {
        metal += myMetal;
    }
    
    public void addWood(int myWood)
    {
        wood += myWood;
    }
    
    public void addWater(int myWater)
    {
        water += myWater;
    }
    
    public void addBowAndArrow(int amount)
    {
        bowAndArrow += amount;
        wood -= ((amount) * WOOD_DECREMENT * 2);
        metal -= ((amount) * METAL_DECREMENT);
    }
    
    public void addSpear(int amount)
    {
        spear += amount;
        wood -= ((amount) * WOOD_DECREMENT);
        metal -= ((amount) * METAL_DECREMENT/2);
    }
    
    public void addSword(int amount)
    {
        sword += amount;
        metal -= ((amount) * METAL_DECREMENT * 2);
        wood -= ((amount) * WOOD_DECREMENT);
    }
    
    public void addRope(int amount)
    {
        rope += amount;
        wood -= ((amount) * WOOD_DECREMENT * 1.5);
    }
    
    public void addArmor (int amount)
    {
        armor += amount;
        metal -= ((amount) * METAL_DECREMENT * 2);
    }
    
    public void addPickaxe (int amount)
    {
        pickaxe += amount;
        wood -= ((amount) * WOOD_DECREMENT);
        metal -= ((amount) * METAL_DECREMENT/2);
    }
    
    public void addFood(int myFood)
    {
        food += myFood;
    }
    
    public void subtractMetal(int myMetal)
    {
        metal -= myMetal;
    }
    
    public void subtractWood(int myWood)
    {
        wood -= myWood;
    }
    
    public void subtractWater(int myWater)
    {
        water -= myWater;
    }
    
    public void subtractFood(int myFood)
    {
        food -= myFood;
    }
    
    public void subtractBowAndArrow(int amount)
    {
        bowAndArrow -= amount;
    }
    
    public void subtractSpear(int amount)
    {
        spear -= amount;
    }
    
    public void subtractArmor (int amount)
    {
        armor -= amount;
    }
    
    public void subtractPickaxe (int amount)
    {
        pickaxe -= amount;
    }
    
    public void subtractSword (int amount)
    {
        sword -= amount;
    }
    
    public void subtractRope (int amount)
    {
        rope -= amount;
    }
}

