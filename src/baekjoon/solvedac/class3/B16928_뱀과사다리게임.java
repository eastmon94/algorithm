package baekjoon.solvedac.class3;

import java.io.*;
import java.util.*;

public class B16928_뱀과사다리게임 {
    static int[] visited;
    static int[] ladder;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new int[101];
        ladder = new int[101];
        Arrays.fill(visited, Integer.MAX_VALUE);

        for(int i=0; i<N+M; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            ladder[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        bfs();
        System.out.println(visited[100]);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();

            if(cur==100) return;

            for(int i=1; i<=6; i++) {
                int next = cur+i;
                if(next > 100 || visited[next] <= visited[cur]+1) continue;

                if(ladder[next]==0) {
                    q.offer(next);
                    visited[next] = visited[cur]+1;
                } else {
                    if(visited[ladder[next]] <= visited[cur]+1) continue;
                    q.offer(ladder[next]);
                    visited[ladder[next]] = visited[cur]+1;
                }
            }
        }
    }
}
