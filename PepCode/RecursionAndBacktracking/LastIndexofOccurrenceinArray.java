package PepCode.RecursionAndBacktracking;

import java.util.Scanner;

public class LastIndexofOccurrenceinArray {
    public static void main(String[] args) throws Exception {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int data = sc.nextInt();
        int lastIdxAccur = lastIndex(arr,0,data);
        System.out.println(lastIdxAccur);
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

output = 4
     */


    public static int lastIndex(int[] arr, int idx, int x) {
        if (idx == arr.length) {
            return -1;
        }

        int lastIdxInSmallerArr = lastIndex(arr, idx + 1, x); // (-1 | i)
        if (lastIdxInSmallerArr == -1) { // (lastIdxInSmallerArr == -1)
             if (arr[idx] == x) {
                return idx;
             }
             else{
                return -1;
             }
        }
        else { // (lastIdxInSmallerArr == i)
            return lastIdxInSmallerArr;
        }
    }
}
