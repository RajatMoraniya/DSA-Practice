package Practice.gfg;
import java.util.*;

public class triplt {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your array size");
            int size = sc.nextInt();
            int arr[]  = new int [size];
            System.out.println("please enter array elements");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println("please enter sum value");
            int sum = sc.nextInt();

            boolean temp = false;

            for (int i = 0; i < size - 2; i++) {
                for (int j = i+1; j < size - 1; j++) {
                    for (int k = j+1; k < size; k++) {
                        if (arr[i] + arr[j] +arr[k] == sum){
                            System.out.println("this triplate is " + arr[i] + " " + arr[j] + " " + arr[k]);
                            temp = true;

                        }
                    }
                }
            }
            if (temp == false){
                System.out.println("triplate not found");
            }

        }

    }
