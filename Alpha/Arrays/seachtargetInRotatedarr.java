package Alpha.Arrays;

public class seachtargetInRotatedarr {
    public static int searchIndex(int[] arr, int n , int k){
        int start = 0 ;
        int end = n-1;
        int mid = -1;
        while(start<end){
            mid = start+(end-start)/2 ;
            if(arr[mid]==k){
                return mid;
            }
            else if(arr[mid]<k){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        int target = 0;
        int n = arr.length;
        int ans = searchIndex(arr, n , target);
        System.out.println(ans);
    }
}
