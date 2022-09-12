package Stack;
import java.util.*;

public class nextGreater {
    public static long[] nextLargerElement(long[] arr, int n)
    {
        // Your code here
        Stack<Long> s = new Stack<>();
        long ans[] = new long[n];

        for(int i = n-1 ; i >=0 ; i--){
            if(!s.empty()){
                while(!s.empty() && s.peek() < arr[i]){
                    s.pop();
                }
            }
            ans[i] = s.empty() ? -1 : s.peek();
            s.push(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        long arr[] = new long[n];
//        for(int i = 0 ; i < n ; i++ ){
//            arr[i]= sc.nextLong();
//        }
        long arr []= {3,7,8,5,6,1,1};
        int n = arr.length;
        long ans[] = nextLargerElement(arr,n);
        for(int i = 0 ; i < ans.length ; i++){
            System.out.print(ans[i] + " ");
        }
    }
}
