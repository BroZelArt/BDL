/*
Реализовать абстрактные классы или интерфейсы, а также наследование и полиморфизм для следующих классов:
interface Мебель <- abstract class Шкаф <- class Книжный Шкаф.
 */

interface Furniture{
    void printName();
}

abstract class Closet implements Furniture{
    String name;
    public Closet(){}
    public  Closet(String s){
        this.name=s;
    }
    @Override
    public void printName() {
        System.out.println(this.name);
    }
}

class Bookshelf extends Closet{
    int price;
    public Bookshelf(String s){
        super(s);
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}