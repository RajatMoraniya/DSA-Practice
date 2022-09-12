package LinkedList_CN;

public class practice {
    /*Given an array A[] with N elements, some of which are 0. All you have to do is move the zeros to the right of the array, without changing the order of any other elements.

Input : arr[] = {1, 2, 0, 4, 3, 0, 5, 0};

Output : arr[] = {1, 2, 4, 3, 5, 0, 0, 0};*/

    public static void main(String[] args) {
        int arr[] = {1,2,0,4,3,0,5,0};
        int n = arr.length;
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            if(arr[i] != 0){
                arr[cnt++] = arr[i];
            }
        }
        while (cnt < n){
            arr[cnt++] = 0;
        }

        for(int i = 0 ; i < n ; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
