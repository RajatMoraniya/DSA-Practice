package Practice.sorting;

public class BubbleSort {
    //tc  =  n^2;
    public static void bubbleSort(int[] arr){
        for(int i = 0 ; i < arr.length-1; i++){ //n-1
            for (int j = 0; j < arr.length-i-1; j++) { //n-i-
                if (arr[j] > arr[j + 1]) {
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

        }
    }

    public static void main(String[] args) {
        int arr[] = {3,-15,0,4,-5,6,1};
        int n = arr.length;
        bubbleSort(arr);
        printArray(arr);

    }

    public static void printArray(int [] arr){
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i] + ", ");
        }
    }
}
