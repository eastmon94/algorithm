package baekjoon.solvedac.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1753_최단경로 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(in.readLine());

        ArrayList<Edge>[] graph = new ArrayList[V+1];
        for(int i=1; i<=V; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[s].add(new Edge(e, w));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] check = new boolean[V+1];
        Edge[] D = new Edge[V+1];
        for(int i=1; i<=V; i++) {
            if(i==start) D[i] = new Edge(i, 0);
            else D[i] = new Edge(i, Integer.MAX_VALUE);

            pq.offer(D[i]);
        }

        while(!pq.isEmpty()) {
            Edge e = pq.poll();

            if(e.weight==Integer.MAX_VALUE) continue;

            check[e.v] = true;
            for(Edge next : graph[e.v]) {
                if(!check[next.v] && next.weight+D[e.v].weight < D[next.v].weight) {
                    D[next.v].weight = next.weight+D[e.v].weight;

                    pq.remove(D[next.v]);
                    pq.add(D[next.v]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=V; i++) {
            if(D[i].weight==Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(D[i].weight+"\n");
        }

        System.out.println(sb.toString());
    }


    static class Edge implements Comparable<Edge> {
        int v, weight;
        public Edge(int v, int weight) {
            this.v=v;
            this.weight=weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(weight, o.weight);
        }
    }
}
