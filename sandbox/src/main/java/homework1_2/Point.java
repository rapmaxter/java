package homework1_2;
/**
 * Created by Max on 9/12/2016.
 */
public class Point {

  public double x1;
  public double y1;
  public double x2;
  public double y2;

  public Point (double x2, double y2) {

    this.x2 = x2;
    this.y2 = y2;

  }

  public double distance(double x1, double y1) {

    this.x1 = x1;
    this.y1 = y1;

    double x = (this.x2 - this.x1) * (this.x2 - this.x1) + (this.y2 - this.y1) * (this.y2 - this.y1);
    return Math.sqrt(x);
  }
}