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
    public abstract void buildObstacles();
    
    public boolean isObstacle (int x, int y)
    {
        System.out.println("is at obstacle?: " + (biome[y][x] instanceof Obstacles));
        return biome[y][x] instanceof Obstacles;
    }
    
    public Materials getMaterial(int x, int y)
    {
        return biome[y][x];
    }
}
    

