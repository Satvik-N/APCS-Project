import java.awt.geom.*;
/**
 * Abstract class Biomes - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Biomes
{
    protected Materials[][] biome; //grid of materials
    public abstract void buildObstacles();
    
    /**
     *  <b>Summary</b> Method isObstacle() - determines whether there is an obstacle at the given location
     *  @param x x coordinate of location
     *  @param y y coordinate of location
     *  @return boolean that tells if there is an obstacle at a location
     */
    public boolean isObstacle (int x, int y)
    {
        return biome[y][x] instanceof Obstacles;
    }
    
    /**
     *  <b>Summary</b> Method getMaterial() - returns material at a certain location
     *  @param x x coordinate of location
     *  @param y y coordinate of location
     *  @return Material that is at the location
     */
    public Materials getMaterial(int x, int y)
    {
        return biome[y][x];
    }
}
    

