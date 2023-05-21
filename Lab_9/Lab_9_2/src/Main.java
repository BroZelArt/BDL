import java.util.Arrays;
import java.util.List;
public class Main {
    // Задана коллекция строк. Вернуть количество вхождений строки.
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Панки", "хой", "Панки", "хой", "свет", "Свет");

        String String1 = "хой";
        long count = strings.stream()
                .filter(s -> s.equals(String1))
                .count();

        System.out.println("Count: " + count);
    }
}