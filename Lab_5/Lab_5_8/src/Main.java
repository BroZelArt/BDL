/* При выполнении следующих заданий для вывода результатов создавать новую директорию и файл средствами класса File
    9. Прочитать строки из файла и поменять местами первое и последнее слова в каждой строке.
 * */
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        FileReader fr= new FileReader("C:\\Users\\artem.zelenskiy\\IdeaProjects\\Lab_5\\Lab_5_8\\src\\test.txt");
        Scanner scanner = new Scanner(fr);
        StringBuilder code = new StringBuilder();
        ArrayList<String> str = new ArrayList<String>();
        System.out.println("Первоначальный текст \n");

        while (scanner.hasNextLine()) {
            String  s = scanner.nextLine();
            System.out.println(s);
            str.clear();
            str.addAll(Arrays.asList(s.split(" ")));
            String st= str.get(str.size()-1);
            str.set(str.size()-1, str.get(0));
            str.set(0, st);
            for (String s1:str){
            code.append(s1);
            code.append(" ");
            }
            code.append("\n");
        }
        fr.close();

        Path directory= Files.createDirectory((Paths.get("C:\\Users\\artem.zelenskiy\\IdeaProjects\\Lab_5\\Lab_5_8\\src\\file1")));
        FileWriter nFile = new FileWriter("C:\\Users\\artem.zelenskiy\\IdeaProjects\\Lab_5\\Lab_5_8\\src\\file1\\file1.txt");
        nFile.write(String.valueOf(code));
        nFile.close();
        System.out.println("\n \n Измененный текст\n");
        System.out.println(code);


    }
}