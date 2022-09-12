package Practice.sorting;

public class selectionSort {
    // tc == n^2;
    public static void selectionSorting(int [] arr){
        for (int i = 0; i < arr.length-1; i++) { // n-1,n-2,n-3.... =
            int smallest = i;
            for(int j = i +1 ; j < arr.length ; j++){
                if(arr[smallest] > arr[j]){
                    smallest = j;
                }
            }
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = {3,4,-5,6,9,8};
        int n = arr.length;
        selectionSorting(arr);
        printArray(arr);
    }
    public static void printArray(int [] arr){
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i] + ", ");
        }
    }
}
