package Practice;

public class javaquick {
    public static void quicksort(int arr[] , int start , int end){
        if(start<end) {
            int pidx = partition(arr, start, end);

            quicksort(arr, start, pidx - 1);
            quicksort(arr, pidx + 1, end);
        }

    }

    public static int partition(int arr[], int start , int end){
        int pivot = arr[end];
        int i = start-1;
        for(int j = 0 ; j < end ; j++){
        }

    return i;
    }
    public static void main(String[] args) {

    }
}
