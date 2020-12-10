package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11724_연결요소의개수 {
    static int N, M, s;
    static LinkedList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new LinkedList[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++) graph[i] = new LinkedList<>();

        int u, v;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(in.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        boolean flag = false;
        int count = 0;
        while(true) {
            L:for(int i=1; i<=N; i++) {
                if(!visited[i]) {
                    s = i;
                    flag = true;
                    break L;
                }
            }
            if(flag) {
                count++;
                bfs();
                flag = false;
            }
            else break;
        }

        System.out.println(count);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        visited[s] = true;

        while(!q.isEmpty()) {
            int node = q.poll();

            for(int i=0; i<graph[node].size(); i++) {
                int adjNode = graph[node].get(i);
                
                if(!visited[adjNode]) {
                    q.offer(adjNode);
                    visited[adjNode] = true;
                }
            }
        }
    }
}
