package Practice;
import java.util.*;

public class RemoveDuplicateLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = {1,1,1,3,3,5,5,5};
        int n = arr.length;

        System.out.println(removeDuplicate(arr,n));
    }

    static int removeDuplicate(int arr[], int n){
        if( n == 0 || n == 1) return n;

        int lenght = 0 ;
        for(int i = 0 ; i < n-1 ; i++){
            if(arr[i] != arr[i+1]) arr[lenght++]= arr[i];
        }
        arr[lenght++] = arr[n-1];
        return lenght;
    }
}



