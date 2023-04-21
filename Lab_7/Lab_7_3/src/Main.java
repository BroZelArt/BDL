//8. Напечатать квитанцию об оплате телеграммы, если стоимость одного слова задана.
public class Main {
    public static void main(String[] args) {
        String input = "Удалить все слова длиной пять, начинающиеся на согласную букву.";
        int wordprice = 5;

// Разбиваем строку на слова
        String[] words = input.replaceAll("[^\\p{L} ]", "").split("\\s+");
        System.out.println("С вам "+ words.length * wordprice +" рублей \nза "
                + words.length + " слов \n" + wordprice + " рублей за слово.");
    }
}