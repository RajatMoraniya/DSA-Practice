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

        public static void printAllPath(ArrayList<Edge>[] graph , int src , int dest , boolean[] visited , String psf){
            if(src == dest){
                System.out.println(psf);
                return;
            }
            visited[src] = true;
            for(Edge edge : graph[src]){
                if(visited[edge.nbr] == false){
                    printAllPath(graph,edge.nbr , dest , visited , psf + edge.nbr);
                }
            }
            visited[src] = false;
        }

        //MultiSolver ..
        static String spath;
        static Integer spathwt = Integer.MAX_VALUE;
        static String lpath;
        static Integer lpathwt = Integer.MIN_VALUE;
        static String cpath;
        static Integer cpathwt = Integer.MAX_VALUE;
        static String fpath;
        static Integer fpathwt = Integer.MIN_VALUE;

        static class Pair implements Comparable<Pair>{
            int wsf;
            String psf;
            Pair(int wsf , String psf){
                this.wsf = wsf;
                this.psf = psf;
            }

            public int compareTo(Pair o){
                return this.wsf - o.wsf;
            }
        }
        static PriorityQueue<Pair> pq = new PriorityQueue<>();
        public static void multisolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k, String psf, int wsf) {
            if(src == dest){
                if(wsf<spathwt){
                    spath = psf;
                    spathwt = wsf;
                }
                if(wsf>lpathwt){
                    lpath = psf;
                    lpathwt = wsf;
                }

                if(wsf>criteria && wsf<cpathwt){
                    cpath = psf;
                    cpathwt = wsf;
                }

                if(wsf<criteria && wsf>fpathwt){
                    fpath = psf;
                    fpathwt = wsf;
                }

                if(pq.size()<k){
                    pq.add(new Pair(wsf,psf));
                }else{
                    if(wsf>pq.peek().wsf){
                        pq.remove();
                        pq.add(new Pair(wsf,psf));
                    }
                }
                return;
            }
            visited[src] = true;
            for(Edge e : graph[src]){
                if(visited[e.nbr]==false){
                    multisolver(graph,e.nbr,dest,visited,criteria , k , psf+e.nbr , wsf+e.wt);
                }
            }
            visited[src] = false;
        }

        //Print Compositions ;
        public static void drawTreeAndGenerateComps(ArrayList<Edge>[] graph , int src, boolean[] visited, ArrayList<Integer> comp){
                comp.add(src);
                visited[src] = true;
                for(Edge e : graph[src]){
                    if(visited[e.nbr]==false){
                        drawTreeAndGenerateComps(graph,e.nbr,visited,comp);
                    }
                }
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

//            int src = Integer.parseInt(br.readLine());
//            int dest = Integer.parseInt(br.readLine());

            boolean[] visited = new boolean[vtces];
//            // Has Path
//            boolean path = hasPath(graph,src,dest,visited);
//            System.out.println(path);

            // Print All Paths
//             printAllPath(graph,src,dest,visited,src+"");

            //MultiSolver..
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
30
4
            */
/*
            int criteria = Integer.parseInt(br.readLine());
            int k = Integer.parseInt(br.readLine());

            multisolver(graph, src, dest, visited, criteria, k, src + "", 0);

            System.out.println("Smallest Path = " + spath + "@" + spathwt);
            System.out.println("Largest Path = " + lpath + "@" + lpathwt);
            System.out.println("Just Larger Path than " + criteria + " = " + cpath + "@" + cpathwt);
            System.out.println("Just Smaller Path than " + criteria + " = " + fpath + "@" + fpathwt);
            System.out.println(k + "th largest path = " + pq.peek().psf + "@" + pq.peek().wsf);

            */

            // Print Comps
            /*
7
5
0 1 10
2 3 10
4 5 10
5 6 10
4 6 10
*/
//            ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
//            for(int v = 0 ; v < vtces ; v++){
//                if(visited[v]==false){
//                    ArrayList<Integer> comp = new ArrayList<>();
//                    drawTreeAndGenerateComps(graph , v, visited , comp);
//                    comps.add(comp);
//                }
//            }
//            System.out.println(comps);
        }

    }
