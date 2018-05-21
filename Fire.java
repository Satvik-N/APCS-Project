import java.awt.geom.*;

/**
 * Write a description of class Fire here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Fire
{
    private Point2D.Double point;
    private static final int LOWER_HEALTH = 20;
    
    public int healthDecrement()
    {
        return LOWER_HEALTH;
    }
    
    public void supplyDecrement()
    {
    }
    
    public void movePlayer()
    {
    }
    
    public Point2D.Double currentLocation()
    {
        return point;
    }
    
    public void changeLocation(double x, double y)
    {
        point.setLocation(x, y);
    }
}
