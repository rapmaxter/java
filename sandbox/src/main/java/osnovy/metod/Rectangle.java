package osnovy.metod;

/**
 * Created by Max on 9/12/2016.
 */
public class Rectangle {

  public double a;
  public double b;

  public Rectangle (double a, double b){

    this.a = a;
    this.b = b;
  }


  public double area(){ // тут убрали слово static и параметр функции

    return this.a * this.b;
}
}

