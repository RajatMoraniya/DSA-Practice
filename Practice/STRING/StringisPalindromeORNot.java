package Practice.STRING;

public class StringisPalindromeORNot {
    public static boolean StringCheck(String s){
        int i = 0 , j = s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {

        String s = "rajarajar";
        if(StringCheck(s))
            System.out.println("Yes it is palindrom");
        else
            System.out.println("No");

    }
}
