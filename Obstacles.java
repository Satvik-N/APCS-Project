import java.awt.geom.*;

/**
 * Write a description of class Obstacles here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface Obstacles
{
    public int healthDecrement();
    
    public void supplyDecrement();
    
    public void movePlayer();
    
    public Point2D.Double currentLocation();
    
    public void changeLocation(double x, double y);
}
