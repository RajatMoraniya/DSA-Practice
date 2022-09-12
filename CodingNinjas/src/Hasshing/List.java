package Hasshing;

import java.util.Scanner;

public class List {
    Node head;
    static class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
        }
    }

    public static void printList(Node head){
        if(head==null){
            System.out.println("list is empty");
        }
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static Node takeinput(){
        Scanner sc = new Scanner(System.in);
        Node head = null;
        Node tail = null;
        Node previous = null;
        int data = sc.nextInt();
        while(data != -1){
            Node newNode = new Node(data);
            if(head==null){
                head = newNode;
                tail = newNode;
            }
            else{
                tail.next = newNode;
                tail = tail.next;
                previous = previous.prev;
            }
            data = sc.nextInt();
        }
        return head;
    }
    public static Node reverse(Node head){
        if(head==null || head.next == null){
            return head;
        }
        Node prev = head;
        Node curr = head.next;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = null;
        head = prev;
        return head;
    }

    public static void main(String[] args) {
        Node head = takeinput();
        head = reverse(head);
        printList(head);
    }
}
