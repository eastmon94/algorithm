package baekjoon.solvedac.class4;

import java.io.*;
import java.util.*;

public class B12851_숨바꼭질2 {
    static int N, K;
    static int time, count;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(time);
        System.out.println(count);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[100001];
        Arrays.fill(visited, Integer.MAX_VALUE);
        q.offer(N);
        visited[N] = 0;

        while(!q.isEmpty()) {
            int p = q.poll();
 
            if(p == K) {
                count++;
                time = visited[p];
                continue;
            }

            if(p < 100000 && visited[p+1] >= visited[p]+1) {
                q.offer(p+1);
                visited[p+1] = visited[p]+1;
            }

            if(p > 0 && visited[p-1] >= visited[p]+1) {
                q.offer(p-1);
                visited[p-1] = visited[p]+1;
            }

            if(p*2 < 100001 && visited[p*2] >= visited[p]+1) {
                q.offer(p*2);
                visited[p*2] = visited[p]+1;
            }
        }
    }
}
