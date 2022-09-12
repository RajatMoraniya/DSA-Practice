package Practice.gfg;

public class pracc {
    public static void main(String[] args) {
        int arr[] = {7, 3, 5, 4, 5, 3, 4};

        for(int i = 0 ; i < arr.length ; i++){
            for (int j = i+i; j < arr.length; j++) {
                if(arr[i] != arr[j]){
                    System.out.println(arr[i]);
                }
            }

        }
    }
}
