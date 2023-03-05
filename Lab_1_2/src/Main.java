        import java.nio.charset.Charset;
        import java.util.Scanner;  // импорт сканера
        import java.util.Random;

        // Вариант 1.  Создать приложение, выводящее n строк с переходом и без перехода на новую строку.
        public class Main {
            public static void main(String[] args) {

                Scanner input = new Scanner(System.in); // Объявляем Scanner
                System.out.println("Введите количество слов: ");
                int size = input.nextInt(); // Читаем с клавиатуры размер массива и записываем в size
                for (int i = 0; i < size; i++) {
                    byte[] array = new byte[15]; // длина строки
                    new Random().nextBytes(array);
                    Charset Charset = null;
                    String generatedString = new String(array, Charset.forName("UTF-8"));
                    System.out.print(generatedString + " ");
                }

                System.out.println();
                System.out.println("С переходом");
                for (int i = 0; i < size; i++) {
                    byte[] array = new byte[15]; // длина строки
                    new Random().nextBytes(array);
                    Charset Charset = null;
                    String generatedString = new String(array, Charset.forName("UTF-8"));
                    System.out.println(generatedString);
                }
            }
        }