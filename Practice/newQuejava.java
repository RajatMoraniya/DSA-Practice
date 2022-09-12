package Practice;
import java.util.*;

public class newQuejava {
    public static void solution(int Row , int coloum , int arr[][]){
        int i , k = 0 , l = 0;

        while(k < Row && l < coloum){
            for(i = l ; i < coloum ; i++){
                System.out.print(arr[k][i] + " ");
            }
            k++;
            for( i = k ; i < Row ; i++){
                System.out.print(arr[i][coloum-1] + " ");
            }
            coloum--;
            if(k<Row){
                for(i = coloum-1 ; i >= l ; i--){
                    System.out.print(arr[Row-1][i] + " ");
                }
                Row--;
            }
            if(l < coloum){
                for(i = Row-1 ; i >= k ; i--){
                    System.out.print(arr[i][l] + " ");
                }
                l++;
            }
        }
    }
    public static void main(String[] args) {
  //Input: {{1, 2, 3, 4},
        //
        //{5, 6, 7, 8},
        //
        //{9, 10, 11, 12},
        //
        //{13, 14, 15, 16 }}
        //
        //Output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
        //
        //Explanation: The output is matrix in spiral format.

        int Row = 4;
        int coloum = 5;
        int arr[][] = {{1,2,3,4,17},
                {5,6,7,8,18},
                {9,10,11,12,19},
                {13,14,15,16,20}} ;
        solution(Row,coloum,arr);
    }
}
