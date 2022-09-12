package LinkedList_CN;
import java.util.*;

public class QueueUsingStack {
    // Java program to implement Queue using
// two stacks with costly enQueue()
/*
Time Complexity:
Push operation: O(N).
In the worst case we have empty whole of stack 1 into stack 2.
Pop operation: O(1).
Same as pop operation in stack.
Auxiliary Space: O(N).
Use of stack for storing values.*/
        static class Queue
        {
            static Stack s1 = new Stack();
            static Stack s2 = new Stack();

            static void enQueue(int x)
            {
                // Move all elements from s1 to s2
                while (!s1.isEmpty())
                {
                    s2.push(s1.pop());
                    //s1.pop();
                }

                // Push item into s1
                s1.push(x);

                // Push everything back to s1
                while (!s2.isEmpty())
                {
                    s1.push(s2.pop());
                    //s2.pop();
                }
            }

            // Dequeue an item from the queue
            static int deQueue()
            {
                // if first stack is empty
                if (s1.isEmpty())
                {
                    System.out.println("Q is Empty");
                    System.exit(0);
                }

                // Return top of s1
                int x = s1.peek();
                s1.pop();
                return x;
            }
        };

        // Driver code
        public static void main(String[] args)
        {
            Queue q = new Queue();
//            q.enQueue(1);
//            q.enQueue(2);
//            q.enQueue(3);

//            System.out.println(q.deQueue());
//            System.out.println(q.deQueue());
//            System.out.println(q.deQueue());
        }
    }

