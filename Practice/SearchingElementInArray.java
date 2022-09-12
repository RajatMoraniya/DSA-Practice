package Practice;

public class SearchingElementInArray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int n = arr.length;
        int element = 4;
        int ans = searchIndex(arr,n,element);
        if(ans==-1)
            System.out.println("Index not found");
        else
            System.out.println("Element found at index " + ans);


        printArray(arr);
    }
    public static void printArray(int arr[]){
        for(int i = 0 ; i < arr.length ; i++)
            System.out.print(arr[i] + " ");
    }

    public static int searchIndex(int arr[] , int n , int element){
        int i = -1;
        for(i = 0 ; i <n ; i++)
            if(arr[i] == element)
                return i;
        return -1;
    }

}
