package baekjoon.solvedac.class3;

import java.io.*;
import java.util.*;

public class B2178_미로탐색 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        map = new int[N][M];

        String input;
        for(int n=0; n<N; n++) {
            input = in.readLine();
            for(int m=0; m<M; m++) {
                map[n][m] = input.charAt(m)-'0';
            }
        }

        bfs();
    }

    static int[] dr = {0, 0, -1, 1}, dc = {-1, 1, 0, 0};
    static void bfs() {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0, 1));
        visited[0][0] = true;

        while(!q.isEmpty()) {
            Pair p = q.poll();

            int nr, nc;
            for(int d=0; d<4; d++) {
                nr = p.r+dr[d];
                nc = p.c+dc[d];

                if(!isIn(nr, nc) || map[nr][nc]==0 || visited[nr][nc]) continue;
                
                if(nr==N-1 && nc==M-1) {
                    System.out.println(p.count+1);
                    return;
                }
                q.offer(new Pair(nr, nc, p.count+1));
                visited[nr][nc] = true;
            }
        }
    }

    static boolean isIn(int r, int c) {
        return 0<=r && r<N && 0<=c && c<M;
    }

    static class Pair {
        int r, c, count;
        public Pair(int r, int c, int count) {
            this.r=r;
            this.c=c;
            this.count=count;
        }
    }
}
