package Practice.searching;

public class LinearSearch {
    //tc = O(N)   sc = O(1)
    public static int linearSearch(int arr[],int n,int key){
        for(int i = 0 ; i < n ; i++){
            if(arr[i]==key)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {1, 5, 2, 4, 6, 2, 8, 25, 5, 9, 45, 98};
        int n = arr.length;
        int key = 6;
        int index = linearSearch(arr, n, key);
        System.out.println(index);
    }
}

