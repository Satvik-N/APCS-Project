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
    private int fireProofShield; //lvl 2
    private int rope; //lvl 1
    private int health;
    private final int WOOD_DECREMENT = 50;
    private final int METAL_DECREMENT = 50;
    private String name;
    private Point pos;
    private Point oldPos;
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
        fireProofShield = 0;
        rope = 0;
        name = playerName;
        pos = new Point((int)(Math.random()*201),  (int)(Math.random()*176 + 25));
        oldPos = pos;
        grassland = new Grassland();
        rainforest = new Rainforest();
        desert = new Desert();
        grassland.buildObstacles();
        rainforest.buildObstacles();
        desert.buildObstacles();
        grassland.buildSupplies();
        rainforest.buildSupplies();
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
        fireProofShield = 0;
        rope = 0;
        name = playerName;
        pos = new Point(x, y);
        oldPos = pos;
        desert = new Desert();
        grassland.buildObstacles();
        rainforest.buildObstacles();
        desert.buildObstacles();
        grassland.buildSupplies();
        rainforest.buildSupplies();
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
        if (playerBiome(pos).equals(desert))
        {
            return desert.isObstacle((int)pos.getX(), (int)pos.getY());
        }
        else
            if (playerBiome(pos).equals(rainforest))
            {
                return rainforest.isObstacle((int)pos.getX(), (int)(pos.getY() - 80));
            }
            else
                return grassland.isObstacle((int)(pos.getX()-100), (int)(pos.getY() - 80));
    }
    
    public boolean isAtSupply()
    {
        boolean supply = false;
        if (playerBiome(pos).equals(rainforest))
            supply = rainforest.isAtSupply((int)pos.getX(), (int)(pos.getY() - 80));
        else
            if (playerBiome(pos).equals(grassland))
                supply = grassland.isAtSupply((int)(pos.getX() - 100), (int)(pos.getY() - 80));
        return supply;
    }
    
    public Biomes playerBiome(Point pos)
    {
        String s;
        if (pos.getY() < 80)
            return desert;
        else 
            if (pos.getX() < 100)
                return rainforest;
            else
                return grassland;
    }
    
    public Point convertLoc(Point pos)
    {
        if (playerBiome(pos).equals(desert))
        {
            return pos;
        }
        else
            if (playerBiome(pos).equals(rainforest))
            {
                pos.setLocation(pos.getX(), pos.getY() - 120);
                return pos;
            }
            else
            {
                pos.setLocation((pos.getX() - 100), (pos.getY() - 120));
                return pos;
            }
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
    
    public int getFireProofShield()
    {
        return fireProofShield;
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
        if(wood - ((amount) * WOOD_DECREMENT * 2) < 0)
            throw new IllegalArgumentException("You don't have enough wood");
        if(metal - ((amount) * METAL_DECREMENT) < 0)
            throw new IllegalArgumentException("You don't have enough metal"); 
        subtractWood((amount) * WOOD_DECREMENT * 2);
        subtractMetal((amount) * METAL_DECREMENT);
        bowAndArrow += amount;
    }
    
    public void addSpear(int amount)
    { 
        if(wood - ((amount) * WOOD_DECREMENT) < 0)
            throw new IllegalArgumentException("You don't have enough wood");
        if(metal - ((amount) * METAL_DECREMENT/2) < 0)
            throw new IllegalArgumentException("You don't have enough metal"); 
        subtractWood((amount) * WOOD_DECREMENT);
        subtractMetal((amount) * METAL_DECREMENT/2);
        spear += amount;
    }
    
    public void addFireProofShield(int amount)
    {
        if(wood - ((amount) * WOOD_DECREMENT) < 0)
            throw new IllegalArgumentException("You don't have enough wood");
        if(metal - ((amount) * METAL_DECREMENT*2) < 0)
            throw new IllegalArgumentException("You don't have enough metal");
        subtractWood((amount) * WOOD_DECREMENT);
        subtractMetal((amount) * METAL_DECREMENT * 2);
        fireProofShield += amount;
    }
    
    public void addRope(int amount)
    {
        if(wood - ((amount) * (int)(WOOD_DECREMENT * 1.5)) < 0)
            throw new IllegalArgumentException("You don't have enough wood");
        subtractWood((amount) * (int)(WOOD_DECREMENT * 1.5));
        rope += amount;
    }
    
    public void addArmor (int amount)
    {
        if(metal - ((amount) * METAL_DECREMENT*2) < 0)
            throw new IllegalArgumentException("You don't have enough metal");
        subtractMetal((amount) * METAL_DECREMENT * 2);
        armor += amount;
    }
    
    public void addPickaxe (int amount)
    {
        if(wood - ((amount) * WOOD_DECREMENT) < 0)
            throw new IllegalArgumentException("You don't have enough wood");
        if(metal - ((amount) * METAL_DECREMENT/2) < 0)
            throw new IllegalArgumentException("You don't have enough metal");
        subtractWood((amount) * WOOD_DECREMENT);
        subtractMetal((amount) * METAL_DECREMENT/2);
        pickaxe += amount;
    }
    
    public void addFood(int myFood)
    {
        food += myFood;
    }
    
    public void addHealth(int myHealth)
    {
        if(health == 100)
        {
            throw new IllegalArgumentException("If you eat 10 more food or drink 10 more water, you'll have over 100 health. Save the food and water for when you need it!");
        }
        health += myHealth; 
    }
    
    public void subtractHealth(int myHealth)
    {
        health -= myHealth; 
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
        if(water - myWater < 0)
            throw new IllegalArgumentException("You don't have enough water");
        water -= myWater;
    }
    
    public void subtractFood(int myFood)
    {
        if(food - myFood < 0)
            throw new IllegalArgumentException("You don't have enough food");
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
    
    public void subtractFireProofShield (int amount)
    {
        fireProofShield -= amount;
    }
    
    public void subtractRope (int amount)
    {
        rope -= amount;
    }
}

