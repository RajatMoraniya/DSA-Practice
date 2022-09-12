package LinkedList_CN;

import java.util.Scanner;


public class LinkedList {
    //find node in List
    public static int findNode(Node<Integer> head, int n) {
        // Variable to maintain the position in the list.
        int pos = 0;

        while(head != null) {
            // If element found, return the position of the element.
            if(head.data.equals(n)) {
                return pos;
            }

            head = head.next;
            pos++;
        }

        return -1;
    }


    // deletion in ll
    //insertion at posssition in O(n) ;

    public static Node<Integer> deleteNode(Node<Integer> head , int pos){
        Node<Integer> currNode = head;
        int i =0;
        while(i < pos-1){
            currNode = currNode.next;
            i++;
        }
        currNode.next = currNode.next.next;
        return head;
    }
    public static Node<Integer> insertion(Node<Integer> head , int pos , int data){
        Node<Integer> newNode = new Node<>(data);
        if(pos==0){
            newNode.next = head;
            head = newNode;
            return head;
        }
        Node curr = head;
        int i = 0;
        while (i<pos-1){
            curr = curr.next;
            i++;
        }
        newNode.next = curr.next;
        curr.next = newNode;

        return head;
    }

    //Take Inputfrom User...
    public static Node<Integer> takeinput(){
        Scanner sc = new Scanner(System.in);
        Node head = null , tail = null;
        int data = sc.nextInt();
        while(data!=-1){
            Node<Integer> newNode = new Node<>(data);
            if(head==null){
                head = newNode;
                tail = newNode;
            }
            else {
                tail.next = newNode;
                tail = tail.next;
            }
            data = sc.nextInt();
        }
        return head;
    }
    public static void print(Node<Integer> head){
        if(head == null){
            System.out.println("List is Empty");
        }
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
    //midN0de
    public static Node<Integer> midNode(Node<Integer> head){
        Node<Integer> fast = head;
        Node<Integer> slow = head;
        while(fast.next != null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public static void main(String[] args) {

        Node<Integer> head = takeinput();
        print(head);
        System.out.println();

//        Node mid = midNode(head);
//        System.out.println(mid.data);


//        head = deleteNode(head,2);
//        head = insertion(head ,0, 80);
//        print(head);
    }
}