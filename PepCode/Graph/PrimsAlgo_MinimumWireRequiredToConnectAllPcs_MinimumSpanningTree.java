package PepCode.Graph;

import java.io.*;
import java.util.*;

public class PrimsAlgo_MinimumWireRequiredToConnectAllPcs_MinimumSpanningTree {
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

    static class Pair implements Comparable<Pair>{
        int v; //vertex
        int av; //acquiring_vertex
        int wt; //weight
        Pair(int v , int av , int wt){
            this.v = v;
            this.av = av;
            this.wt = wt;
        }


        public int compareTo(Pair o){
            return this.wt-o.wt;
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
8
0 1 10
1 2 10
2 3 10
0 3 40
3 4 2
4 5 3
5 6 3
4 6 8
 */
        // write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,-1,0));
        boolean[] visited = new boolean[vtces];

        while (!pq.isEmpty()){
            Pair top = pq.remove();
            if(visited[top.v]==true){
                continue;
            }
            visited[top.v] = true;
            if(top.av!=-1){
                //[1-0@10]
                System.out.println("["+top.v + "-" + top.av + "@" + top.wt + "]" );
            }

            for( Edge e : graph[top.v]){
                if(visited[e.nbr]==false){
                    pq.add(new Pair(e.nbr, e.src , e.wt));
                }
            }
        }
    }

}
