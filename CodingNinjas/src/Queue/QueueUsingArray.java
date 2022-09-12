package Queue;

public class QueueUsingArray {
    private int data[];
    private int front;
    private int rear;
    private int size;

    public QueueUsingArray(){
        data = new int[10];
        front = -1;
        rear = -1;
        size = 0;
    }
    public QueueUsingArray(int capacity){
        data = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }
    int size(){
        return size;
    }

    boolean isEmpty(){
        return(size==0);
    }


}
