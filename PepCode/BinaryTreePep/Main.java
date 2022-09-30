package PepCode.BinaryTreePep;

import java.io.IOException;
import java.util.*;

public class Main {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
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

    public static void display(Node root) {
        if (root == null)
            return;

        String str = "";
        str += root.left == null ? "." : root.left.data + "";
        str += " <- " + root.data + " -> ";
        str += root.right == null ? "." : root.right.data + "";

        System.out.println(str);
        display(root.left);
        display(root.right);
    }

    public static int size(Node root) {
        if (root == null) {
            return 0;
        }
        int ls = size(root.left);
        int rs = size(root.right);

        return ls + rs + 1;
    }

    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }
        int lsum = sum(root.left);
        int rsum = sum(root.right);

        return lsum + rsum + root.data;
    }

    public static int max(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int lm = max(root.left);
        int rm = max(root.right);

        return Math.max(Math.max(lm, rm), root.data);

    }

    public static int height(Node root) {
        if (root == null) {
            return -1;
        }
        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;
    }


    static StringBuilder pre = new StringBuilder("Pre ");
    static StringBuilder in = new StringBuilder("In ");
    static StringBuilder post = new StringBuilder("Post ");

    public static void Traversal(Node node) {
        if (node == null)
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

    public static void levelOrder(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        q.add(null);

        while (!q.isEmpty()) {
            Node top = q.poll();
            if (top == null) {
                System.out.println();
                if (!q.isEmpty()) {
                    q.add(null);
                } else {
                    break;
                }
            } else {
                System.out.print(top.data + " ");
                if (top.left != null)
                    q.add(top.left);
                if (top.right != null)
                    q.add(top.right);
            }
        }
    }

    public static void levelOrderQSIZE(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            int qsize = q.size();
            for (int i = 0; i < qsize ; i++) {
                node  = q.remove();
                System.out.print(node.data + " ");

                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            System.out.println();
        }
    }

    public static void IterativePreInPost(Node root){
        Stack<Pair> st = new Stack<>();
        StringBuilder pre = new StringBuilder("");
        StringBuilder in = new StringBuilder("");
        StringBuilder post = new StringBuilder("");
        Pair rootPair = new Pair(root,1);
        st.push(rootPair);

        while(!st.isEmpty()){
            Pair top = st.peek();
            if(top.state==1){ // pre , s++ , left
                top.state++;
                pre.append(top.node.data+ " ");
                if(top.node.left!=null){
                    Pair lp = new Pair(top.node.left , 1);
                    st.push(lp);
                }
            }
            else if(top.state==2){ // in , s++ ,right
                top.state++;
                in.append(top.node.data+" ");
                if(top.node.right!=null){
                    Pair rp = new Pair(top.node.right , 1);
                    st.push(rp);
                }

            }
            else{ // post , pop
                post.append(top.node.data+" ");
                st.pop();
            }
        }

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);

    }

    static ArrayList<Node> nodeToRootPath = new ArrayList<>();
    public static boolean find(Node node, int data){
        if(node == null){
            return false;
        }
        if(node.data==data){
            nodeToRootPath.add(node);
            return true;
        }
        boolean lc = find(node.left , data);
        if(lc){
            nodeToRootPath.add(node);
            return true;
        }
        boolean rc = find(node.right, data);
        if(rc){
            nodeToRootPath.add(node);
            return true;
        }
        return false;
    }

    public static void printKLevelsDown(Node node, int k){
        if(node == null || k <0){
            return;
        }
        if(k==0){
            System.out.println(node.data);
        }
        printKLevelsDown(node.left, k-1);
        printKLevelsDown(node.right, k-1);
    }


    public static void printKLevelsDown2(Node node, int k , Node blocker){
    if(node == null || k <0 || node == blocker){
        return;
    }
    if(k==0){
        System.out.println(node.data);
    }
    printKLevelsDown2(node.left, k-1,blocker);
    printKLevelsDown2(node.right, k-1,blocker);
    }

    public static void printKNodesFar (Node node,int data, int k){
     nodeToRootPath = new ArrayList<>();
     find(node,data);
     for(int i = 0 ; i < nodeToRootPath.size() ; i++){
         printKLevelsDown2(nodeToRootPath.get(i),k-i,i==0 ? null : nodeToRootPath.get(i-1));
     }
    }

    public static void pathToLeafFromRoot(Node node, String path, int sum, int lo, int hi){
        if(node == null){
            return;
        }
        if(node.left == null && node.right==null){
            sum+= node.data;
            if(sum>= lo && sum <= hi) {
                System.out.println(path + node.data);
            }
            return;
        }

        pathToLeafFromRoot(node.left , path + node.data+" ", sum+node.data , lo , hi);
        pathToLeafFromRoot(node.right , path + node.data + " ", sum+ node.data , lo , hi);
    }

    public static Node createLeftCloneTree(Node node){
        if(node == null){
            return null;
        }

        Node lc  = createLeftCloneTree(node.left);
        Node rc = createLeftCloneTree(node.right);

        Node nn = new Node(node.data);
        nn.left = lc;
        node.left = nn;
        node.right = rc;
        return node;
    }

    public static Node transBackFromLeftClonedTree(Node node){
        if(node == null){
            return null;
        }
        Node ln = transBackFromLeftClonedTree(node.left.left);
        Node rn = transBackFromLeftClonedTree(node.right);

        node.left = ln;
        node.right = rn;

        return node;
    }

    public static void printSingleChildNodes(Node node, Node parent){
        if(node == null){
            return;
        }
        if(parent!=null){
            if(parent.left != null && parent.right == null){
                System.out.println(node.data);
            }
            else if(parent.left==null && parent.right != null){
                System.out.println(node.data);
            }
        }

        printSingleChildNodes(node.left , node);
        printSingleChildNodes(node.right , node);
    }

    public static Node removeLeaves(Node node){
        if(node == null){
            return null;
        }
        if(node.left == null && node.right == null){
            return null;
        }

        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);

        return node;
    }

    public static int diameter1(Node node){
        if(node==null){
            return 0;
        }

        // 1 in Left
        int ld = diameter1(node.left);
        //2 in Right
        int rd = diameter1(node.right);

        int lh = height(node.left);
        int rh = height(node.right);
        //3 By Root
        int th = lh+rh+2;

        return Math.max(th,Math.max(ld,rd));
    }


    public static class DiamHt{
        int ht;
        int diam;
        DiamHt(int diam,int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static DiamHt diameterOP(Node node){
        if(node == null){
            return new DiamHt(0,-1); // diam 0 , ht = -1;
        }
        DiamHt l = diameterOP(node.left);
        DiamHt r = diameterOP(node.right);

        int myht = Math.max(l.ht,r.ht)+1;
        int mydiam = Math.max(l.ht+r.ht+2,Math.max(l.diam,r.diam));
        return new DiamHt(mydiam,myht);
    }

    static int tilt = 0;
    public static int tilt(Node node){
        if(node == null)
            return 0;
        int ls = tilt(node.left);
        int rs = tilt(node.right);

        tilt += Math.abs(ls-rs);

        return ls+rs+node.data;
    }

    public static class BSTPair{
        int max;
        int min;
        boolean isBST;
    }
    public static BSTPair isBST(Node node){
        if(node == null){
            BSTPair n = new BSTPair();
            n.max = Integer.MIN_VALUE;
            n.min = Integer.MAX_VALUE;
            n.isBST = true;
            return n;
        }

        BSTPair lp = isBST(node.left);
        BSTPair rp = isBST(node.right);

        BSTPair myPair = new BSTPair();

        myPair.max = Math.max(node.data,Math.max(lp.max, rp.max));
        myPair.min = Math.min(node.data,Math.min(lp.min, rp.min));
        myPair.isBST = lp.isBST && rp.isBST && node.data>=lp.max && node.data<=rp.min;

        return myPair;
    }

    public static class PairforLargestBSTsubtree{
        int max;
        int min;
        boolean isBST;
        Node root;
        int size;
    }
    public static PairforLargestBSTsubtree LargestBSTsubtree(Node node){
        if(node == null){
            PairforLargestBSTsubtree n = new PairforLargestBSTsubtree();
            n.max = Integer.MIN_VALUE;
            n.min = Integer.MAX_VALUE;
            n.isBST = true;
            n.root = null;
            n.size = 0;

            return n;
        }

        PairforLargestBSTsubtree lp = LargestBSTsubtree(node.left);
        PairforLargestBSTsubtree rp = LargestBSTsubtree(node.right);

        PairforLargestBSTsubtree myPair = new PairforLargestBSTsubtree();
        myPair.max = Math.max(node.data,Math.max(lp.max,rp.max));
        myPair.min = Math.min(node.data,Math.min(lp.min,rp.min));
        myPair.isBST = lp.isBST && rp.isBST && node.data >= lp.max && node.data <= rp.min;

        if(myPair.isBST){
            myPair.root = node;
            myPair.size = lp.size+rp.size+1;
        }
        else if(lp.size>=rp.size){
            myPair.root = lp.root;
            myPair.size = lp.size;
        }
        else{
            myPair.root = rp.root;
            myPair.size = rp.size;
        }

        return myPair;
    }


    static boolean isBalanced = true;
    public static int isBalanced(Node node){ // returns height and change in boolean isBalanced;
      if(node==null){
          return 0;
      }
        int lh  = isBalanced(node.left);
        int rh = isBalanced(node.right);

        if(Math.abs(lh-rh)>1){
            isBalanced = false;
        }

        return lh+rh+1;
    }

    public static class BalancePair{
        int ht;
        boolean isBal;
    }
    public static BalancePair isBalancedbyPair(Node node){
        if(node == null){
            BalancePair n = new BalancePair();
            n.ht = 0;
            n.isBal = true;
            return n;
        }
        BalancePair lp = isBalancedbyPair(node.left);
        BalancePair rp = isBalancedbyPair(node.right);

        BalancePair myPair = new BalancePair();
        myPair.isBal = Math.abs(lp.ht-rp.ht) <= 1 && lp.isBal && rp.isBal;
        myPair.ht = Math.max(lp.ht,rp.ht)+1;

        return myPair;
    }





    public static void main (String[]args) throws IOException {
            Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};


        /*
                 50
               /    \
            25        75
           /  \       /  \
         12   37     62   87
              /        \
            30         70

        */

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        Integer[] arr = new Integer[n];
//        String[] values = br.readLine().split(" ");
//        for (int i = 0; i < n; i++) {
//            if (values[i].equals("n") == false) {
//                arr[i] = Integer.parseInt(values[i]);
//            } else {
//                arr[i] = null;
//            }
//        }
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

//        Traversal(root);
//        System.out.println(pre);
//        System.out.println(in);
//        System.out.println(post);

//            levelOrder(root);
//            IterativePreInPost(root);

//        System.out.println(find(root,70)); //True
//        for(Node node : nodeToRootPath){    //  [70, 62, 75, 50]
//          System.out.print(node.data + " " );
//        }
//        System.out.println();

//        printKLevelsDown(root,3);

//        printKNodesFar(root,37,2);

//        pathToLeafFromRoot(root , "" , 0 , 150,250);

//        Node clone = createLeftCloneTree(root);
////        display(clone);
//
//        Node normalize = transBackFromLeftClonedTree(clone);
//        display(normalize);
        
//        printSingleChildNodes(root, null);

//        Node removeLeaves = removeLeaves(root);
//        display(removeLeaves);


//        System.out.println(diameter1(root)); //N^2

//        DiamHt info = diameterOP(root); // N
//        System.out.println(info.diam);

//        tilt(root);
//        System.out.println(tilt);

//        BSTPair BSTpair = isBST(root);
//        System.out.println(BSTpair.isBST);

//        PairforLargestBSTsubtree LargestBSTsubtree =  LargestBSTsubtree(root);
//        System.out.println(LargestBSTsubtree.root.data + "@" + LargestBSTsubtree.size);

//        isBalanced(root);
//        System.out.println(isBalanced);

        BalancePair isBalancedbyPair = isBalancedbyPair(root);
        System.out.println(isBalancedbyPair.isBal);


        }
    }
