package Alpha.Arrays;

public class prefixSum {
    public static void maxprefixSum(int nums[]){
        int maxSum = Integer.MIN_VALUE;
        int tempsum = 0;

        int prefix[] = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = nums[i] + prefix[i-1];
        }

        for (int i = 0 ; i < nums.length ; i++){
            for (int j = i ; j < nums.length ; j++){
                tempsum = (i == 0) ? prefix[j] : (prefix[j] - prefix[i - 1]);
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
//        System.out.println("len " + arr.length);
//        printSubarray(arr);

        maxprefixSum(arr);
    }
}
