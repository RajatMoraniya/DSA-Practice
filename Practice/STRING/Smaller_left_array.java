package Practice.STRING;
import java.util.*;

public class Smaller_left_array {
    static void printPrevSmaller(int arr[], int n) {
        // Create an empty stack
        Stack<Integer> S = new Stack<>();

        // Traverse all array elements
        for (int i = 0; i < n; i++) {
            // Keep removing top element from S while the top
            // element is greater than or equal to arr[i]
            while (!S.empty() && S.peek() >= arr[i]) {
                S.pop();
            }

            // If all elements in S were greater than arr[i]
            if (S.empty()) {
                System.out.print("-1, ");
            } else //Else print the nearest smaller element
            {
                System.out.print(S.peek() + ", ");
            }

            // Push this element
            S.push(arr[i]);
        }
    }

    public static void main(String[] args) {
        int arr[] = {8,2,0,7};
        int n  =arr.length;
        printPrevSmaller(arr,n);
//        System.out.print("-1 ");
//        for(int i = 1 ; i < arr.length ; i++){
//            int j;
//            for (j = i-1; j >= 0 ; j--) {
//                if(arr[j]<arr[i]){
//                    System.out.print(arr[j] + " ");
//                    break;
//                }
//            }
//            if(j==-1){
//                System.out.print("-1 ");
//            }
//        }
    }
}
