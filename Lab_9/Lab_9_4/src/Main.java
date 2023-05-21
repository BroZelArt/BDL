import java.util.Arrays;
import java.util.List;
import java.util.Optional;
public class Main {
    //Задана коллекция чисел. С помощью метода reduce вернуть максимум и минимум.
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 10, 3, 8, 15, 2);

        Optional<Integer> max = numbers.stream()
                .reduce(Integer::max);

        Optional<Integer> min = numbers.stream()
                .reduce(Integer::min);

            System.out.println("Max: " + max.get());
            System.out.println("Min: " + min.get());

    }
}