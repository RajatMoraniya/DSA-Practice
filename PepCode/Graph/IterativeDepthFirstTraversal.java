package PepCode.Graph;

import java.io.*;
import java.util.*;

public class IterativeDepthFirstTraversal {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());
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
2
*/
        // write your code here
        boolean[] visited = new boolean[vtces];
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(src , src+""));

        while (!st.isEmpty()){
            Pair top = st.pop();
            if(visited[top.v]==true){
                continue;
            }
            visited[top.v] = true;
            System.out.println(top.v + "@" + top.psf);
            for( Edge e : graph[top.v]){
                if(visited[e.nbr]==false){
                    st.push(new Pair(e.nbr , top.psf + e.nbr));
                }
            }
        }
    }

}
