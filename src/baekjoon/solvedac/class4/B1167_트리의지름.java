package baekjoon.solvedac.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1167_트리의지름 {
    static ArrayList<Edge>[] graph;
    static boolean[] visited;
    static int start;
    static int maxVal = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int V = Integer.parseInt(in.readLine());
        graph = new ArrayList[V+1];
        visited = new boolean[V+1];

        for(int i=1; i<=V; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=1; i<=V; i++) {
            st=new StringTokenizer(in.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());

            int e;
            while((e=Integer.parseInt(st.nextToken())) != -1) {
                int c = Integer.parseInt(st.nextToken());

                graph[s].add(new Edge(e, c));
            }
        }

        dfs(2, 0);
        Arrays.fill(visited, false);
        maxVal = Integer.MIN_VALUE;
        dfs(start, 0);

        System.out.println(maxVal);
    }

    static void dfs(int v, int total) {
        visited[v] = true;
        
        if(total > maxVal) {
            maxVal = total;
            start = v;
        }

        for(Edge e : graph[v]) {
            if(visited[e.v]) continue;
            dfs(e.v, total+e.cost);
        }
    }


    static class Edge {
        int v, cost;
        Edge(int v, int cost) {
            this.v=v;
            this.cost=cost;
        }
    }
}
