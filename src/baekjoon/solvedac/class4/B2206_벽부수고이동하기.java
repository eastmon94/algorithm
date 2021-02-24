package baekjoon.solvedac.class4;

import java.io.*;
import java.util.*;

public class B2206_벽부수고이동하기 {
    static int N, M;
    static int[][] map;
    static int[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];
        for(int i=0; i<N; i++) {
            String input = in.readLine();
            for(int j=0; j<M; j++) {
                map[i][j]=input.charAt(j)-'0';
                visited[i][j]=Integer.MAX_VALUE;
            }
        }

        System.out.println(bfs());
    }

    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static int bfs() {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0, 1, 0));
        visited[0][0]=0;

        while(!q.isEmpty()) {
            Pair p = q.poll();

            if(p.r==N-1 && p.c==M-1) return p.num;
            
            for(int d=0; d<4; d++) {
                int nr = p.r+dr[d];
                int nc = p.c+dc[d];
                
                if(!isIn(nr, nc) || visited[nr][nc]<=p.drill) continue;

                if(map[nr][nc]==0) {
                    visited[nr][nc]=p.drill;
                    q.offer(new Pair(nr, nc, p.num+1, p.drill));
                } else {
                    if(p.drill==0) {
                        visited[nr][nc]=p.drill+1;
                        q.offer(new Pair(nr, nc, p.num+1, p.drill+1));
                    }
                }
            }
        }

        return -1;
    }

    static boolean isIn(int r, int c) {
        return 0<=r && r<N && 0<=c && c<M;
    }

    static class Pair {
        int r, c, num, drill;
        public Pair(int r, int c, int num, int drill) {
            this.r=r;
            this.c=c;
            this.num=num;
            this.drill=drill;
        }
    }
}
