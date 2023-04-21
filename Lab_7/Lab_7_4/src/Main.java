import java.util.*;

//9. В стихотворении найти одинаковые буквы, которые встречаются во всех словах.
public class Main {
    public static void main(String[] args) {
        String text = "Над розоавым мораем пурапурный закат," +
                "Ва темноате искарятся золаотые звезады," +
                "Спаит лаес таинственный, иа толаько сверачок спат" +
                "Нае хочеат, над зеленым цвеатет дубрава.";


            String[] words = text.replaceAll("[^\\p{L} ]", "").toLowerCase().split("\\s+");

        Set<Character> commonLetters = new HashSet<>(words[0].length());
            for (char letter : words[0].toCharArray()) {
                boolean isCommon = true;
                for (int i = 1; i < words.length && isCommon; i++) {
                    if (words[i].indexOf(letter) == -1) {
                        isCommon = false;
                    }
                }
                if (isCommon) {
                    commonLetters.add(letter);
                }
            }
        System.out.println( commonLetters);

    }
}