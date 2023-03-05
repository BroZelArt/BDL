import java.text.DecimalFormat;
import java.util.*; // импорт сканера

//Ввести с консоли n – размерность матрицы a[n][n]. Задать значения элементов матрицы в интервале значений
// от -n до n с помощью датчика случайных чисел. 8. Вычислить определитель матрицы.
public class Main {

 static double det(double A[][]){ // Находим определитель. Взял из инета, не до окнца понял принцип.
     int n = A.length;
     if(n == 1) return A[0][0];
     double ans = 0;
     double B[][] = new double[n-1][n-1];
     int l = 1;
     for(int i = 0; i < n; ++i){

         int x = 0, y = 0;
         for(int j = 1; j < n; ++j){
             for(int k = 0; k < n; ++k){
                 if(i == k) continue;
                 B[x][y] = A[j][k];
                 ++y;
                 if(y == n - 1){
                     y = 0;
                     ++x;
                 }
             }
         }
         ans += l * A[0][i] * det(B);
         l *= (-1);
     }
     return ans;
 }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Объявляем Scanner
        DecimalFormat df = new DecimalFormat("###.###"); // Для округления до 3 знкаков после запятой
        System.out.println("Введите размерность матрицы n: ");
        int n = input.nextInt(); //
        double [][] matrix = new double[n][n];
        System.out.println("Сгенерированная матрица: ");
        for( int i=0; i<n;i++){ // Заполняем матрица
            for( int j=0; j<n;j++){
                matrix[i][j]= (Math.random()*(2*n+1) - n);
                System.out.print(df.format(matrix[i][j])+" ");
            }
            System.out.println();
        }
        System.out.println("Определитель матрицы равен "+df.format(det(matrix)));
    }


}