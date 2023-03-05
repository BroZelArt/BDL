// Вариант 1 задание 2 Создать приложение,
// которое отображает в окне консоли аргументы командной строки метода main() в обратном порядке.
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
        System.out.print ("Полученнный массив:");
        for (int i = 0; i < size; i++) {
            System.out.print (" " + array[i]); // Выводим на экран, полученный массив
        }
        System.out.println();

        System.out.print ("Перевернутый массив:");
        for (int i =size-1; i >= 0; i--) {
            System.out.print (" " + array[i]); // Выводим на экран, полученный массив
        }
        System.out.println();
    }
}

