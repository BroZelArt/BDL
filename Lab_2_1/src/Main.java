import java.util.*;
import java.util.regex.*;
//  Ввести n слов с консоли. Среди слов, состоящих только из цифр, найти слово-палиндром. Если таких слов больше одного, найти второе из них.
public class Main {
    public static boolean isNumericWord(String word) {
        Pattern numericPattern = Pattern.compile("[+-]?[0-9]+");
        Matcher numericMatcher = numericPattern.matcher(word);
        return numericMatcher.matches();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Объявляем Scanner
        System.out.println("Введите количество строк: ");
        int size = input.nextInt(); // Читаем с клавиатуры размер массива и записываем в size
        String[] inputString = new String[size]; // Создаём массив строк
        System.out.println("Введите элементы массива:");
        /*Пройдёмся по всему массиву, заполняя его*/
        for (int i = 0; i < size; i++) {
            inputString[i]=input.next(); // Заполняем массив строками, введёнными с клавиатуры
        }
        List<String> palindrome = new ArrayList<String>(); // массив с палиндромами
        for (String word : inputString) {
            if (isNumericWord(word)) {
                boolean isInputPalindrome = word.equals(new StringBuilder(word).reverse().toString());
                if (isInputPalindrome) {
                    palindrome.add(word);
                }
            }
        }
        if (palindrome.size() == 0) {
            System.out.println( "Нет палиндромов");
            return;
        }
        if (palindrome.size() == 1) {
            System.out.println( "Палиндром один: " + palindrome.get(0));
        } else {
            System.out.println("Палиндромов несколько: "  + palindrome.get(1));
        }
        }
    }




