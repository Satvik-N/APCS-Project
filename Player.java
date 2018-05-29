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
        pos = new Point(Math.random(), Math.random);
        board = new Board();
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
