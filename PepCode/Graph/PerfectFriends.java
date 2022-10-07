package PepCode.Graph;

import java.io.*;
import java.util.*;

public class PerfectFriends {
    static class Edge {
        int v;
        int n;

        Edge(int v, int n) {
            this.v = v;
            this.n = n;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int v = 0; v < n; v++) {
            graph[v] = new ArrayList<>();
        }

        for (int e = 0; e < k; e++) {
            String line = br.readLine();
            String[] parts = line.split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }
    /*
7
5
0 1
2 3
4 5
5 6
4 6
   */
        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        for (int v = 0; v < n; v++) {
            if (visited[v] == false) {
                ArrayList<Integer> comp = new ArrayList<>();
                drawTreeforComps(graph, v, visited, comp);
                comps.add(comp);
            }
        }

        int pairs = 0;
        for (int i = 0; i < comps.size() ; i++) {
            for (int j = i+1; j < comps.size() ; j++) {
                int count = comps.get(i).size() * comps.get(j).size();
                pairs+= count;
            }
        }
        System.out.println(pairs);
    }
    public static void drawTreeforComps(ArrayList<Edge>[] graph, int src , boolean[] visited , ArrayList<Integer> comp){
        comp.add(src);
        visited[src]= true;
        for(Edge e : graph[src]){
            if(visited[e.n]==false){
                drawTreeforComps(graph , e.n , visited , comp);
            }
        }
    }
}
