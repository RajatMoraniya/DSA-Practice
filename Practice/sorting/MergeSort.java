package Practice.sorting;

public class MergeSort {
  //  tc = O(nLog n)   sc = O(n)

    public static void main(String[] args) {
        int arr[] = {0,0,1,2,1,0,4,5};
        int n = arr.length;
        divide(arr,0,n-1);
        //print;
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i]+" ");
        }
    }
    //divide function...
    public static void divide(int arr[] , int start , int end){
        if(start>=end){
            return;
        }
        int mid = start+(end-start)/2;
        divide(arr,start,mid);
        divide(arr,mid+1,end);
        conquer(arr,start,mid,end);

    }
    public static void conquer(int arr[] , int start ,int mid, int end){
        //creating space for merged arrays...
        int merged[] = new int[end-start+1];
        //dclaring indexes....
        int idx1 = start,idx2 = mid+1 , idxMerged = 0;

        //1st while loop of same lenghts...
        while (idx1<=mid && idx2<=end){
            if(arr[idx1]<=arr[idx2]){
                merged[idxMerged++] = arr[idx1++];
            }
            else{
                merged[idxMerged++] = arr[idx2++];
            }
        }
        //when 1st while loop fails then any of this two will run;
        while(idx1<=mid){
            merged[idxMerged++] = arr[idx1++];
        }
        while(idx2<=end){
            merged[idxMerged++] = arr[idx2++];
        }
        //merger array copied into the question given main array in main function....
        for(int i=0 , j=start ; i<merged.length; i++,j++){
            arr[j] = merged[i];
        }
    }
}


