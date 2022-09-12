package Practice;

import java.util.*;

public class Weekday_testOne {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Sara and Pattern
     int n= 3;
         /*  for (int row = 0; row < N; row++) {
            int num = row * 6;
            for (int col = 0; col < N; col++) {
                System.out.print(num + " ");
                num = num + 4;
            }
            System.out.println();
        }
*/

         //Pair Em UP

          n = sc.nextInt();
         int a [] = new int [n];

         for(int i = 0 ; i<n ; i++ ){
         a[i] = sc.nextInt();
         }
         Arrays.sort(a);
         int maxi = -1;

         for(int i = 0 ; i<n ; i++){
         int cur = a[i] + a[n-i-1];
         if(maxi<cur){
         maxi = cur;}

         }
         System.out.println(maxi);

    // A boolean Matrix Problem;
  /*  Scanner sc = new Scanner(System.in);
    int tc = Integer.parseInt(sc.nextLine());
    boolean isOnePresent = false;
    int r , c ;

	while(tc > 0) {
        String arr1[] = sc.nextLine().split(" ");
        r = Integer.parseInt(arr1[0]);
        c = Integer.parseInt(arr1[1]);

        String allOnes = "" , allZeros = "";
        for (int i = 0 ; i < c ; i++){
            allOnes += "1 ";
            allZeros += "0 ";
        }

        for (int i = 0 ; i < r ; i++){
            String line = sc.nextLine();
            if (line.indexOf('1')== -1) {
                System.out.println(allZeros);
            } else {
                System.out.println(allOnes);
            }
        }
        tc--;
    }
}*/

    }
}


