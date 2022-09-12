package Practice;

public class Zoom {
    public static int sumOfString(String str) {
        int sum = 0;
        for (int i = 0; i <= str.length() - 1; i++) {
            int digit = Integer.parseInt(String.valueOf(str.charAt(i)));
            sum = sum + digit;
        }
        return sum;
    }
    public static void main(String[] args) {
    String single = "123456";
        System.out.println(sumOfString(single));


//     String s1 = "25";
//     String s2 = "30";
//     int one = Integer.parseInt(s1);
//     int two = Integer.parseInt(s2);
//     int total = one+two;
//        System.out.println(total);


    }
}
