// Вариант 2.  9.  Ввести с консоли n целых чисел и поместить их в массив.
// На консоль вывести: Отсортированные числа в порядке возрастания и убывания.

import java.util.Scanner; // импорт сканера
public class Main {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // Объявляем Scanner
        System.out.println("Введите длину массива: ");
        int size = input.nextInt(); // Читаем с клавиатуры размер массива и записываем в size
        int array[] = new int[size]; // Создаём массив int размером в size
        System.out.println("Веедите элементы массива:");
        /*Пройдёмся по всему массиву, заполняя его*/
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt(); // Заполняем массив элементами, введёнными с клавиатуры
        }

        for (int i = 0; i < size; i++) { // сортирую массив
            int min=array[i];
            int min_i=i;
            for (int j = i+1; j < size; j++) {
               if (min>array[j]) {
                   min= array[j];
                 //  array[j]=r;
                   min_i=j;
               }
            }
             array[min_i]=array[i];
            array[i]=min;
        }
        System.out.print ("Полученнный массив по возрастанию:");
        for (int i = 0; i < size; i++) {
            System.out.print (" " + array[i]); // Выводим на экран, полученный массив
        }
        System.out.println();

        System.out.print ("Полученнный массив по убыванию:");
        for (int i = size-1; i >=0; i--) {
            System.out.print (" " + array[i]); // Выводим на экран, полученный массив
        }
        System.out.println();
    }
}