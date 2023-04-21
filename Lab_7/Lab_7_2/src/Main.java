import java.util.ArrayList;

//Из текста удалить все слова заданной длины, начинающиеся на согласную букву.
public class Main {
    public static void main(String[] args) {
        String input = "Удалить все слова длиной пять, начинающиеся на согласную букву.";
        int wordLength = 5;

// Разбиваем строку на слова
        String[] words = input.replaceAll("[^\\p{L} ]", "").split("\\s+");

// Перебираем все слова и заменяем те, которые соответствуют условию
        for (String word : words) {
              // Проверяем длину слова и первую букву
            if (word.length() == wordLength && word.matches("^[бвгджзйклмнпрстфхцчшщ].*")) {
                 input = input.replaceAll(  word , "");
            }
        }

        System.out.println(input);
    }
}