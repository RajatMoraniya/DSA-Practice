package PepCode.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NumberOfIslands {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];

        for (int i = 0; i < arr.length; i++) {
            String parts = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }
    /*
8
8
0 0 1 1 1 1 1 1
0 0 1 1 1 1 1 1
1 1 1 1 1 1 1 0
1 1 0 0 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 1 1 1 0
1 1 1 1 1 1 1 0
    */

        boolean[][] vistied = new boolean[arr.length][arr[0].length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length ; j++) {
                if(arr[i][j]==0 && vistied[i][j]==false){
                    drawTreeforComp(arr,i,j,vistied);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    public static void drawTreeforComp(int[][] arr , int i , int j , boolean[][] visited){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]==1 || visited[i][j]==true ){
            return;
        }
        visited[i][j] = true;
        drawTreeforComp(arr,i-1,j,visited); //UP
        drawTreeforComp(arr,i,j+1,visited); //Right
        drawTreeforComp(arr,i,j-1,visited); //Left
        drawTreeforComp(arr,i+1,j,visited); //Down
    }
}
