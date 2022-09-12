package Alpha.BitManipulation;

public class Check_isPower2 {
    public static boolean isPowerofTwo(int n){
        return (n&(n-1))==0;
    }
    public static void main(String[] args) {
        System.out.println("4 is power of 2 : " + isPowerofTwo(4));
        System.out.println("6 is power of 2 : " + isPowerofTwo(6));
        System.out.println("8 is power of 2 : " + isPowerofTwo(8));
        System.out.println("10 is power of 2 : " + isPowerofTwo(10));
        System.out.println("16 is power of 2 : " + isPowerofTwo(16));
        System.out.println("15 is power of 2 : " + isPowerofTwo(15));
    }
}
