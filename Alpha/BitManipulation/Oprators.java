package Alpha.BitManipulation;

public class Oprators {
    public static void main(String[] args) {
        // & and
        // & opretor convert 0 1 = 0 , 1 0 = 0 , 0 0 = 0 , 1 1 = 1
        System.out.print("5 & 3 is ");
        System.out.println(5&3);

        // | or
        // opretor convert 0 1 = 1 , 1 0 = 1 , 0 0 = 0 , 1 1 = 1
        System.out.print("5 | 3 is ");
        System.out.println(5|3);

        // ^ XOR same things become 0 diffrent things become 1
        // opretor convert 0 1 = 1 , 1 0 = 1 , 0 0 = 0 , 1 1 = 0
        System.out.print("5 ^ 3 is ");
        System.out.println(5^3);

        // ~ Not (Ones Complement)
        // ~1 = 0
        // ~0 = 1 {-1}
        // but in actual ~0 = -1 because MSB is +ve so It'll become -ve
        //  Most Sig.. Bit -> 1 0 0 0 0 0 0 0 0 1 <- Least Significant Bit
        // if MSB is 0 means Number is Positive
        // else if MSB is 1 means Number is Negative
        System.out.println("~2 is : " + ~2);
        System.out.println("~0 is : " + ~0);
        System.out.println("~-1 is : " + ~-1);
        System.out.println("~1 is : " + ~1);

        // Left Shift <<
        // a<<b = a * 2^b
        System.out.print("5<<3 is : "); // 5*2^3 => 40
        System.out.println(5<<3);

        // Right Shift <<
        // a>>b = a / 2^b
        System.out.print("5>>3 is : "); // 5/2^3 => 0.62 ~= 0
        System.out.println(5>>3);
        System.out.print("6>>1 is : "); // 6/2^1 => 3
        System.out.println(6>>1);



    }
}
