package Alpha.Arrays;

public class DiagonalSum {
    public static int CalcdiagonalSum(int[][] matrix, int n) {
        int sum = 0;
        //n^2
//        for (int i = 0; i <  matrix.length ; i++) {
//            for (int j = 0 ; j < matrix[0].length ; j++) {
//                if (i == j) {
//                    sum += matrix[i][j];
//                } else if (i + j == n - 1) {
//                    sum += matrix[i][j];
//                }
//            }
//        }

        for (int i = 0; i < matrix.length; i++) { //O(n);
            //pd
            sum+= matrix[i][i];
            //sd
            if(i != matrix.length-1-i) { // i!=j
                sum += matrix[i][n - 1 - i]; // i+j=n-1 so j = n-1-i;
            }
        }
    return sum;
    }
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}};
        int n = arr.length;

        int diagonalSum = CalcdiagonalSum(arr,n);
        System.out.println(diagonalSum);
    }


}
