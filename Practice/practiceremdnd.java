package Practice;
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework
public class practiceremdnd {
        public static void countDuplicate(int arr[]){
            int count = 0;
            for(int i = 0 ; i < arr.length ; i++){
                if(arr[i] != arr[i+1]) {
                    for (int j = 0; j < arr.length; j++) {
                        if (arr[i] == arr[j]) {
                            count++;
                        }

                        if(count>1) {
                            System.out.println(arr[i] + " " + count);
                        }
                    }
                }
            count = 0;
            }
        }
        public static void main (String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int arr[] = new int [N];
            for(int i = 0 ; i<N ; i++){
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            countDuplicate(arr);
        }
    }