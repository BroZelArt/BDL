/*
В следующих заданиях требуется ввести последовательность строк из текстового потока и выполнить указанные действия.
При этом могут рассматриваться два варианта:
  каждая строка состоит из одного слова;
 каждая строка состоит из нескольких слов.
Имена входного и выходного файлов, а также абсолютный путь к ним могут быть введены как параметры
командной строки или храниться в файле.

9. Входной файл содержит совокупность строк. Строка файла содержит строку квадратной матрицы. Ввести матрицу
 в двумерный массив (размер матрицы найти). Вывести исходную матрицу и результат ее транспонирования.
 */

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)  throws Exception {
String fileName="C:\\Users\\artem.zelenskiy\\IdeaProjects\\Lab_5\\Lab_5_6\\src\\test.txt";
        FileReader fr= new FileReader("C:\\Users\\artem.zelenskiy\\IdeaProjects\\Lab_5\\Lab_5_6\\src\\test.txt");
        Scanner scanner = new Scanner(fr);
        int x = 0;
        ArrayList<String> strMatrix = new ArrayList<String>();

        while (scanner.hasNextLine()) {
            x++;
            String  s = scanner.nextLine().replaceAll("[.,?!:-;]", "");
            if ( s.isEmpty() )
                break;
            strMatrix.addAll(Arrays.asList(s.split(" ")));
        }


        System.out.println("Исходная матрица размером " + x +"x"+ x);

int [][] matrix=new int [x][x];

        System.out.println("Исходная матрица: ");
        for(int i=0; i<x; i++){
            for(int j=0; j<x; j++){
                matrix[i][j]= Integer.parseInt(strMatrix.get(i*x+j));
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }

        for (int i = 0; i < x; i++) {
            for (int j = i+1; j < x; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        System.out.println("Транс матрица: ");
        for(int i=0; i<x; i++){
            for(int j=0; j<x; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }

    }
}
