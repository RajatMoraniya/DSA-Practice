package Practice;

public class prac {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        int k = 25;
        int n = arr.length;
        boolean flag = false;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i+1; j < n-1 ; j++) {
                for (int l = j+1; l < n; l++) {
                    if (arr[i] + arr[j] + arr[l] == k){
                        System.out.println("triplate is " + arr[i] +" " +arr[j] + " "+arr[l]);
                        flag = true;
                        }
                }
            }
        }
        if (flag == false){
            System.out.println("not found");
        }
    }
}
