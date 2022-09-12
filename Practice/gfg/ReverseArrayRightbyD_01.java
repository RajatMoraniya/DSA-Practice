package Practice.gfg;

public class ReverseArrayRightbyD_01 {
    public static void reverseArraySolv(int arr[] , int d , int n){

        reverseArray(arr,0,d-1);
        reverseArray(arr,d,n-1);
        reverseArray(arr,0,n-1);
    }
    static void reverseArray(int []arr,int start,int end){
        int temp;
        while(start<end){
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++; end--;
        }
    }

    public static void main(String[] args) {
        int arr[] =  {1,2,3,4,5};
        int d = 2;
        int n = arr.length;
        //outpit 3 4 5 1 2

        reverseArraySolv(arr,d,n);
        //print
        for (int i = 0; i <n ; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
