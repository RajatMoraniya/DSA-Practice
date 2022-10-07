package PepCode.Graph;
import java.io.*;
import java.util.*;

public class isGraphConnected {
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

    public static void drawTreeAndGenerateComps(ArrayList<Edge>[] graph , int src, boolean[] visited, ArrayList<Integer> comp){
        comp.add(src);
        visited[src] = true;
        for(Edge e : graph[src]){
            if(visited[e.nbr]==false){
                drawTreeAndGenerateComps(graph,e.nbr,visited,comp);
            }
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

        // write your code here
        /*
7
5
0 1 10
2 3 10
4 5 10
5 6 10
4 6 10
 */

        boolean[] visited = new boolean[vtces];
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        for (int v = 0; v < vtces; v++) {
            if (visited[v] == false) {
                ArrayList<Integer> comp = new ArrayList<>();
                drawTreeAndGenerateComps(graph, v, visited, comp);
                comps.add(comp);
            }
        }
        System.out.println(comps.size()==1);
    }
}

