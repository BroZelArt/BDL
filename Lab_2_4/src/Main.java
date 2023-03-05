import java.text.DecimalFormat;
import java.util.*; // импорт сканера

//Ввести с консоли n – размерность матрицы a[n][n]. Задать значения элементов матрицы в интервале значений
//от -n до n с помощью датчика случайных чисел. Построить матрицу, вычитая из элементов каждой строки матрицы ее среднее арифметическое.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Объявляем Scanner
        DecimalFormat df = new DecimalFormat("###.###"); // Для округления до 3 знкаков после запятой
        System.out.println("Введите размерность матрицы n: ");
        int n = input.nextInt(); //
        double [][] matrix = new double[n][n];
        double [] sr_znach=new double[n];
        System.out.println("Сгенерированная матрица: ");
        for( int i=0; i<n;i++){ // Заполняем матрицу
            for( int j=0; j<n;j++){
                matrix[i][j]=  (Math.random()*(2*n+1) - n);
                System.out.print(df.format(matrix[i][j])+" ");
                sr_znach[i]+=matrix[i][j];
            }
            sr_znach[i]=sr_znach[i]/n;
            System.out.println();
        }
        System.out.println("Итоговая матрица: ");
        for( int i=0; i<n;i++){ // Корректируем матрицу
            for( int j=0; j<n;j++){
                matrix[i][j]= matrix[i][j]- sr_znach[i];
                System.out.print(df.format(matrix[i][j])+" ");
            }
            System.out.println();
        }

    }
}