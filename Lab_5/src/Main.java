/*Выполнить задания из варианта 2 лабораторной работы 3,
реализуя собственные обработчики исключений и исключения ввода/вывода.

Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString().
 Определить дополнительно методы в классе, создающем массив объектов. Задать критерий выбора данных и вывести эти
 данные на консоль.

 9.Product: id, Наименование, UPC, Производитель, Цена, Срок хранения, Количество. Создать массив объектов.
 Вывести: a) список товаров для заданного наименования; b) список товаров для заданного наименования, цена
 которых не превосходит заданную; c) список товаров, срок хранения которых больше заданного.

 */

import java.text.DecimalFormat;
import java.util.*;

import java.util.Scanner;

class Product {
    DecimalFormat df = new DecimalFormat("###.##");
    int id, year, price,cnt,UPC;
    String name, manufact;

    public Product() {
    }

    ;

    public Product( int id, int year, int price, int cnt, int UPC, String name, String manufact) {
        this.id = id;
        this.year = year;
        this.price = price;
        this.cnt = cnt;
        this.UPC = UPC;
        this.name = name;
        this.manufact = manufact;
    }

    public void setDf(DecimalFormat df) {
        this.df = df;
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

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public void setUPC(int UPC) {
        this.UPC = UPC;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufact(String manufact) {
        this.manufact = manufact;
    }


    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    public int getCnt() {
        return cnt;
    }

    public int getUPC() {
        return UPC;
    }

    public String getName() {
        return name;
    }

    public String getManufact() {
        return manufact;
    }

    @Override
    public String toString() {
        return "Product{" +
                ", id=" + id +
                ", year=" + year +
                ", price=" + price +
                ", cnt=" + cnt +
                ", UPC=" + UPC +
                ", name='" + name + '\'' +
                ", manufact='" + manufact + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {

        Product[] products=new Product[4];
        products[0]=new Product(1, 2004,354, 20, 976508757,"Niva", "React");
        products[1]=new Product(2, 2025,254, 10, 975673675,"Niva", "React_M");
        products[2]=new Product(3, 2023,154, 30, 356678757,"Rak", "React");
        products[3]=new Product(4, 2023,134, 15, 236634525,"Mack", "React");
        Scanner input = new Scanner(System.in);
        System.out.print("А) Введите наименование: ");
        String s = input.nextLine().toString();
        System.out.println("Подходящие товары: ");
        for (int i=0;i<4;i++){
            String s1=products[i].getName().toUpperCase(Locale.ROOT);
            if (s1.equals(s.toUpperCase(Locale.ROOT))){
                System.out.println(products[i].toString());
            }
        }
        System.out.println();
        System.out.print("Б) Введите наименование и цену: ");
        s = input.nextLine();
        int n = input.nextInt();
        System.out.println("Подходящие продукты: ");
        for (int i=0;i<4;i++){
            String s1=products[i].getName().toUpperCase(Locale.ROOT);
            int ey=products[i].getPrice();
            if (s1.equals(s.toUpperCase(Locale.ROOT)) & (ey <= n)){
                System.out.println(products[i].toString());
            }
        }

        System.out.println();
        System.out.print("В) Введите срок хранения: ");
        n = input.nextInt();
        System.out.println("Подходящие продукты: ");
        for (int i=0;i<4;i++){
            int ye=products[i].getYear();
            if (ye > n){
                System.out.println(products[i].toString());
            }
        }
    }
}