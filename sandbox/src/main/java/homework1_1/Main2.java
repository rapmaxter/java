package homework1_1;

/**
 * Created by Max on 9/12/2016.
 */
public class Main2 {

  public static void main(String[] args) {

    Point p1 = new Point();
    p1.x = 1;
    p1.y = 1;

    Point p2 = new Point();
    p2.x = 3;
    p2.y = 1;

    System.out.println(distance(p1, p2));
  }

  public static double distance(Point p1, Point p2) {

    double x = (p2.x - p1.x) * (p2.x - p1.x) + (p1.y - p2.y) * (p1.y - p2.y);
    return Math.sqrt(x);
  }

}
