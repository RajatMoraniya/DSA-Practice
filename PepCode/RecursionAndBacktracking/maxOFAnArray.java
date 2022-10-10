package PepCode.RecursionAndBacktracking;

import java.util.Scanner;

public class maxOFAnArray {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int max = maxOfArray(arr , 0);
        System.out.println(max);
    }

    public static int maxOfArray(int[] arr, int idx){
        if(idx == arr.length-1){
            return arr[idx];
        }
        int maxInSmallerArr = maxOfArray(arr, idx+1);
        return Math.max(arr[idx] , maxInSmallerArr);
    }
}
