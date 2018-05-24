import java.awt.geom.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.Point;
/**
 * Write a description of class Obstacles here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Obstacles extends Materials
{
    private Point location;
    
    public double generateConstant()
    {
        return Math.random();
    }
    
    public abstract int healthDecrement();
    
    public abstract int supplyDecrement();
    
    public abstract boolean succeedOrFail(Player player);
    
    public abstract void movePlayer();
    
    public Point currentLocation()
    {
        return location; 
    }
    
    public void changeLocation(double x, double y)
    {
        location.setLocation(x, y);
    }
}
