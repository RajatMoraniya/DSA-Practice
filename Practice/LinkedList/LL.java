package Practice.LinkedList;
import java.util.*;

public class LL {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.addFirst("a");
        list.addFirst("is");
        list.addFirst("This");
        list.addLast("list");
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
        System.out.println(list.size());
        list.add(3,"list");
        System.out.println(list);
        list.add("papaer");
        list.removeFirst();
        System.out.println(list);

    }
}
