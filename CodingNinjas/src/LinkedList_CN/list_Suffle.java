package LinkedList_CN;

import java.util.Scanner;

public class list_Suffle {
    Node head;
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            Node next;
        }

        public Node takeInput(){
            Scanner sc = new Scanner(System.in);
            Node head = null;
            Node tail = null;
            int data = sc.nextInt();
            while(data!=-1){
                Node newNode = new Node(data);
                if(head == null){
                    head =  newNode;
                    tail = newNode;
                }
                else{
                    tail.next = newNode;
                    tail = tail.next;
                }
                data = sc.nextInt();
            }
            return head;
        }
    }

    public static void main(String[] args) {

    }
}
