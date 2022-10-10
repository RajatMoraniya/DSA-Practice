package PepCode.RecursionAndBacktracking;

import java.util.Scanner;

public class Tower_Of_Hanoi {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t1d = sc.nextInt();
        int t2d = sc.nextInt();
        int t3d = sc.nextInt();
        toh(n,t1d,t2d,t3d);
    }
    /*
    3
    10 11 12
     */

    public static void toh(int n, int t1id, int t2id , int t3id){
        // [1 2 3]  []  []
        if(n==0){
            return;
        }

        // [3]  []  [1 2]
        toh(n-1 , t1id , t3id , t2id);

        // []  [3]  [1 2]
        System.out.println(n + "[" + t1id + " -> " + t2id + "]");

        // []  [1 2 3]  []
        toh(n-1 , t3id , t2id , t1id);
    }

    public static void towerOFHonoi(int n , int src , int dest , int helper){
        if(n==0){
            return;
        }
        towerOFHonoi(n-1,src,helper,dest);
        System.out.println(n + "[" + src + "->" + dest + "]");
        towerOFHonoi(n-1 , helper , dest ,src);
    }

}
