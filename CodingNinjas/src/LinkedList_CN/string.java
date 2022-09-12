package LinkedList_CN;

public class string {
    public void reverseLinkedList(Node head){
//        if(head==null || head.next = null){
//            return ;
//        }
        Node temp = head;
        Node curr = head.next;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = temp;
            temp = curr;
        }
        head.next = null;
        head = temp;
    }
    public static void main(String[] args) {

    }
}
