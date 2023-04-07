// Выполнить задания на основе варианта 1 лабораторной работы 3,
// контролируя состояние потоков ввода/вывода. При возникновении ошибок,
// связанных с корректностью выполнения математических операций, генерировать и обрабатывать
// исключительные ситуации. Предусмотреть обработку исключений, возникающих при нехватке памяти,
// отсутствии требуемой записи (объекта) в файле, недопустимом значении поля и т.д.

// Определить класс Комплекс. Класс должен содержать несколько конструкторов.
// Реализовать методы для сложения, вычитания, умножения, деления, присваивания комплексных чисел.
// Создать два вектора размерности n из комплексных координат. Передать их в метод, который выполнит
// их сложение.
import java.util.*;

import java.util.Scanner;

class Complex {
    public double a,bi;
    public Complex(){}
    public Complex(double a1,double b1){
        this.a=a1;
        this.bi=b1;
    }
    public Complex(int a1,double b1){
        this.a=a1;
        this.bi=b1;
    }
    public Complex(double a1,int b1){
        this.a=a1;
        this.bi=b1;
    }
    public Complex(int a1,int b1){
        this.a=a1;
        this.bi=b1;
    }
    public Complex getPlus (Complex b){
        Complex c= new Complex();
        c.a=a+b.a;
        c.bi=bi+b.bi;
        return (c);
    }
    public Complex Div( Complex cB )  throws ArithmeticException{
        Complex div = new Complex();
        double dR, dDen;

        if(Math.abs( cB.a ) >= Math.abs( cB.bi )) {
            dR = cB.bi/cB.a;
            dDen = cB.a + dR*cB.bi;
            if (dDen == Float.POSITIVE_INFINITY || dDen == Float.NEGATIVE_INFINITY) {
                throw new ArithmeticException("Обнаружено деление на ноль");
            }
            div.a = (a + dR*bi)/dDen;
            div.bi = (bi - dR*a)/dDen;
        } else {
            dR = cB.a/cB.bi;
            if (dR == Float.POSITIVE_INFINITY || dR == Float.NEGATIVE_INFINITY) {
                throw new ArithmeticException("Деление на ноль");
            }
            dDen = cB.bi + dR*cB.a;
            div.a = (dR*a + bi)/dDen;
            div.bi = (dR*bi - a)/dDen;
        }
        return (div);
    }

    public Complex Mult( Complex cB ) {
        Complex prod = new Complex();
        prod.a = a*cB.a - bi*cB.bi;
        prod.bi = bi*cB.a + a*cB.bi;
        return (prod);
    }



    public String toString() {
        return "Complex{" + "A=" + this.a + ", bI=" + this.bi +"}";
    }
}

public class Main {

    public static Vector<Complex> MultiDiv(Vector<Complex> v1, Vector<Complex> v2) throws IllegalArgumentException{

        try {
            for (int i=0; i< v1.capacity(); i++){
                v1.set(i,v1.get(i).Div(v2.get(i)));
            }
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Векторы имеют разную длину");
        }
        return v1;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Объявляем Scanner
        System.out.print("Введите число: ");
        int n = input.nextInt(); // Читаем с клавиатуры размер массива и записываем в size
        Vector <Complex> a= new Vector<Complex> (n);
        Vector <Complex>  b= new Vector<Complex> (n);
        Vector <Complex>  c= new Vector<Complex> (n);
        Vector <Complex>  d= new Vector<Complex> (n);

        try {
            for (int i=0;i<n;i++){
                a.add(new Complex(Math.random() * (2 * n + 1) - n,Math.random() * (2 * n + 1) - n));
                b.add(new Complex(Math.random() * (2 * n + 1) - n,Math.random() * (2 * n + 1) - n));
                c.add(a.get(i).getPlus(b.get(i)));
            }
        }catch (OutOfMemoryError e){
            throw new OutOfMemoryError("виртуальная машина Java не может выделить объект из-за нехватки памяти");
        }catch (Exception e){
            System.out.println("Что-то пошло не так");
        }

        System.out.println("Первый вектор: ");
        for (int i=0;i<n;i++) {
            System.out.print(a.get(i).toString()+ "; ");
        }
        System.out.println("");
        System.out.println("Второй вектор: ");
        for (int i=0;i<n;i++) {
            System.out.print(b.get(i).toString()+ "; ");
        }
        System.out.println("");
        System.out.println("Сумма: ");
        for (int i=0;i<n;i++) {
            System.out.print(c.get(i).toString()+ "; ");
        }
        System.out.println("");

        System.out.println("Деление: ");
        d.addAll(MultiDiv(a,b));
        for (int i=0;i<n;i++) {
            System.out.print(c.get(i).toString()+ "; ");
        }
        System.out.println("");




    }
}



