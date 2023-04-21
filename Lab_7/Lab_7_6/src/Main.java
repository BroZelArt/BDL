
//Напечатать слова русского текста в алфавитном порядке по первой букве.
// Слова, начинающиеся с новой буквы, печатать с красной строки.

import java.util.*;

public class Main {
    public static void main(String[] args) {


                String text = "Сегодня яблоки покупала в магазине,\n" +
                        "Клубнику и апельсины тоже купила мне.\n" +
                        "Но вот дома я поняла, что забыла мандарины,\n" +
                        "Пришлось второй раз идти в магазин, прости Господины.";

                String[] words = text.replaceAll("[^\\p{L} ]", "").toLowerCase().split("\\s+");

                TreeMap<Character, ArrayList<String>> map = new TreeMap<>();

                for (String word : words) {
                    if (!word.isEmpty()) {
                        char firstLetter = word.charAt(0);
                        ArrayList<String> list = map.getOrDefault(firstLetter, new ArrayList<>());
                        list.add(word);
                        map.put(firstLetter, list);
                    }
                }

                // Выводим слова на экран в алфавитном порядке с красной строки при изменении первой буквы
                char prevLetter = ' ';
                for (Map.Entry<Character, ArrayList<String>> entry : map.entrySet()) {
                    char letter = entry.getKey();
                    if (letter != prevLetter) {
                        System.out.println();
                        System.out.print(Character.toUpperCase(letter) + ": ");
                    } else {
                        System.out.print(", ");
                    }
                    ArrayList<String> wordsList = entry.getValue();
                    Collections.sort(wordsList);
                    System.out.print(String.join(", ", wordsList));
                    prevLetter = letter;
                }
            }
        }

