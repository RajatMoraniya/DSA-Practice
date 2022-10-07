package PepCode.RecursionAndBacktracking;

import java.util.Scanner;

public class printIncreasing {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printDecreasing(n);
    }

    public static void printDecreasing(int n){
        if(n==0){
            return;
        }
        printDecreasing(n-1);
        System.out.println(n);
    }
}