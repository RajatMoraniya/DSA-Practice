package LinkedList_CN;
import java.util.*;

public class BracketBalance {
    // Java program for checking
// balanced brackets

        // function to check if brackets are balanced
        static boolean areBracketsBalanced(String str)
        {
            // Using ArrayDeque is faster than using Stack class
            Deque<Character> stack
                    = new ArrayDeque<Character>();

            // Traversing the String
            for (int i = 0; i < str.length(); i++)
            {
                char x = str.charAt(i);

                if (x == '(' || x == '[' || x == '{')
                {
                    // Push the element in the stack
                    stack.push(x);
                    continue;
                }

                // If current character is not opening
                // bracket, then it must be closing. So stack
                // cannot be empty at this point.
                if (stack.isEmpty())
                    return false;
                char check;
                switch (x) {
                    case ')':
                        check = stack.pop();
                        if (check == '{' || check == '[')
                            return false;
                        break;

                    case '}':
                        check = stack.pop();
                        if (check == '(' || check == '[')
                            return false;
                        break;

                    case ']':
                        check = stack.pop();
                        if (check == '(' || check == '{')
                            return false;
                        break;
                }
            }

            // Check Empty Stack
            return (stack.isEmpty());
        }

        // Driver code
        public static void main(String[] args)
        {
            String str = "([{}])";

            // Function call
            if (areBracketsBalanced(str))
                System.out.println("Balanced ");
            else
                System.out.println("Not Balanced ");
        }
    }
