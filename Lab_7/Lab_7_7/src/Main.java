// 8.Подсчитать, сколько раз заданное слово входит в текст.
public class Main {
    public static void main(String[] args) {
        String poem = "Над розоавым цвет пурапурный закат," +
                "Ва темноате цвет золаотые звезады," +
                "Спаит лаес таинственный, иа цвет сверачок спат" +
                "Нае хочеат, над цвет цвет дубрава.";

        // Разбиваем строку на слова и перебираем их
        String[] words = poem.replaceAll("[^\\p{L} ]", "").toLowerCase().split(" ");
        String word="цвет";
        int count=0;

        for (int i=0;i<words.length;i++){
            if (words[i].equals(word)){
                count++;
            }
        }

        System.out.println("Слово "+ word +" встречается в тексте " + count +" раз!");
    }
}