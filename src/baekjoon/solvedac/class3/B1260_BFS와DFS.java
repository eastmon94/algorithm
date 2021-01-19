package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260_BFS와DFS {
    static int N, M, V;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int n=1; n<=N; n++) {
            graph[n] = new ArrayList<>();
        }

        int n1, n2;
        for(int m=0; m<M; m++) {
            st = new StringTokenizer(in.readLine(), " ");
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());

            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        for(int n=1; n<=N; n++) {
            graph[n].sort(new Comparator<Integer>(){
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
        }

        sb = new StringBuilder();
        dfs(V);
        init();
        bfs();

        System.out.println(sb.toString());
    }

    static void dfs(int idx) {
        visited[idx] = true;
        sb.append(idx+" ");

        int size = graph[idx].size();
        for(int s=0; s<size; s++) {

            int nv = graph[idx].get(s);
            if(visited[nv]) continue;
            dfs(nv);
        }
    }
    
    static void init() {
        for(int n=0; n<=N; n++) {
            visited[n] = false;
        }
        sb.append("\n");
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(V);
        visited[V] = true;
        sb.append(V+" ");

        while(!q.isEmpty()) {
            int cv = q.poll();

            int size = graph[cv].size();
            for(int s=0; s<size; s++) {
                int nv = graph[cv].get(s);
                if(visited[nv]) continue;

                q.offer(nv);
                visited[nv] = true;
                sb.append(nv+" ");
            }
        }
    }
}
