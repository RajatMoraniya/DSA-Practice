package LinkedList_CN;

public class prqctice2 {
    /*Given two sorted arrays, the task is to merge them in a sorted manner.

Examples:

Input: arr1[] = { 1, 3, 4, 5}, arr2[] = {2, 4, 6, 8}

Output: arr3[] = {1, 2, 3, 4, 4, 5, 6, 8}

Input: arr1[] = { 5, 8, 9}, arr2[] = {4, 7, 8}

Output: arr3[] = {4, 5, 7, 8, 8, 9}*/

    public static void merge(int arr1[] , int arr2[] , int n1, int n2 , int ans[] ){
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < n1 && j < n2){
            if(arr1[i] < arr2[j]){
                ans[k++] = arr1[i++];
            }
            else{
                ans[k++] = arr2[j++];
            }
        }
        while(i < n1){
            ans[k++] = arr1[i++];
        }
        while(j<n2){
            ans[k++] = arr2[j++];
        }
    }
    public static void main(String[] args) {
        int arr1[] = {1,3,4,5};
        int arr2[] = {2,4,6,8};
        int n1 = arr1.length;
        int n2 = arr2.length;
        int ans[] = new int[n1+n2];
        merge(arr1 , arr2 , n1 ,n2 ,ans);


        for(int i = 0 ; i < ans.length ;i++){
            System.out.print(ans[i]+ " ");
        }
    }
}
