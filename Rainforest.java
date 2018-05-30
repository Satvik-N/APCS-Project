
/**
 * Write a description of class Rainforest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rainforest extends Biomes
{
    public Rainforest()
    {
        biome = new Materials[120][100];
    }
    public void buildObstacles()
    {
        for (int row = 0; row < biome.length * 0.2; row++)
        {
            for (int col = 0; col < biome[row].length; col++)
            {
                if (Math.random() < (1.0/10.0))
                {
                    if (Math.random() < 0.5)
                        biome[row][col] = new Drought(col, row);
                    else
                        biome[row][col] = new Sandstorm(col, row);
                }
            }
        }
        for (int row = 24; row < biome.length * 0.4 + 24; row++)
        {
            for (int col = 0; col < biome[row].length; col++)
            {
                if (Math.random() < (1.0/10.0))
                    biome[row][col] = new Animal(col, row);
            }
        }
        for (int row = 72; row < biome.length * 0.4 + 72; row++)
        {
            for (int col = 0; col < biome[row].length; col++)
            {
                if (Math.random() < (1.0/8.0))
                    biome[row][col] = new Mudslide(col, row);
            }
        }
    }
    public void buildSupplies()
    {
        
    }
}
