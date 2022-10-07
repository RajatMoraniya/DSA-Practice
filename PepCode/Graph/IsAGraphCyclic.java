package PepCode.Graph;

import java.io.*;
import java.util.*;

public class IsAGraphCyclic {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    static class Pair{
        int v;
        String psf;
        Pair(int v , String psf){
            this.v = v;
            this.psf = psf;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }
        /*
7
6
0 1 10
1 2 10
2 3 10
3 4 10
4 5 10
5 6 10
*/

        // write your code here
        boolean[] visited = new boolean[vtces];
        for (int v = 0; v < vtces ; v++) {
            if(visited[v]==false){
                boolean isCycle = isCyclic(graph , v, visited );
                if(isCycle==true){
                    System.out.println(true);
                    return;
                }
            }
        }
        System.out.println(false);
    }

    public static boolean isCyclic(ArrayList<Edge>[] graph , int src , boolean[] visited){
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src , src+""));
        visited[src] = true;

        while (!q.isEmpty()){
            Pair top = q.removeFirst();
            if(visited[top.v]==true){
                return true;
            }
            visited[top.v]= true;

            for(Edge e : graph[top.v]){
                if(visited[e.nbr]==false){
                    q.add(new Pair(e.nbr , top.psf+e.nbr));
                }
            }
        }
    return false;
    }
}