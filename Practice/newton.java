package Practice;
import java.util.*;

public class newton {
    public static void highestThreeElements(int[] arr){
        Arrays.sort(arr);
        for(int i = arr.length-1 ; i > arr.length-4 ; i--){
            System.out.print(arr[i] + " ");
        }
    }    public static void main(String[] args) {
        int arr[] = {10, 4, 3, 50, 23, 9};
        highestThreeElements(arr);

    }
}
