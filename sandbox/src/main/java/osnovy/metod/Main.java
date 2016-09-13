package osnovy.metod;

/**
 * Created by Max on 9/12/2016.
 */
public class Main {

  public static void main(String[] args) {

    Rectangle r = new Rectangle(4, 6); // или  r.a = 4, r.b = 6; если обойтись без конструктора
    System.out.println("Площадь прямоугольника равна " + r.area()); // убрали функции в классы, а тут видо-изменили имя и значение фукнции


    Square s = new Square(6); // или  s.l = 6,  если обойтись без конструктора
    System.out.print("Площадь квадрата равна " + s.area()); // убрали функции в классы, а тут видо-изменили имя и значение фукнции

  }


}