//Преобразовать каждое слово в тексте, удалив из него все последующие
// (предыдущие) вхождения первой (последней) буквы этого слова.
public class Main {
    public static void main(String[] args) {

        String str = "Раз два дядя мама папа два";

        // Разбиваем строку на слова и перебираем их
        String[] words = str.replaceAll("[^\\p{L} ]", "").toLowerCase().split(" ");
        for (String word: words){
            char ch=word.charAt(0);
            System.out.print(ch+word.replaceAll(String.valueOf(ch),"")+ " ");
        }
        System.out.println();
        System.out.println("Hello world!");
    }
}