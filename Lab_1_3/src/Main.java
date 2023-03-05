// Вариант 2.  8.  Ввести с консоли n целых чисел и поместить их в массив.
// На консоль вывести: Простые числа.

import java.util.Scanner; // импорт сканера


public class Main {

    public static boolean isSimple(Integer number) { //Для нахождение простых чисел
        if(number < 2) return false;
        for(int i = 2; i <= number / 2; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // Объявляем Scanner
        System.out.println("Введите длину массива: ");
        int size = input.nextInt(); // Читаем с клавиатуры размер массива и записываем в size
        int array[] = new int[size]; // Создаём массив int размером в size
        System.out.println("Введите элементы массива:");
        /*Пройдёмся по всему массиву, заполняя его*/
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt(); // Заполняем массив элементами, введёнными с клавиатуры
        }
        System.out.println("Просые числа:");
        for (int i = 0; i < size; i++) {
           if (isSimple(array[i])==true){
               System.out.print(array[i]+", ");
           }; // Выводим на экран, полученный массив
        }

    }
}