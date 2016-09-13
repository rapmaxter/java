package white.box.tester;

/**
 * Created by Max on 9/12/2016.
 */
public class FirstProgram {

    public static void main(String[] args) {

      Rectangle r  = new Rectangle(4, 6); // или  r.a = 4, r.b = 6; если обойтись без конструктора
            System.out.println("Площадь прямоугольника равна " +  area(r));

      Square s = new Square(6); // или  s.l = 6,  если обойтись без конструктора
      System.out.print("Площадь квадрата равна " + area(s));
    }

  public static double area(Rectangle r){
    return r.a * r.b;
  }

  public static double area(Square s) {
    return s.l * s.l;
  }
}
