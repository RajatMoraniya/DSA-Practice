package PepCode.RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Scanner;

public class Get_Keypad_Combination {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        ArrayList< String> words = getKPC(str);
        System.out.println(words);
    }

    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx","yz"};

    public static ArrayList<String> getKPC(String str) {
        return null;
    }

}
