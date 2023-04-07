/*
В следующих заданиях требуется ввести последовательность строк из текстового потока и выполнить указанные действия.
При этом могут рассматриваться два варианта:
  каждая строка состоит из одного слова;
 каждая строка состоит из нескольких слов.
Имена входного и выходного файлов, а также абсолютный путь к ним могут быть введены как параметры
командной строки или храниться в файле.

8. Определить частоту повторяемости букв и слов в стихотворении Александра Пушкина.
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<String>();
        StringBuilder oneLongString =new StringBuilder();
        HashMap<String,Integer> hasWord =new HashMap<>();
        HashMap<Character,Integer> hasChar =new HashMap<>();
        System.out.println("Введите стихи Пушкина: ");
        String s = null;

        // Запоминаем стихи
        while ( true ) {
            s = scanner.nextLine().replaceAll("[.,?!:-;]", "").toUpperCase();
            if ( s.isEmpty() )
                break;
            words.addAll(Arrays.asList(s.split(" ")));
            oneLongString.append(s);
        }

        for (int i=0; i<words.size(); i++) {
            if (words.get(i).isEmpty()) words.remove(i);
        }

        //Хэшируем слова
            for ( String str : words )
                if ( hasWord.containsKey(str)) hasWord.put(str,hasWord.get(str)+1);
            else hasWord.put(str,1);

        System.out.println("Частота встречи слов");
            for (String str : hasWord.keySet())
                System.out.println(str+ " - " + hasWord.get(str));

        //Хэшируем буквы
            for (int i=0; i< oneLongString.length(); i++) {
                char ch = oneLongString.charAt(i);
                if (hasChar.containsKey(ch)) hasChar.put(ch, hasChar.get(ch) + 1);
                else hasChar.put(ch, 1);
            }

        System.out.println("--------------------------------------------");
        System.out.println("Частота встречи букв");
        for (Character str : hasChar.keySet())
            System.out.println(str+ " - " + hasChar.get(str));
        scanner.close();
    }
}
