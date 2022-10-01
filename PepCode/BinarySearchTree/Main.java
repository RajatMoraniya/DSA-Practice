package PepCode.BinarySearchTree;

import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right=null;
        }
    }
    public static Node construct(int[] arr, int lo , int hi){
        if(lo>hi){
            return null;
        }
        int mid = (lo+hi)/2;
        Node root = new Node(arr[mid]);
        root.left = construct(arr,lo,mid-1);
        root.right = construct(arr,mid+1,hi);
        return root;
    }

    public static void display(Node root){
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

    public static int size(Node node) {
        if(node == null){
            return 0;
        }
        int ls = size(node.left);
        int rs = size(node.right);

        return ls+rs+1;
    }

    public static int sum(Node node) {
        if(node == null){
            return 0;
        }
        int ls = sum(node.left);
        int rs = sum(node.right);

        return ls+rs+node.data;
    }

    public static int max(Node node) {
        if(node.right!=null){
            return max(node.right);
        }
        else{
            return node.data;
        }
    }

    public static int min(Node node) {
        if(node.left!=null){
            return min(node.left);
        }
        else{
            return node.data;
        }
    }

    public static boolean find(Node node, int data){
        if(node== null){
            return false;
        }
        if(node.data < data){
            return find(node.right,data);
        }
        else if(data < node.data){
            return find(node.left,data);
        }
        else{
            return true;
        }
    }

    public static Node add(Node node, int data) {
        if(node == null){
            return new Node(data);
        }
        if(data<node.data){
            node.left = add(node.left,data);
        } else if (data>node.data) {
            node.right = add(node.right ,data);
        }
        return node;
    }

    //is BST 114..139

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

    //Another Aproach of isBST..
    public static boolean isBST2(Node node , Node min , Node max){
        if(node == null){
            return true;
        }
        if(min!= null && node.data <= min.data){
            return false;
        } else if (max!= null && node.data >= max.data) {
            return false;
        }

        return isBST2(node.left , min , node) && isBST2(node.right , node , max);
    }

    // Largest BST Subtree ..181
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


    public static Node findInorderSuccessor(Node node){
        while(node.left!= null){
            node =  node.left;
        }
        return node;
    }
    public static Node remove(Node node, int data) {
        if(node==null){
            return null;
        }

        if(data<node.data){
            node.left = remove(node.left,data);
        } else if (data>node.data) {
            node.right = remove(node.right ,data);
        }
        else {
            // two child
            if(node.left != null && node.right != null){
                int lmax = max(node.left); // this is find Inorder Predecessor approach on left
                node.data = lmax;
                node.left = remove(node.left,lmax);

                // apna clg me find Inorder Successor on right
                // Qki inorder succesor always on right ka leftest;
//                Node InorderSuccessor = findInorderSuccessor(node.right);
//                node.data = InorderSuccessor.data;
//                node.right = remove(node.right , InorderSuccessor.data);

                return node;

            }
            //single child
            else if(node.left != null){ // node.right == null;
                return node.left;
            }
            else if(node.right!= null){ // node.left == null;
                return node.right;
            }
            else { // r.left && r.right both are null
                return null;
            }
        }
        return node;
    }


    static int sum = 0;
    public static void ReplaceWithSumOfLarger(Node node){ // Replace With Sum Of Larger
        if(node==null){
            return;
        }
        ReplaceWithSumOfLarger(node.right);
        int ogData = node.data;
        node.data = sum;
        sum+= ogData;
        ReplaceWithSumOfLarger(node.left);
    }


    public static int lca(Node node, int d1, int d2) { // lowest common ancestor
        if(d1<node.data && d2< node.data){
            return lca(node.left,d1,d2);
        }
        else if(d1>node.data && d2>node.data){
            return lca(node.right,d1,d2);
        }
        else{
            return node.data;
        }
    }

    public static void printInRange(Node node, int d1, int d2) {
        if(node == null){
            return;
        }

        if(d1<node.data && d2<node.data){
            printInRange(node.left,d1,d2);
        } else if(d1>node.data && d2>node.data){
            printInRange(node.right,d1,d2);
        } else{ //d1> node < d2 || d2> node < d1
            printInRange(node.left,d1,d2);
            System.out.println(node.data);
            printInRange(node.right,d1,d2);
        }
    }

    public static void printPath(ArrayList<Integer> path){
        for(int val : path){
            System.out.print(val + "-> ");
        }
        System.out.println("null");
    }
    public static void rootToLeafPath(Node node, ArrayList<Integer> path){
        if(node==null){
            return;
        }
        path.add(node.data);
        if(node.left == null && node.right==null){
            printPath(path);
        }
        rootToLeafPath(node.left,path);
        rootToLeafPath(node.right,path);
        path.remove(path.size()-1);
    }

    //TargetSumPairInBst // TC = h & SC = nh
    public static void TargetSumPairInBst(Node root, Node node, int tar){
        if(node==null){
            return;
        }
        TargetSumPairInBst(root, node.left,tar);

        int comp = tar-node.data;
        if(node.data<comp){
            if(find(root,comp)){
                System.out.println(node.data + " " + comp);
            }
        }

        TargetSumPairInBst(root, node.right,tar);
    }

    //TargetSumPairInBst another approach // TC = n && SC = n
    public static void TargetSumPairInBstwithTWOpointer(Node node , int target){

        ArrayList<Integer> list = new ArrayList<>();
        getInorderList(node,list);

        int l = 0;
        int r = list.size()-1;

        while(l<r){
            int left = list.get(l);
            int right = list.get(r);

            if(left+right<target){
                l++;
            }
            else if(left+right > target){
                r--;
            }
            else{
                System.out.println(left + " "+ right);
                l++; r--;
            }
        }
    }

    //TargetSumPairInBst // Best Approach
    public static class ITpair{
        Node node;
        int state = 0;
        ITpair(Node node , int state){
            this.node = node;
            this.state = state;
        }
    }
    public static void TargetSumPairInBstBestApproach(Node node , int target){
        Stack<ITpair> ls = new Stack<ITpair>();
        Stack<ITpair> rs = new Stack<ITpair>();

        ls.push(new ITpair(node , 0));
        rs.push(new ITpair(node,0));

        Node left = getNextFromNormalInorder(ls);
        Node right = getNextFromReverseInorder(rs);

        while(left.data<right.data){
            if(left.data + right.data < target){
                left = getNextFromNormalInorder(ls);
            }
            else if(left.data + right.data > target){
                right = getNextFromReverseInorder(rs);
            }
            else{
                System.out.println(left.data + " " + right.data);
                left = getNextFromNormalInorder(ls);
                right = getNextFromReverseInorder(rs);
            }
        }

    }
    public static Node getNextFromNormalInorder(Stack<ITpair> st){
        while(!st.isEmpty()){
            ITpair top = st.peek();
            if(top.state==0){
                top.state++;
                if(top.node.left!= null){
                    st.push(new ITpair(top.node.left , 0));
                }
            }
            else if(top.state==1){
                top.state++;
                if(top.node.right!= null){
                    st.push(new ITpair(top.node.right, 0));
                }
                return top.node;
            }
            else {
                st.pop();
            }
        }
        return null;
    }
    public static Node getNextFromReverseInorder(Stack<ITpair> st){
        while(!st.isEmpty()){
            ITpair top = st.peek();
            if(top.state==0){
                top.state++;
                if(top.node.right!= null){
                    st.push(new ITpair(top.node.right , 0));
                }
            }
            else if(top.state==1){
                top.state++;
                if(top.node.left!= null){
                    st.push(new ITpair(top.node.left, 0));
                }
                return top.node;
            }
            else {
                st.pop();
            }
        }
        return null;
    }
    public static void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static Node mirrorOfBST(Node node){
        if(node == null){
            return null;
        }
        Node l = mirrorOfBST(node.left);
        Node r = mirrorOfBST(node.right);

        node.left = r;
        node.right = l;

        return node;
    }

    // Convert Normal BST to Balance BST ..360

    public static ArrayList getInorderList(Node node, ArrayList<Integer> list){
        if(node == null){
            return null;
        }
        getInorderList(node.left,list);
        list.add(node.data);
        getInorderList(node.right,list);
        return list;
    }
    public static Node createBSTfromList(ArrayList<Integer> list , int st , int end){
        if(st>end){
            return null;
        }
        int mid = (st+end)/2;
        Node root = new Node(list.get(mid));
        root.left = createBSTfromList(list , st , mid-1);
        root.right = createBSTfromList(list, mid+1 , end);

        return root;
    }
    public static Node balanceBST(Node node){
        ArrayList<Integer> InorderList = new ArrayList<>();
        getInorderList(node,InorderList);

        node = createBSTfromList(InorderList, 0 , InorderList.size()-1);
        return node;
    }


    // Merge Two BST
    public static Node mergeTwoBST(Node BST1, Node BST2){
        //BST 1 inorder list
        ArrayList<Integer> inorder4BST1 = new ArrayList<>();
        getInorderList(BST1,inorder4BST1);

        //BST 2 inorder list
        ArrayList<Integer> inorder4BST2 = new ArrayList<>();
        getInorderList(BST2 , inorder4BST2);

        //Merge two lists in sorted order
        ArrayList<Integer> finalist = new ArrayList<>();
        int i = 0 ; int j = 0; // for list 1 & list 2
        while(i<inorder4BST1.size() && j<inorder4BST2.size()){
            if(inorder4BST1.get(i)<inorder4BST2.get(j)){
                finalist.add(inorder4BST1.get(i++));
            }
            else{
                finalist.add(inorder4BST2.get(j++));
            }
        }
        while(i<inorder4BST1.size()){
            finalist.add(inorder4BST1.get(i++));
        }
        while (j<inorder4BST2.size()){
            finalist.add(inorder4BST2.get(j++));
        }

        //Call Create Function
        Node root = createBSTfromList(finalist , 0 , finalist.size()-1);
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {12,25,37,50,62,75,80};
    /*
                 50
               /    \
            25        75
           /  \       /  \
         12   37     62   80

    */

        Node root = construct(arr,0,arr.length-1);
//        display(root);

//        int size = size(root);
//        int sum = sum(root);
//        int max = max(root);
//        int min = min(root);
//        boolean found = find(root, 12);
//
//        System.out.println(size);
//        System.out.println(sum);
//        System.out.println(max);
//        System.out.println(min);
//        System.out.println(found);

//                BSTPair BSTpair = isBST(root);
//        System.out.println(BSTpair.isBST);

//        System.out.println(isBST2(root,null,null));

//        PairforLargestBSTsubtree LargestBSTsubtree =  LargestBSTsubtree(root);
//        System.out.println(LargestBSTsubtree.root.data + "@" + LargestBSTsubtree.size);

//        rootToLeafPath(root , new ArrayList<>());

//        preOrder(root);
//        Node mirror = mirrorOfBST(root);
//        System.out.println();
//        preOrder(mirror);
//
        //convert bst to Balance BST;
        /*
                  8
                 /  \
                6    10
               /       \
             5          11
            /             \
           3               12

           conver this into

               8
              / \
             5   11
            / \  / \
           3 6  10 12

         */
//        Node unsorted = new Node(8);
//        {
//            unsorted.left = new Node(6);
//            unsorted.left.left = new Node(5);
//            unsorted.left.left.left = new Node(3);
//
//            unsorted.right = new Node(10);
//            unsorted.right.right = new Node(11);
//            unsorted.right.right.right = new Node(12);
//        }
//        preOrder(unsorted);
//        System.out.println();
//        Node sorted = balanceBST(unsorted);
//        preOrder(sorted);+

//
//        // Merge Two BST
//              /*
//               2
//              / \
//             1   4
//             BST 1
//        */
//        Node BST1 = new Node(2);
//        BST1.left = new Node(1);
//        BST1.right = new Node(4);
//        System.out.println("BST1 ");
//        preOrder(BST1);
//        System.out.println();
//           /*
//               9
//              / \
//             3   12
//             BST 2
//        */
//
//        Node BST2 = new Node(9);
//        BST2.left = new Node(3);
//        BST2.right = new Node(12);
//        System.out.println("BST2 ");
//        preOrder(BST2);
//        System.out.println();
//        /*
//        * Final BST
//              3
//            /  \
//           1    9
//            \   / \
//            2  4  12
//
//       */
//        System.out.println("Final ");
//        Node finall = mergeTwoBST(BST1,BST2);
//        preOrder(finall);
//        System.out.println();


//        TargetSumPairInBst(root,root,100);

        TargetSumPairInBstwithTWOpointer(root , 100);

        TargetSumPairInBstBestApproach(root ,100);
    }
}
