package LinkedList_CN;
//CN.............

public class StackUsingArray {
    private int data[];
    private int top;

    public StackUsingArray(){
        data = new int[10];
        top = -1;
    }
    public StackUsingArray(int capacity){
        data = new int[capacity];
        top = -1;
    }

    public void doubleCapacity(){
        int temp[] = data;
        data = new int[2*temp.length];
        for (int i = 0; i <= top ; i++) {
            data[i] = temp[i];
        }
    }

    public boolean isEmpty(){
//        if(top==-1){
//            return true;
//        }else{
//            return false;
//        }
        return(top==-1);
    }

    public int size(){
        return  top+1;
    }

    public int top(){
        if(size()==0){
            System.out.println("Stack is empty");
        }
        return data[top];
    }

    public void push(int element){
        if(size() == data.length){
            doubleCapacity();
        }
        top++;
        data[top] = element;
    }

    public int pop(){
        if(size()==0){
            System.out.println("Stack is Empty");
        }
        int temp = data[top];
        top--;
        return temp;
    }

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray();
        for (int i = 1; i <= 15 ; i++) {
            stack.push(i);
        }

        System.out.println(stack.isEmpty());
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.top());
    }
}
