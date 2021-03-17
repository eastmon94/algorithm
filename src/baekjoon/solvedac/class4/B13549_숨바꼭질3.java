package baekjoon.solvedac.class4;

import java.io.*;
import java.util.*;

public class B13549_숨바꼭질3 {
    static int N, K;
    static int answer=Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(answer);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[100001];
        Arrays.fill(visited, Integer.MAX_VALUE);

        q.offer(N);
        visited[N] = 0;

        while(!q.isEmpty()) {
            int n = q.poll();

            if(n==K) {
                answer = Math.min(answer, visited[n]);
                continue;
            }

            if(n < 100000 && visited[n+1]>visited[n]+1) {
                q.offer(n+1);
                visited[n+1]=visited[n]+1;
            }

            if(n > 0 && visited[n-1]>visited[n]+1) {
                q.offer(n-1);
                visited[n-1]=visited[n]+1;
            }

            if(n*2 < 100001 && visited[n*2]>visited[n]) {
                q.offer(n*2);
                visited[n*2]=visited[n];
            }
        }

    }
}
