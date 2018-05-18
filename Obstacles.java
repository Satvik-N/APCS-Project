import java.awt.geom.*;

/**
 * Write a description of class Obstacles here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Obstacles extends Materials
{
    public abstract int healthDecrement();
    
    public abstract void supplyDecrement();
    
    public abstract void movePlayer();
    
    public abstract Point2D.Double currentLocation();
    
    public abstract void changeLocation(double x, double y);
}
