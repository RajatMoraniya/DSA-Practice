package Alpha.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BuildTree {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    // Preorder Traversal > Root > Left Subtree > right SubTree
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Inorder Traversal > Left Subtree > Root >Right Sbtree
    public static void inorder(Node root){
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Post order Traversal > Left ST > Right ST > Root
    public static void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data +" ");
    }


    // Level Order Traversal
    public static void levelorder(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else {
                System.out.print(currNode.data + " ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    }

    //Count of Nodes
    public static int countOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftNodes = countOfNodes(root.left);
        int rightNodes = countOfNodes(root.right);

        return leftNodes + rightNodes + 1;
    }

    //Sum of Nodes
    public static int sumOfNodesRecursive(Node root){
        if(root==null){
            return 0;
        }
        int leftNodesSum = sumOfNodesRecursive(root.left);
        int rightNodesSum = sumOfNodesRecursive(root.right);

        return leftNodesSum + rightNodesSum + root.data;
    }

    // Height og Tree;
    public static int heightOfTree(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = heightOfTree(root.left);
        int rightHeught = heightOfTree(root.right);

        return Math.max(leftHeight,rightHeught)+1;
    }

    //Diameter of a Tree (N^2)
    public static int diameter(Node root){
        if(root == null){
            return 0;
        }
        int diameter1 = diameter(root.left); //left
        int diameter2 = diameter(root.right); //right
        int diameter3 =  heightOfTree(root.left) + heightOfTree(root.right) + 1;
        return Math.max(diameter3 , Math.max(diameter1,diameter2));
    }

    // Diameter of A tree [O(N)];
    static class TreeInfo{
        int ht;
        int diam;
        public TreeInfo(int ht , int diam){
            this.ht = ht;
            this.diam = diam;
        }
    }
    public static TreeInfo diameterN(Node root){
        if(root==null){
            return new TreeInfo(0,0);
        }

        TreeInfo left = diameterN(root.left);
        TreeInfo right = diameterN(root.right);

        int myHeight = Math.max(left.ht , right.ht) + 1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;

        int myDiam =  Math.max(diam3 , Math.max(diam1,diam2));

        TreeInfo myInfo = new TreeInfo(myHeight,myDiam);
        return myInfo;
    }

    //Subtree of Another Tree
    // Leetcode 572 ;

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        System.out.println();
        levelorder(root);
        System.out.println();
        System.out.println("countNodesRecursive " + countOfNodes(root));
        System.out.println("Sum of Nodes " + sumOfNodesRecursive(root));
        System.out.println("Height = " + heightOfTree(root));

        System.out.println("Diameter : " + diameter(root) );
        System.out.println("Diameter O(N) : " + diameterN(root).diam);
    }
}

