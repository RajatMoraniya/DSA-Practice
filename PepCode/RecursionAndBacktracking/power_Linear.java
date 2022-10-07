package PepCode.RecursionAndBacktracking;

import java.util.Scanner;

public class power_Linear {
    // x^n = x * x^n-1 ;
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

        int pw = x*power(x,n-1);
        return pw;
    }

}
