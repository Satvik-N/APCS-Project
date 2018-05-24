
/**
 * Write a description of class Desert here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Desert extends Biomes
{
    public Desert()
    {
        biome = new Materials[80][200];
    }

    public void buildObstacles() //sandstorm, fire, drought, famine, and animal
    {
        for (int row = 0; row < biome.length; row++)
        {
            for (int col = 0; col < biome[row].length/2; col++)
            {
                if (Math.random() < (1.0/8.0))
                {
                    if (Math.random() < .5)
                        biome[row][col] = new Drought(col, row);
                    else
                        biome[row][col] = new Sandstorm(col, row);
                }
            }
        }
    }
}