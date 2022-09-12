package Hasshing;
import java.util.*;


public class HashmapCN {

    public static void main(String[] args) {
        HashMap<String , Integer> map = new HashMap<>();

        //insert; [ O(log n) ]
        map.put("abc" , 10);
        map.put("def" , 12);

        //check key presence [ O(log n) ]
        if(map.containsKey("abc")){
            System.out.println("Has abc");
        }
        if(map.containsKey("abc1")){
            System.out.println("Has abc1");
        }

        //check value presence [ O(n) ]
        if(map.containsValue(10)){
            System.out.println("Has value 10");
        }

        //get Value [ O(log n) ]
        int v = 0;
        if(map.containsKey("abc1")) {
            v = map.get("abc1");
        }
        System.out.println(v);

        //remove [ O(log n) ]
//        int s = map.remove("abc");
//        System.out.println(s);
//
//        map.remove("def");

        // size
        System.out.println("size : " + map.size());

        //Iterete over map { map.keySet(); }
        Set<String> keys = map.keySet();
        //fast loop
        for(String str : keys){
            System.out.println(str);
        }


    }
}
