package Practice.STRING;

import Practice.LinkedList.LLI;

public class LinkedList {
    Node head;
     class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
//    public void addFirst(int data){
//        Node newNode = new Node(data);
//        if(head==null){
//            head = newNode;
//            return;
//        }
//        newNode.next = head;
//        head = newNode;
//    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next!=null){
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }
    public void printList(){
        if(head==null){
            System.out.println("List is Empty");
        }
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public void reverseIterative() {
        if(head == null || head.next == null){
            return;
        }
        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = null;
        head = prev;
    }
//    public Node reverseRecursive(Node head){
//        if(head == null || head.next == null){
//            return head;
//        }
//
//        Node newHead =  reverseRecursive(head.next);
//        head.next.next = head;
//        head.next = null;
//        return newHead;
//    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.printList();
        list.reverseIterative();
//        list.head = list.reverseRecursive(list.head);
        list.printList();
    }
}
