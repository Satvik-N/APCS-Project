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
    private List<Supplies> supplies = new ArrayList<Supplies>();
    private final int NUM_SUPPLIES;
    private int health;
    private String name;
    private double width, height;
    private Point pos;
    
    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        NUM_SUPPLIES = 5;
        health = 10;
        width = 30;
        height = 40;
        pos = new Point(0, 0);
    }
    
    public Player(int x, int y)
    {
        NUM_SUPPLIES = 5;
        health = 10;
        width = 30;
        height = 40;
        pos = new Point(x, y);
    }
    
    public void setName(String s)
    {
        name = s;
    }
    // LOTS OF METHODS TO ADD TO THIS CLASS CHANGING THE AMOUNT OF SUPPLIES
    
    public void move(double x, double y)
    {
        pos.setLocation(x, y);
    }
    
    public double getX()
    {
        return pos.getX();
    }
    
    public double getY()
    {
        return pos.getY();
    }
    
    public double getWidth()
    {
        return width;
    }
    
    public double getHeight()
    {
        return height;
    }
    
    public void setWidthAndHeight(double x, double y)
    {
        width = x;
        height = y;
    }
    
    public void setWidth(double x)
    {
        width = x;
    }
    
    public void setHeight(double y)
    {
        height = y;
    }
}
