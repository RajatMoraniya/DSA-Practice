package Trees;

public class Node<T> {
    T data;
    public Node<T> next;
    Node(T data){
        this.data = data;
        next = null;
    }
}