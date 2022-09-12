package Trees;

import com.sun.source.tree.Tree;

import java.util.Scanner;


public class TreeUse {
    //TakeInput() Recursive;
    public static TreeNode<Integer> takeInput(Scanner sc){
        int n;
//        Scanner sc = new Scanner(System.in);
        System.out.println("Enter next node data ");
        n = sc.nextInt();
        TreeNode<Integer> root = new TreeNode<>(n);
        System.out.println("Enter the children for " + n);
        int childCount = sc.nextInt();
        for (int i = 0; i < childCount; i++) {
            TreeNode<Integer> child = takeInput(sc);
            root.children.add(child);
        }
        return root;
    }

    //Print
    public static void print(TreeNode<Integer> root){
        String s = root.data + " : ";
        for(int i = 0 ; i < root.children.size() ; i++){
            s += root.children.get(i).data + " ,";
        }
        System.out.println(s);
        for (int i = 0 ; i < root.children.size() ; i++){
            print(root.children.get(i));
        }
    }


    //TakeInput Level Wise
    public static TreeNode<Integer> takeInputLevelWise(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter root data : ");
        int rootNode = sc.nextInt();
        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        TreeNode<Integer> root = new TreeNode<>(rootNode);
        pendingNodes.enqueue(root);
        while(!pendingNodes.isEmpty()){
            try {
                TreeNode<Integer> frontNode = pendingNodes.dequeue();
                System.out.println("Enter num of childrens of " + frontNode.data);
                int numChildren = sc.nextInt();
                for (int i = 0; i < numChildren; i++) {
                    System.out.println("Enter " + (i+1) +"th child of " + frontNode.data);
                    int child = sc.nextInt();
                    TreeNode<Integer> childNode = new TreeNode<>(child);
                    frontNode.children.add(childNode);
                    pendingNodes.enqueue(childNode);
                }
            } catch (QueueEmptyException e) {
                // Shouldn't come here
                return null;
            }
        }
        return root;
    }

    //Print LevelWise
    public static void printLevelWise(TreeNode<Integer> root){
        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        pendingNodes.enqueue(root);
        while(!pendingNodes.isEmpty()) {
            try {
                TreeNode<Integer> frontNode = pendingNodes.dequeue();
                String s = frontNode.data + " : ";
                for(int i = 0 ; i < frontNode.children.size() ; i++){
                    pendingNodes.enqueue(frontNode.children.get(i));
                    s += frontNode.children.get(i).data + " ,";
                }
                System.out.println(s);
            } catch (QueueEmptyException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //Count NumNodes;
    public static int numNode(TreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int count = 1;
        for (int i = 0; i < root.children.size() ; i++) {
            count+= numNode(root.children.get(i));
        }
        return count;
    }

    //Largest
    public static int largest(TreeNode<Integer> root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        int ans = root.data;

        for (int i = 0; i < root.children.size() ; i++) {
            ans = Math.max(ans,largest(root.children.get(i)));
        }
        return ans;
    }

    //Height of a tree
    public static int height(TreeNode<Integer> root){
        if(root==null){
            return 0;
        }
        int height = 0;
        for (int i = 0; i < root.children.size(); i++) {
            height = Math.max(height,root.children.get(i).children.size());
        }

        return height+1;
    }

    // Print At K
    public static void printAtK(TreeNode<Integer> root , int k){
        if(k<0){
            System.out.println("-1");
            return;
        }
        if(k==0){
            System.out.println(root.data);
            return;
        }
        for (int i = 0; i < root.children.size(); i++) {
            printAtK(root.children.get(i), k-1);
        }
    }

    //count leaf Nodes
    public static int countLeafNodes(TreeNode<Integer> root){
        int count = 0;
        if(root==null){
            return 0;
        }
        if(root.children.size()==0){
            return 1;
        }
        for (int i = 0 ; i < root.children.size() ; i++){
            count += countLeafNodes(root.children.get(i));
        }
        return count;
    }

    // preorder trAVERSAL
    public static void preorder(TreeNode<Integer> root){
        if(root==null){
            return;
        }
        System.out.print(root.data + " ");
        for (int i = 0; i < root.children.size(); i++) {
            preorder(root.children.get(i));
        }
    }

    //postORder
    public static void postOrder(TreeNode<Integer> root){
        if(root==null){
            return;
        }
        for (int i = 0; i < ; i++) {

        }
        System.out.println(root.children.get(0).data);
    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode<Integer> root = takeInput(sc);
        // 1 3 2 0 3 2 5 0 6 0 4 2 8 0 20 0

//        TreeNode<Integer> root = takeInputLevelWise();
        //

        print(root);


//        printLevelWise(root);


        System.out.println("numNode : " + numNode(root));
        System.out.println("Largest : " + largest(root));
        System.out.println("Height : " + height(root));

        System.out.println("Printig AT K");
        printAtK(root,2);

        System.out.println("Leafs  : " + countLeafNodes(root) );

        System.out.println("Preorder");
        preorder(root);

//        TreeNode<Integer> root = new TreeNode<>(4);
//        TreeNode<Integer> node1 = new TreeNode<>(2);
//        TreeNode<Integer> node2 = new TreeNode<>(5);
//        TreeNode<Integer> node3 = new TreeNode<>(3);
//        TreeNode<Integer> node4 = new TreeNode<>(6);
//        TreeNode<Integer> node5 = new TreeNode<>(1);
//
//        root.children.add(node1);
//        root.children.add(node2);
//        root.children.add(node3);
//        node1.children.add(node4);
//        node1.children.add(node5);
//
//        System.out.println(root.data);

    }
}