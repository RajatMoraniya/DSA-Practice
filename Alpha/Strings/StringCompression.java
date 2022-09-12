package Alpha.Strings;

public class StringCompression {
    public static String compresss(String str){
        StringBuilder sb = new StringBuilder("");
//            String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while ( i < str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
            }
//            newStr+= str.charAt(i);
            sb.append(str.charAt(i));
            if(count>1){
//                newStr+=count.toString();
                sb.append(count);
            }
        }
//        return newStr;
        return sb.toString();
    }
    public static void main(String[] args) {
        String str ="aaabbcccdd";
        String ans = compresss(str);
        System.out.println(ans);
    }
}
