package baekjoon.solvedac.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1238_파티_dijkstra {
    static int N, M, X;
    static ArrayList<Edge>[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st=new StringTokenizer(in.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            graph[s].add(new Edge(e, n));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        int answer = Integer.MIN_VALUE;
        dijkstra(X, 1, pq);
        for(int i=1; i<=N; i++) {
            answer = Math.max(answer, dijkstra(i, X, pq)+dijkstra(X, i, pq));
        }

        System.out.println(answer);
    
    }

    static int dijkstra(int v, int o, PriorityQueue<Edge> pq) {
        pq.clear();
        
        boolean[] check = new boolean[N+1];
        Edge[] D = new Edge[N+1];
        for(int i=1; i<=N; i++) {
            if(i==v) D[i] = new Edge(i, 0);
            else     D[i] = new Edge(i, Integer.MAX_VALUE);

            pq.offer(D[i]);
        }


        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            
            check[e.v]=true;
            
            for(Edge next : graph[e.v]) {
                if(!check[next.v] && D[e.v].weight+next.weight < D[next.v].weight) {
                    D[next.v].weight = D[e.v].weight+next.weight;
                    
                    pq.remove(D[next.v]);
                    pq.add(D[next.v]);
                }
            }

        }

        return D[o].weight;
    }
    
    static class Edge implements Comparable<Edge> {
        int v, weight;
        public Edge(int v, int weight) {
            this.v=v;
            this.weight=weight;
        }

        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
