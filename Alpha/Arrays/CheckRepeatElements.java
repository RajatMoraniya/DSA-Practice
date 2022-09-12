package Alpha.Arrays;

import java.util.HashMap;
import java.util.HashSet;

public class CheckRepeatElements {
    public static boolean checkRepeated(int arr[] , int n){
        for(int i = 0 ; i < n ; i++){
            for (int j = i+1; j < n; j++) {
                if(arr[i]==arr[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkRepeatedHashSet(int arr[] , int n){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if(set.contains(arr[i])){
                return true;
            }
            else{
                set.add(arr[i]);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,4};
        int n = arr.length;
        System.out.println(checkRepeated(arr,n));
        System.out.println(checkRepeatedHashSet(arr,n));
    }
}
