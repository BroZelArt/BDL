/*
Реализовать абстрактные классы или интерфейсы, а также наследование и полиморфизм для следующих классов:
interface Корабль <- class Грузовой Корабль <- class Танкер.
 */

interface Ship{
    void printName();
}

class CargoShip implements Ship{
    String name;
   public CargoShip(){}
  public  CargoShip(String s){
        this.name=s;
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }
}

class Tancker extends CargoShip{
    int price;
    public Tancker(String s){
        super(s);
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}