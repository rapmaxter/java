package homework;

/**
 * Created by Max on 9/12/2016.
 */
public class Main2 {

  public static void main(String[] args) {

    Point p1 = new Point();
    p1.x1 = 1;
    p1.y1 = 1;

    Point p2 = new Point();
    p2.x2 = 3;
    p2.y2 = 1;

    System.out.println(distance(p1, p2));
  }

  public static double distance(Point p1, Point p2) {

    double x = (p2.x2 - p1.x1) * (p2.x2 - p1.x1) + (p1.y2 + p2.y1) * (p1.y2 + p2.y1);
    return Math.sqrt(x);
  }

}
