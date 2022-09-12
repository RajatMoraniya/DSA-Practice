package Practice.STRING;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ArrList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        //add..
        list.add(1);
        list.add(8);
        list.add(2);
        list.add(4);
        System.out.println(list);

        //get
        int ele = list.get(1);
        System.out.println(ele);

        //set
        list.set(3,0);
        System.out.println(list);

        list.add(1,2);
        System.out.println(list);

        list.remove(2);
        System.out.println(list);

        int size = list.size();
        System.out.println(size);


        for(int i = 0 ; i < list.size() ; i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        Collections.sort(list);
        System.out.println(list);
    }
}