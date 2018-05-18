import java.awt.geom.*;
/**
 * Abstract class Biomes - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Biomes
{
    protected Materials[][] biome;
    public abstract void buildSupplies();
    
    public abstract void buildObstacles();
    
    public Point2D.Double getLoc(Materials m)
    {
        for (int row = 0; row < biome.length; row++)
            for (int col = 0; col < biome[row].length; col++)
                if (m.equals(biome[row][col]))
                    return m.getLoc();  
        return null;
    }
    
    public void setLoc(Point2D.Double target, Materials m)
    {
        if (biome[(int)target.getY()][(int)target.getX()] == null)
            biome[(int)target.getY()][(int)target.getX()] = m;
        else
            throw new IllegalArgumentException("Obstacle already at that spot");
    }
}
