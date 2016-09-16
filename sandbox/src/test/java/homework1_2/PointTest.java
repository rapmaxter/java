package homework1_2;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Max on 9/16/2016.
 */
public class PointTest {

  @Test
  public void testDistance(){
    Point p1 = new Point(1,1);

    Point p2 = new Point(3,1);

    Assert.assertEquals(p1.distance(p2), 2);
  }
}
