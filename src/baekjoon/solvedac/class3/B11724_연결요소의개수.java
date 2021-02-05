package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B11724_연결요소의개수 {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        int i, j;
        for(int m=0; m<M; m++) {
            st = new StringTokenizer(in.readLine(), " ");
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());

            graph[i].add(j);
            graph[j].add(i);
        }

        int count=0;
        for(int v=1; v<=N; v++) {
            if(visited[v]) continue;
            count++;
            dfs(v);
        }

        System.out.println(count);
    }

    static void dfs(int v) {
        visited[v] = true;

        int size = graph[v].size();
        for(int n=0; n<size; n++) {
            int nv = graph[v].get(n);
            if(visited[nv]) continue;
            dfs(nv);
        }
    }
}
