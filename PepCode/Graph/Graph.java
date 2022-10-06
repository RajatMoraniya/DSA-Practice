package PepCode.Graph;

import java.util.*;
import java.io.*;

public class Graph {
    public static class Edge {
        int src; //source
        int nbr; //neighbour
        int wt; //weight
        Edge(int src , int nbr , int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
        public static boolean hasPath(ArrayList<Edge>[] graph , int src , int dest , boolean[] visited){
            if(src==dest){
                return true;
            }

            visited[src] = true;
            for(Edge edge : graph[src]){
                if(visited[edge.nbr]==false){
                    boolean hasNbrPath = hasPath(graph , edge.nbr , dest ,visited);
                    if(hasNbrPath == true){
                        return true;
                    }
                }
            }
            return false;
        }


        public static void main(String[] args) throws IOException {

            /*
7
8
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
0
6
            */
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int vtces = Integer.parseInt(br.readLine());
            ArrayList<Edge>[] graph = new ArrayList[vtces];
            for(int i = 0; i < vtces; i++){
                graph[i] = new ArrayList<Edge>();
            }

            int edges = Integer.parseInt(br.readLine());
            for(int i = 0; i < edges; i++){
                String[] parts = br.readLine().split(" ");
                int v1 = Integer.parseInt(parts[0]);
                int v2 = Integer.parseInt(parts[1]);
                int wt = Integer.parseInt(parts[2]);
                graph[v1].add(new Edge(v1, v2, wt));
                graph[v2].add(new Edge(v2, v1, wt));
            }

            int src = Integer.parseInt(br.readLine());
            int dest = Integer.parseInt(br.readLine());

            boolean[] visited = new boolean[vtces];
            // Has Path
            boolean path = hasPath(graph,src,dest,visited);
            System.out.println(path);
        }
    }
}
