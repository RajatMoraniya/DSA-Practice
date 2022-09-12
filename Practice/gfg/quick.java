package Practice.gfg;
//leetcode 34 ;
//find-first-and-last-position-of-element-in-sorted-array

public class quick {
    public static int[] searchRange(int[] nums, int target) {
        int l = firstGreaterEqual(nums, target);
        if (l == nums.length || nums[l] != target)
            return new int[] {-1, -1};
        int r = firstGreaterEqual(nums, target + 1) - 1;
        return new int[] {l, r};
    }

    // find the first index l s.t A[l] >= target
    // return A.length if can't find
    public static int firstGreaterEqual(int[] arr, int target) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= target)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        int arr[] = {5,6,7,8,10,10,15};
        int target = 10;
        int ans[] = searchRange(arr,target);
        for(int i = 0 ; i < ans.length ; i++){
            System.out.print(ans[i] +" ");
        }
    }
}