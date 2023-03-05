import java.util.Scanner;

//9. Используя оператор switch, написать программу, которая выводит на экран сообщения
// о принадлежности некоторого значения k интервалам (-10k, 0], (0, 5], (5, 10], (10, 10k].
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Объявляем Scanner
        System.out.println("Введите число: ");
        int n = input.nextInt(); // Читаем с клавиатуры размер массива и записываем в size
        int rez=-1;
        if (n>-10000 & n<=0) rez = 1;
        if (n>0 & n<=5) rez = 2;
        if (n>5 & n<=10) rez = 3;
        if (n>10 & n<=10000) rez = 4;
        switch (rez) {
            case 1:
                System.out.println("Число находится в интервале  (-10k, 0]");
                break;
            case 2:
                System.out.println("Число находится в интервале  (0, 5]");
                break;
            case 3:
                System.out.println("Число находится в интервале  (5, 10]");
                break;
            case 4:
                System.out.println("Число находится в интервале  (10, 10k]");
                break;
            default:
                System.err.println("Число не входит ни в один из интервалов ");
                break;
    }
}
}