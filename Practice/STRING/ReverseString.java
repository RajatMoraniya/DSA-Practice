package Practice.STRING;

public class ReverseString {

    public static void main(String[] args) {
        String str = "rajat";
        String rev = "";
        for(int i = str.length()-1 ; i >=0 ; i--){
            rev+= str.charAt(i);
        }

        System.out.print(rev);
    }
}
