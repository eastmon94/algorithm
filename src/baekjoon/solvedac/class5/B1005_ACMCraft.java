package baekjoon.solvedac.class5;

import java.io.*;
import java.util.*;

public class B1005_ACMCraft {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-->0) {
            st = new StringTokenizer(in.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] times = new int[N+1];
            ArrayList<Integer>[] graph = new ArrayList[N+1];

            st = new StringTokenizer(in.readLine(), " ");

            for(int i=1; i<=N; i++) {
                times[i] = Integer.parseInt(st.nextToken());
                graph[i] = new ArrayList<>();
            }

            int[] counts = new int[N+1];
            for(int i=0; i<K; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                graph[s].add(e);
                counts[e]++;
            }

            int goal = Integer.parseInt(in.readLine());

            Queue<Integer> q = new LinkedList<>();
            int[] check = new int[N+1];
            for(int i=1; i<=N; i++) {
                if(counts[i]==0) {
                    q.offer(i);
                    check[i] = times[i];
                }
            }

            sb.append(bfs(check, times, graph, q, goal, N)).append("\n");
        }
        System.out.print(sb.toString());
    }

    static int bfs(int[] check, int[] times, ArrayList<Integer>[] graph, Queue<Integer> q, int goal, int N) {

        while(!q.isEmpty()) {
            int cur = q.poll();

            int size = graph[cur].size();
            for(int i=0; i<size; i++) {
                int next = graph[cur].get(i);
                if(check[cur]+times[next] > check[next]) {
                    check[next] = check[cur] + times[next];
                    q.offer(next);
                }
            }
        }

        return check[goal];
    }
}
