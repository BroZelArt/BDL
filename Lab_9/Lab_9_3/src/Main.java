import java.util.Arrays;
import java.util.List;
public class Main {
    //Задана коллекция чисел. Получить сумму всех кратных 7.
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(7, 1, 15, 14, 4, 3, -7);

        int sum = numbers.stream()
                .filter(n -> n % 7 == 0)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Sum: " + sum);
    }
}