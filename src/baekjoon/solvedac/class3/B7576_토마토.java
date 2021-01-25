package baekjoon.solvedac.class3;

import java.io.*;
import java.util.*;

public class B7576_토마토 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Pair> q;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        map = new int[N][M];
        q = new LinkedList<>();
        int i;
        for(int n=0; n<N; n++) {
            st = new StringTokenizer(in.readLine(), " ");
            for(int m=0; m<M; m++) {
                i = Integer.parseInt(st.nextToken());
                map[n][m] = i;
                if(i==1) {
                    q.offer(new Pair(n, m, 0));
                    visited[n][m] = true;
                }
            }
        }
        
        int answer = bfs();
        if(check()) System.out.println(answer);
        else System.out.println(-1);            
    }

    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static int bfs() {
        int num = 0;
        while(!q.isEmpty()) {
            Pair p = q.poll();
            num = p.count;

            int nr, nc;
            for(int d=0; d<4; d++) {
                nr = p.r+dr[d];
                nc = p.c+dc[d];

                if(!isIn(nr, nc) || map[nr][nc]!=0) continue;
                q.offer(new Pair(nr, nc, p.count+1));
                map[nr][nc] = 1;
            }
        }

        return num;
    }

    static boolean check() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j]==0) return false;
            }
        }

        return true;
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
