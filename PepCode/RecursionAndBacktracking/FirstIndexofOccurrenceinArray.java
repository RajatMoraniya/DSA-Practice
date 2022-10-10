package PepCode.RecursionAndBacktracking;

import java.util.Scanner;

public class FirstIndexofOccurrenceinArray {
    public static void main(String[] args) throws Exception {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int data = sc.nextInt();
        int firstIdxAccur = firstIndex(arr,0,data);
        System.out.println(firstIdxAccur);
    }
    /*
6
15
11
40
4
4
9
4

output = 3
     */

    public static int firstIndex(int[] arr, int idx, int x){
        if(idx == arr.length){
            return -1;
        }

        if(arr[idx] == x ){
            return idx;
        }
        else {
            int fIdxInSmallerArr = firstIndex(arr, idx + 1, x);
            return fIdxInSmallerArr;
        }
    }

}
