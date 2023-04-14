/*
9 Задан файл с текстом на английском языке. Выделить все различные слова.
Слова, отличающиеся только регистром букв, считать одинаковыми. Использовать класс HashSet.
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FileReader fr= new FileReader("C:\\Users\\artem.zelenskiy\\IdeaProjects\\Lab_6\\Lab_6_2\\src\\test.txt");
        Scanner scanner = new Scanner(fr);
        ArrayList<String> words = new ArrayList<String>();

        StringBuilder oneLongString =new StringBuilder();
        HashSet<String> hasChar =new HashSet<>();

        while (scanner.hasNextLine()) {
            String  s = scanner.nextLine().replaceAll("[.,?!:-;']", "").toUpperCase();
            words.addAll(Arrays.asList(s.split(" ")));
            oneLongString.append(s);
        }

        for ( String str : words )
            if (!hasChar.contains(str)) hasChar.add(str);


        System.out.println("--------------------------------------------");
        System.out.println("Все различные слова: ");
        System.out.println(hasChar);
    }
}