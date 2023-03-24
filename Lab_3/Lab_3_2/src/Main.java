/* Определить класс Квадратное уравнение. Класс должен содержать несколько конструкторов.
Реализовать методы для поиска корней, экстремумов, а также интервалов убывания/возрастания.
 Создать массив объектов и определить наибольшие и наименьшие по значению корни. */

import java.text.DecimalFormat;
import java.util.*;

import java.util.Scanner;

class QuadEquat {
    DecimalFormat df = new DecimalFormat("###.##");
    double a,b,c,x1,x2,d;
    public QuadEquat(){};
    public QuadEquat(double a,double b, double c){
        this.a=a;
        this.b=b;
        this.c=c;
    };
    public QuadEquat( int a, int b, int c){
        this.a=a;
        this.b=b;
        this.c=c;
    };

    public void Root(){
        this.d=this.b*this.b-4*this.a*this.c;
        if (d>=0){
          this.x1=(-b+Math.sqrt(d))/(2*a);
          this.x2=(-b+Math.sqrt(d))/(2*a);
        }

    }

    public void getQuadEquat() {
        System.out.println("Уравнение: "+ df.format(this.a)+ "X^2 + " +df.format(this.b)+"X + "+df.format(this.c));
    }
    public void getRoot(){
        if (d>=0){
            System.out.println("Корни уравнения: "+ df.format(this.x1)+ " и " +df.format(this.x2)+";");
        }
        else{
            System.out.println("Корней уравнения не существует! ");
        }
    }
    public void MinMax() {
double x1=-b/(2*a);
double y1=a*x1*x1+b*x1+c;
if (this.a>0) {
    System.out.println("Уравнение имеет минимум в точке (" + df.format(x1) + ";" + df.format(y1) + ");");
}
else {System.out.println("Уравнение имеет максимум в точке (" + df.format(x1) + ";" + df.format(y1) + ");");}
    }

    public void MinMaxSpan() {
        double x1=-b/(2*a);
        if (this.a>0) {
            System.out.println("Уравнение возрастает на промежутке -∞ до " + df.format(x1) + " и далее убывает до +∞ ;");
        }
        else {System.out.println("Уравнение убывает на промежутке -∞ до " + df.format(x1) + " и далее возрастает до +∞ ;");;}
    }
}
public class Main {
    public static void main(String[] args) {
        double n=20;
        QuadEquat[] qE = new QuadEquat[10];
        double[][] root=new double[10][2];
        for(int i=0;i<10;i++){
            qE[i]=new QuadEquat(Math.random() * (2 * n + 1) - n,Math.random() * (2 * n + 1) - n,Math.random() * (2 * n + 1) - n);
            qE[i].Root();
            qE[i].getQuadEquat();
            qE[i].getRoot();
            root[i][0]=qE[i].x1;
            root[i][1]=qE[i].x2;
        }
        double min,max;
        int imin,imax;
        min=root[0][0];
        max=root[0][0];
        imin=0;imax=0;
        for (int i=0; i<10;i++){
            if (root[i][0]>max){
                max=root[i][0];
                imax=i;
            }
            if (root[i][1]>max){
                max=root[i][0];
                imax=i;
            }
            if (root[i][0]<min){
                min=root[i][0];
                imin=i;
            }
            if (root[i][1]<min){
                min=root[i][0];
                imin=i;
            }

        }

        System.out.println("Набор уравнений имеет максимамльный кореть равный" + max + " у " + (imax+1) + " уравнения;");
        System.out.println("Набор уравнений имеет минимальный кореть равный" + min + " у " + (imin+1) + " уравнения;");

    }
}