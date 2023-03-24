/*Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString().
 Определить дополнительно методы в классе, создающем массив объектов. Задать критерий выбора данных и вывести эти
 данные на консоль.

 8. Car: id, Марка, Модель, Год выпуска, Цвет, Цена, Регистрационный номер. Создать массив объектов.
  Вывести: a) список автомобилей заданной марки; b) список автомобилей заданной модели, которые эксплуатируются
   больше n лет; c) список автомобилей заданного года выпуска, цена которых больше указанной.

 */

import java.text.DecimalFormat;
import java.util.*;

import java.util.Scanner;

class Car {
    DecimalFormat df = new DecimalFormat("###.##");
    int id, year, price;
    String brand, model, color, regNom;

    public Car() {
    }

    ;

    public Car(int id, String brand, String model, int year, String color, int price, String regNom) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.regNom = regNom;
    }

    ;


    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    public String getRegNom() {
        return regNom;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Car{" +
                ", id=" + id +
                ", year=" + year +
                ", price=" + price +
                ", regNom=" + regNom +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRegNom(String regNom) {
        this.regNom = regNom;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

    public class Main {
    public static void main(String[] args) {

        Car[] cars=new Car[4];
        cars[0]=new Car(1, "Lada","Granta", 2003, "Blue",900000, "C734MK93");
        cars[1]=new Car(2, "Lada","Niva", 2003, "Black",1000000, "C834BK99");
        cars[2]=new Car(3, "Reno","Megan Scenic", 2001, "Red",1500000, "T911MM55");
        cars[3]=new Car(4, "Ford","Focus", 2013, "Orange",2100000, "A322AA73");
        Scanner input = new Scanner(System.in);
        System.out.print("А) Введите марку: ");
        String s = input.nextLine().toString();
        String m="Lada";
        System.out.println("Подходящие авто: ");
        for (int i=0;i<4;i++){
            String s1=cars[i].getBrand().toUpperCase(Locale.ROOT);
            if (s1.equals(s.toUpperCase(Locale.ROOT))){
                System.out.println(cars[i].toString());
            }
        }
        System.out.println();
        System.out.print("Б) Введите модель и срок эксплуатации: ");
        s = input.nextLine();
        int n = input.nextInt();
        Date dt=new Date();
        int year=dt.getYear()+1900;
        System.out.println("Подходящие товары: ");
        for (int i=0;i<4;i++){
            String s1=cars[i].getModel().toUpperCase(Locale.ROOT);
            int ey=cars[i].getYear();
            if (s1.equals(s.toUpperCase(Locale.ROOT)) & ((year - ey) > n)){
                System.out.println(cars[i].toString());
            }
        }

        System.out.println();
        System.out.print("В) Введите год выпуска и стоимость: ");
        n = input.nextInt();
        int n1 = input.nextInt();
        System.out.println("Подходящие авто: ");
        for (int i=0;i<4;i++){
            int pr=cars[i].getPrice();
            int ye=cars[i].getYear();
            if ((pr > n1) & (ye == n)){
                System.out.println(cars[i].toString());
            }
        }
    }
}