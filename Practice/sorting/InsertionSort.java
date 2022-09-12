package Practice.sorting;
 //tc = 0(N);
public class InsertionSort {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        // Insertion Sort

        int arr[] = {5,6,4,3,1,2};
        for(int i = 1 ; i<arr.length ; i++){ // travel unsorted part
            int current = arr[i] ;
            int j = i-1; //sorted part = j
            while(j>=0 && current < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            //placement
            arr[j+1] = current;
        }
        printArray(arr);
    }
}

