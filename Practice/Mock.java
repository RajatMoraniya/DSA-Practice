package Practice;

public class Mock {
    public static void sort(int arr[], int n) {
        int low = 0, high = n - 1, mid = 0;
        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }
    public static void main (String[]args){
            int arr[] = {0, 2, 1, 2, 0};
            int n = 5;
            sort(arr, n);
            //print
            for (int i = 0; i <n ; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }