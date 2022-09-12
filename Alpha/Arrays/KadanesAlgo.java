package Alpha.Arrays;

public class KadanesAlgo {
    public static void kadanes(int nums[]){
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < nums.length ; i++) {
            currSum += nums[i];
            if(currSum < 0){
                currSum = 0;
            }
            maxSum = Math.max(currSum,maxSum);
        }
        System.out.println("Mamimum Sum : " + maxSum);
    }
    public static void main(String[] args) {
        int arr[] = {-2,-3,4,-1,-2,1,5,-3};
        kadanes(arr);
    }
}
