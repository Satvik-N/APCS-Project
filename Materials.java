import java.awt.geom.*;
/**
 * Write a description of class Materials here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Materials
{
    private Point2D.Double point = new Point2D.Double(0, 0);
    private int myAmount;
    public Point2D.Double getLoc()
    {
        return point;
    }
    public void changeLoc(double x, double y)
    {
        point.setLocation(x, y);
    }
    public int getAmount()
    {
        return myAmount;
    }
    public void setAmount(int amount)
    {
        myAmount = amount;
    }
}
