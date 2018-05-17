import java.awt.geom.Point2D;
/**
 * Write a description of class Supplies here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Supplies
{
    // instance variables - replace the example below with your own
    private int myWater;
    private int myWood;
    private int myMetal;
    private int myFood;
    private int myFur;
    private int waterCapacity;
    private int woodCapacity;
    private int metalCapacity;
    private int foodCapacity;
    private int furCapacity;
    private Point2D.Double point;

    /**
     * Constructor for objects of class Supplies
     */
    public Supplies()
    {
        myWater = 0;
        myWood = 0;
        myMetal = 0;
        myFood = 0;
        myFur = 0;
        waterCapacity = 0;
        woodCapacity = 0;
        metalCapacity = 0;
        foodCapacity = 0;
        furCapacity = 0;
        point = new Point2D.Double(0.0, 0.0);
    }
    
    /**
     * Constructor that initializes myAmount to the amount specified
     * @param amount amount of supply initially
     */
    public Supplies(int water, int wood, int metal, int food, int fur, double x, double y)
    {
        myWater = water;
        myWood = wood;
        myMetal = metal;
        myFood = food;
        myFur = fur;
        waterCapacity = water;
        woodCapacity = wood;
        metalCapacity = metal;
        foodCapacity = food;
        furCapacity = fur;
        point = new Point2D.Double(x, y);
    }

    public void empty()
    {
        myWater = 0;
        myWood = 0;
        myMetal = 0;
        myFood = 0;
        myFur = 0;
    }
    
    public void replenish()
    {
        myWater = waterCapacity;
        myWood = woodCapacity;
        myMetal = metalCapacity;
        myFood = foodCapacity;
        myFur = furCapacity;
    }
    
    public Point2D.Double getPos()
    {
        return point;
    }
}
