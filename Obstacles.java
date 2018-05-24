import java.awt.geom.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.Point;
/**
 * Write a description of class Obstacles here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Obstacles extends Materials
{
  /**
   *  Generates a random constant to be used as the coefficient for succeedOrFail
   *
   * @param  none  
   * @return double (randomly generated) 
   */
    public double generateConstant()
    {
        return Math.random();
    }
  public abstract int healthDecrement(); 
  public abstract int supplyDecrement();
  public abstract boolean succeedOrFail(Player player);
  public abstract String toString();
  public String FightOrFlight()
  {
      String string = "";
      return string; 
  }
}
