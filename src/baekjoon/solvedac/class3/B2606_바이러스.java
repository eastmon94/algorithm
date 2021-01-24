package baekjoon.solvedac.class3;

import java.io.*;
import java.util.*;

public class B2606_바이러스 {
    static int N;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(in.readLine());
        int M = Integer.parseInt(in.readLine());

        visited = new boolean[N+1];
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        int n1, n2;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());

            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        bfs();
        int answer = 0;
        for(int i=2; i<=N; i++) {
            if(visited[i]) answer++;
        }
        System.out.println(answer);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;

        while(!q.isEmpty()) {
            int v = q.poll();
            int size = graph[v].size();
            for(int i=0; i<size; i++) {
                int nv = graph[v].get(i);
                if(visited[nv]) continue;
                q.offer(nv);
                visited[nv] = true;
            }
        }
    }
}
