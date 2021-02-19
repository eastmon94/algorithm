package baekjoon.solvedac.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1967_트리의지름 {
    static ArrayList<Edge>[] graph;
    static boolean[] visited;
    static int start, maxVal=Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(in.readLine());
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            int s, e, w;
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            graph[s].add(new Edge(e, w));
            graph[e].add(new Edge(s, w));
        }

        dfs(1, 0);
        Arrays.fill(visited, false);
        maxVal=Integer.MIN_VALUE;
        dfs(start, 0);

        System.out.println(maxVal);
    }

    static void dfs(int v, int total) {
        visited[v] = true;

        if(total > maxVal) {
            start=v;
            maxVal=total;
        }

        for(Edge e : graph[v]) {
            if(visited[e.v]) continue;
            dfs(e.v, total+e.w);
        }
    }

    static class Edge {
        int v,  w;
        public Edge(int v, int w) {
            this.v=v;
            this.w=w;
        }
    }
}
