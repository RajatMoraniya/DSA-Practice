package PepCode.RecursionAndBacktracking;

import java.util.Scanner;

public class Power_Logarithmic {
    // x^n = x^n/2 * x^n/2 ;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();

        int pw = power(x,n);
        System.out.println(pw);
    }

    public static int power(int x, int n){
        if(n==0){
            return 1;
        }

        int powerNby2 = power(x,n/2);
        int pw = powerNby2*powerNby2;
        if(n%2==1){
            pw = pw*x;
        }
        return pw;
    }

}
