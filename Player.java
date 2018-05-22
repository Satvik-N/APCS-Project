import java.util.List;
import java.util.ArrayList;
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
    private double posX, posY;
    private double width, height;

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        NUM_SUPPLIES = 5;
        health = 10;
        posX = 0;
        posY = 0;
        width = 30;
        height = 40;
    }
    
    public void setName(String s)
    {
        name = s;
    }
    // LOTS OF METHODS TO ADD TO THIS CLASS CHANGING THE AMOUNT OF SUPPLIES
    
    public void move(double x, double y)
    {
        posX = x;
        posY = y;
    }
    
    public double getX()
    {
        return posX;
    }
    
    public double getY()
    {
        return posY;
    }
    
    public double getWidth()
    {
        return width;
    }
    
    public double getHeight()
    {
        return height;
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
