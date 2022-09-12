package Practice.gfg;
import java.util.*;

public class findDuplicate {
    public static void findDuplicates(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1;
            if (arr[index] < 0) {
                res.add(Math.abs(arr[i]));
            }
            else {
                arr[index] = -arr[index];
            }
        }
        System.out.println(res);
    }
    public static void main(String[] args) {
        int arr[] = {1,2,1,2,3,3,5,6};
        findDuplicates(arr);
//        System.out.println(findDuplicates(arr));
    }
}
