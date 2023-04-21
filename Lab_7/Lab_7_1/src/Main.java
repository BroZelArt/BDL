//Из небольшого текста удалить все символы, кроме пробелов, не являющиеся буквами.
// Между последовательностями подряд идущих букв оставить хотя бы один пробел.

public class Main {
    public static void main(String[] args) {
        String input = "Теккст, содеррржащий различнные симвооолы, такие как !@#$%^&*()_-+=[]{},.<>/?\\|~`;:\'\", а также цифры и буквы.";
        String output = input.replaceAll("[^\\p{L} ]", "")
                .replaceAll("\\s+", " ")
                .replaceAll("(.)\\1+", "$1 $1");
        System.out.println(output);
    }
}