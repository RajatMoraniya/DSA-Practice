package Alpha.Arrays;
import java.util.*;


public class PrintMAXandMINofArrSubarray {
    public static void printSubarray(int arr[]){
        int total = 0;
        int sumMax = Integer.MIN_VALUE;
        int sumMin = Integer.MAX_VALUE;
        int tempsum;

        for (int i = 0; i < arr.length; i++) { //start
            for (int j = i; j < arr.length ; j++) { // end
                tempsum = 0;
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                    tempsum += arr[k];
                }
                total++;
                System.out.println("subarray sum : " + tempsum);
                if(tempsum>sumMax){
                    sumMax = tempsum;
                }
                if(tempsum < sumMin){
                    sumMin = tempsum;
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("total " + total);
        System.out.println("minSum " + sumMin);
        System.out.println("maxSum "  + sumMax);
    }

    public static void maxSumSubarr(int nums[]){
        int maxSum = Integer.MIN_VALUE;
        int tempsum;
        for (int i = 0 ; i < nums.length ; i++){
            for (int j = i ; j < nums.length ; j++){
                tempsum = 0;
                for (int k = i; k <= j ; k++) {
                    //subarrsum
                    tempsum += nums[k];
                }
                System.out.println("SubSum : " + tempsum);
                if(tempsum>maxSum){
                    maxSum = tempsum;
                }
            }
        }
        System.out.println();
        System.out.println("MAXSUM : " +maxSum);
    }

    public static void main(String[] args) {
//        int arr[] = {2,4,6,8,10};
        int arr[] = {1,-2,6,-1,3};
        System.out.println("len " + arr.length);
//        printSubarray(arr);

        maxSumSubarr(arr);
    }


}
