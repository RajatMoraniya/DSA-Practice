package Practice;

public class javava {
    public static void main(String[] args) {
        String s = "{}{{}{}}";
        int count = 0;
        boolean bool = false;
        for(int i = 1 ; i < s.length()-1 ; i++) {
            if (s.charAt(i) == '{') {
                count++;

            }
            else if(s.charAt(i)=='}'){
                count--;
            }
        }
        if(count==0&&s.charAt(0)=='{' && s.charAt(s.length()-1)=='}'){
            bool = true;
            System.out.println("this is valid");
        }
        else{
            bool = false;
            System.out.println("this is invalid");
        }
    }
}
