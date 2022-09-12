package LinkedList_CN;
import static LinkedList_CN.LinkedList.print;
import static LinkedList_CN.LinkedList.takeinput;

public class MergeList {

    //Recursive
    public static Node<Integer> mergeList_Recursive(Node<Integer> first , Node<Integer> second) {
        if(first == null)
            return second;
        if(second == null)
            return first;
        if(first.data < second.data){
            first.next = mergeList_Recursive(first.next , second);
            return first;
        }
        else{
            second.next = mergeList_Recursive(first,second.next);
            return second;
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter ListOne");
        Node<Integer> ListOne = takeinput();
        System.out.println("Enter ListTwo");
        Node<Integer> ListTwo = takeinput();
        Node head = mergeList_Recursive(ListOne , ListTwo);
        print(head);

    }
}
