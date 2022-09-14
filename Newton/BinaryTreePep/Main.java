package Newton.BinaryTreePep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static class Pair{
        Node node;
        int state;
        Pair(Node node,int state){
            this.node = node;
            this.state = state;
        }
    }
    public static Node construct(Integer[] nodes) {
        Stack<Pair> st = new Stack<>();
        Node root = new Node(nodes[0]);
        Pair rootPair = new Pair(root, 1);
        st.push(rootPair);
        int idx = 1;

        while (!st.isEmpty()) {
            Pair top = st.peek();
            if (top.state == 1) {
                top.state++;
                if (nodes[idx] != null) {
                    Node leftNode = new Node(nodes[idx]);
                    top.node.left = leftNode;

                    Pair leftPair = new Pair(leftNode, 1);
                    st.push(leftPair);
                }
                idx++;
            } else if (top.state == 2) {
                top.state++;
                if (nodes[idx] != null) {
                    Node rightNode = new Node(nodes[idx]);
                    top.node.right = rightNode;

                    Pair rightPair = new Pair(rightNode, 1);
                    st.push(rightPair);
                }
                idx++;
            } else {
                st.pop();
            }
        }
        return root;
    }

    public static void display(Node root){
        if(root==null)
            return;

        String str = "";
        str+= root.left == null ? "." : root.left.data + "";
        str+= " <- " + root.data + " -> ";
        str+= root.right==null ? "." : root.right.data + "";

        System.out.println(str);
        display(root.left);
        display(root.right);
    }

    public static int size(Node root){
        if(root == null){
            return 0;
        }
        int ls = size(root.left);
        int rs = size(root.right);

        return ls+rs+1;
    }

    public static int sum(Node root){
        if(root == null){
            return 0;
        }
        int lsum = sum(root.left);
        int rsum = sum(root.right);

        return lsum+rsum+root.data;
    }

    public static int max(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int lm = max(root.left);
        int rm = max(root.right);

        return Math.max(Math.max(lm,rm),root.data);

    }

    public static int height(Node root){
        if(root==null){
            return -1;
        }
        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh,rh)+1;
    }


    static StringBuilder pre = new StringBuilder("Pre ");
    static StringBuilder in = new StringBuilder("In ");
    static StringBuilder post = new StringBuilder("Post ");

    public static void Traversal(Node node){
        if(node == null)
            return;
//        System.out.println(node.data + " = Pre");
        pre.append(node.data + " ");
        Traversal(node.left);
//        System.out.println(node.data + " = In");
        in.append(node.data + " ");
        Traversal(node.right);
//        System.out.println(node.data + " = Post");
        post.append(node.data + " ");
    }

    public static void main(String[] args) throws IOException {
//        Integer[] nodes = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};


        /*
                 50
               /    \
            25        75
           /  \       /  \
         12   37     62   87
              /        \
            30         70

        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }
        Node root = construct(arr);
//        display(root);

        int size = size(root);
        int sum = sum(root);
        int max = max(root);
        int height = height(root);

//        System.out.println(size);
//        System.out.println(sum);
//        System.out.println(max);
//        System.out.println(height);

        Traversal(root);
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }
}
