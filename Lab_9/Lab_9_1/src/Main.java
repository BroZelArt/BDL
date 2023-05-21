import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class Main {
    // Задана коллекция строк. Получить список без дубликатов с сохранением порядка.
    public static void main(String[] args) {
                List<String> strings = Arrays.asList("Панки", "хой", "Панки", "хой", "свет", "Свет");
                List<String> Strings1 = strings.stream().distinct().collect(Collectors.toList());
                System.out.println(Strings1);
            }
}
