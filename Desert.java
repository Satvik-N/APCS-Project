
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
        for (int row = 0; row < biome.length/2; row++)
        {
            for (int col = 0; col < biome[row].length; col++)
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
        for (int i = biome.length/2; i < biome.length; i++)
        {
            for (int j = 0; j < biome[i].length; j++)
            {
                if (Math.random() < (1.0/8.0))
                {
                    if (Math.random() < .5)
                        biome[i][j] = new Fire(j, i);
                    else
                        biome[i][j] = new Famine(j, i);
                }
            }
        }
    }
}