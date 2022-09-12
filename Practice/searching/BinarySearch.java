package Practice.searching;

//tc = O(logN)   sc = O(1)
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {16,20,25,40,10,12,15}; //binary search works only sorted array;,
        int start = 0; int end = arr.length ; int key = 15;
        int index = binarySearchh(arr , start , end , key);
        System.out.println(index);

    }

    public static int binarySearchh(int[] arr, int start, int end, int key) {
        int mid;
        while(start < end) {
            mid = start+(end-start)/2; //(start+end)/2;
            if(arr[mid] == key)
                return mid;


            if(arr[mid]>key)
                end = mid-1;
            if(arr[mid]<key)
                start = mid+1;
        }
        return -1;
    }
}
