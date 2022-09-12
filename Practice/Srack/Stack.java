package Practice.Srack;

public class Stack {
  public static int factorial(int n){

     int factnm1 = factorial(n-1);
     int ans = n*factnm1;
     return ans;
  }
}
