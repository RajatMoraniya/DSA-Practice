package Practice.LinkedList;

public class LLI {
    Node head;
    private int size;

     LLI(){
        this.size = size;
    }
     class Node{
        String data;
        Node next;
        Node(String data){
            this.data = data;
            this.next = null;
            size++;
        }
    }
    //add first;
    public void addFirst(String data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    //add last;
    public void addLast(String data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next!=null){
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }
    // delete first
    public void deleteFirst(){
        if(head==null){
            System.out.println("The list is empty");
            return;
        }
        size--;
        head = head.next;
    }
    //delete last
    public void deleteLast(){
        if(head==null){
            System.out.println("This is empty list.");
            return;
        }
        size--;
        if(head.next==null){
            head = null;
            return;
        }
        Node secondLast = head;
        Node lastNode = head.next;
        while (lastNode.next!=null){
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null;
    }

    //getSize;
    public int getSize(){
        return size;
    }


    //print List
    public void printList(){
        if(head==null){
            System.out.println("list is empty");
        }
        Node currNode = head;
        while(currNode!=null){
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }
    public void reverseItrative(){
        if(head == null || head.next == null){
            return;
        }
        Node prevNode = head;
        Node currNode = head.next;
        while (currNode != null){
            Node nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;

    }
    public int count(Node head){
         Node curr  = head;
         int count= 0;
         while(curr!=null){
             count++;
             curr = curr.next;

         }
         return count;
    }
    public Node reverseRecursive(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node newHead =  reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead  ;
    }
    public static void main(String[] args) {
        LLI list = new LLI();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");
        list.addLast("5");
        list.printList();
        System.out.println(list.count(list.head));
        list.head = list.reverseRecursive(list.head);
        list.printList();

    }
}
