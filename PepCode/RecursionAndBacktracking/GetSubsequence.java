package PepCode.RecursionAndBacktracking;

import java.io.*;
import java.util.*;

public class GetSubsequence {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        ArrayList<String> res = gss(str);
        System.out.println(res);
    }

    public static ArrayList<String> gss(String str) {
        //abc
        if(str.length()==0){
            ArrayList<String> noResult = new ArrayList<>();
            noResult.add(""); // adding blank string for giving 0 size string as element of arraylist
            return noResult;
        }
        char ch = str.charAt(0); // [a]
        String restOfString = str.substring(1); //[ b ,c ]
        ArrayList<String> restOfStringResult = gss(restOfString); // [ -- , -c , b- , bc ]

        ArrayList<String> myRes = new ArrayList<>();
        for(String rs : restOfStringResult){
            myRes.add("" + rs); // [ - -- , - -c , - b- , - bc ]
            myRes.add(ch + rs); // [ a -- , a -c , a b- , a bc ]
        }

        return myRes;

    }
}

