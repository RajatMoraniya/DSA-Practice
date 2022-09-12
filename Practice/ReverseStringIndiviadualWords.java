package Practice;

import java.io.StringReader;
import java.util.Scanner;

public class ReverseStringIndiviadualWords {
    public static void main(String[] args) {
    String s = "Programming is an Art";
    char [] str = s.toCharArray();

        reverseStringElement(str);
    }
    public static void reverseStringElement(char str[]) {
        int i, wstart = 0;
        int length = str.length;
        for(i = 0  ; i < length ; i++){
            if(str[i]==' ') {
                reverse(str, wstart, i - 1);
                wstart = i+1;
            }
        }
        reverse(str, wstart,length-1);

        for(int j = 0 ; j < length ; j++){
            System.out.print(str[j]);
        }
        System.out.println();
    }

    public static void reverse(char[] str, int start, int end) {
        char temp;
        for(int i = start ; i <= end-i-1 ; i++){
            temp = str[i];
            str[i] = str[end] ;
            str[end] = temp;
        }

    }
}
