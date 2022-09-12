package Practice.sorting;

public class QuickSort {
    // TC ; => avg or best tc = O(nlogn); worst tc = O(n^2);
    public static void quickSort(int arr[], int start, int end) {
        if(start<end) {
            int pidx = partition(arr, start, end);

            quickSort(arr, start, pidx - 1);
            quickSort(arr, pidx + 1, end);
        }
    }
    public static int partition(int arr[], int start, int end) {
        int pivot = arr[end];
        int i = start - 1;
        //travers;
        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                i++;
                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        //swap pivot;
        int temp = arr[i];
        arr[i] = pivot;
        arr[end] = temp;
        return i;
    }

    public static void main(String[] args) {
        int arr[] = {3,6,4,2,3,1};
        int n = arr.length;
            quickSort(arr, 0, n - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
            System.out.println();
        }
    }

