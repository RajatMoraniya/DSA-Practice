package Alpha.BitManipulation;

public class CheckODDandEVEN {
    public static void checkOddEven(int n){
        // 2 = 0010 => LSB is 0 so it is even
        // 3 = 0011 => LSB is 1 so it is Odd
        // n & 1 => we can get LSB of each n ;
        int bitmask = 1;
        if((n&bitmask) == 1){
            System.out.println( n + " is ODD number");
        }
        else{
            System.out.println(n + " is EVEN number");
        }
    }
    public static void main(String[] args) {
        checkOddEven(2);
        checkOddEven(3);
        checkOddEven(1);
        checkOddEven(9);
        checkOddEven(698552);
        checkOddEven(6565663);
    }
}
