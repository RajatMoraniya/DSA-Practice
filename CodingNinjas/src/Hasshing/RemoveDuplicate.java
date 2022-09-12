package Hasshing;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoveDuplicate {
    //int[] array duplicate remover
    public static ArrayList<Integer> removeDuplicates(int arr[]){
        ArrayList<Integer> output = new ArrayList<>();
        HashMap<Integer,Boolean> seen = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(seen.containsKey(arr[i])){
                continue;
            }
            output.add(arr[i]);
            seen.put(arr[i],true);
        }
        return output;
    }

    //String duplicate remover
    public static ArrayList<Character> removeDuplicatesString(char[] arr){
        ArrayList<Character> output = new ArrayList<>();
        HashMap<Character,Boolean> seen = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i++){
            if(seen.containsKey(arr[i])) {
                continue;
            }
            output.add(arr[i]);
            seen.put(arr[i],true);
        }
        return output;
    }
    public static void main(String[] args) {
        String str = "abbcd";
        char[] carr = str.toCharArray();
        ArrayList<Character> output = removeDuplicatesString(carr);
        for(int i = 0 ; i < output.size(); i++){
            System.out.print(output.get(i));
        }

//        int arr[] = {1,2,3,4,5,6,6,0,-2,-3,1};
//        ArrayList<Integer> output = removeDuplicates(arr);
//        for (int i = 0; i < output.size(); i++) {
//            System.out.print(output.get(i) + " ");
//        }
    }
}
