package Practice.STRING;

public class JAVA {
    public static String reverseString(String str){
        String rev = new String();
        for(int i = str.length()-1 ; i >=0 ; i--){
            rev = rev + str.charAt(i);
        }
        return rev;
    }

    public static String stringSum(String s1 , String s2){
        // [1] reverse both strings....
        s1 = reverseString(s1); s2 = reverseString(s2);


        // [2]   n1 & n2..declairing string lenghts..
        int n1 = s1.length();  int n2 = s2.length();

        // [3] Creating #Carry & #i & #j & #String_sum.......
        int carry = 0 , i = 0 , j = 0 ; String sum = "";


        // [4] Adding digits till both of index are same.....
            while (i <n1 && j <n2){
                int d1 = s1.charAt(i)-'0';  //digit at s1==i index;
                int d2 = s2.charAt(j)-'0';  //digit at s2=j  index;
                int s = d1+d2+carry;
                carry = s/10;
                sum += s%10;
                i++; j++;
            }

            // [5.a] Run whem String 1 length is bigger than S2 after running upper 4th loop;
            while (i<n1){
                int d1 = s1.charAt(i)-'0';
                int s = d1+carry;
                carry = s/10;
                sum += s%10;
                i++;
            }
            // [5,b] Run when String 2 lenght is bigger than S1 after running the toppest 4th loop...;
            while (j<n2){
                int d2 = s2.charAt(j)-'0';
                int s = d2+carry;
                carry = s/10;
                sum += s%10;
                j++;
            }

            // [6] [after running the 5th loops if carry still remain some value then add carry to sum directly.....]
            if(carry!=0){
                sum+=carry;
            }
            // [7] Reversing the Sum array and Return IT.....
          return reverseString(sum);
    }

    public static void main(String[] args) {
        String s1 = "3";
        String s2 = "98";
        System.out.println(stringSum(s1,s2));
    }
}
