package Practice;
//find inverse of an array

public class iber {
    public static int[] inverseArray(int arr[]){
        int inv[] = new int[arr.length];

        for(int i = 0 ; i < arr.length ; i++){
            int v = arr[i];
            inv[v] = i;
        }
        return inv;
    }
    public static void main(String[] args) {
        int arr[] = {3,4,1,2,0};
        int inverse[] = inverseArray(arr);
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(inverse[i] + " ");
        }
    }
}
