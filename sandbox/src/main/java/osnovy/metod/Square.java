package osnovy.metod;

/**
 * Created by Max on 9/12/2016.
 */
public class Square {

  public double l;

  public Square(double l) {
    this.l = l;
  }

  public double area() {    // тут убрали слово static и параметр функции
    return this.l * this.l;
  }

}
