/* При выполнении следующих заданий для вывода результатов создавать новую директорию и файл средствами класса File
 Из текста Java-программы удалить все виды комментариев.
 * */

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;

        public class Main {
            public static void main(String[] args)  throws Exception {
                FileReader fr= new FileReader("C:\\Users\\artem.zelenskiy\\IdeaProjects\\Lab_5\\Lab_5_7\\src\\Java_code.txt");
                Scanner scanner = new Scanner(fr);
                StringBuilder code = new StringBuilder();
                while (scanner.hasNextLine()) {
                    String  s = scanner.nextLine();
                    code.append(s);
                    code.append("\n");
                }
                fr.close();

                System.out.println(code);
                System.out.println(code.indexOf("*/"));
                System.out.println("------------------------");

                int n=code.length();

                while (n>=0){
                          if (code.indexOf("//")>0 && code.indexOf("\n")>0){
                        code.delete(code.indexOf("//"), code.indexOf("\n", code.indexOf("//")));
                    }

                    if (code.indexOf("/*")>=0 && code.indexOf("*/")>=0){
                        code.delete(code.indexOf("/*"), code.indexOf("*/", code.indexOf("/*"))+2);
                    }
                    n=n-code.indexOf("\n")-1;

                }
                Path directory= Files.createDirectory((Paths.get("C:\\Users\\artem.zelenskiy\\IdeaProjects\\Lab_5\\Lab_5_7\\src\\file1")));
                FileWriter nFile = new FileWriter("C:\\Users\\artem.zelenskiy\\IdeaProjects\\Lab_5\\Lab_5_7\\src\\file1\\file1.txt");
                nFile.write(String.valueOf(code));
               nFile.close();
                System.out.println(code);
            }
}