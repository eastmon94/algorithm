package baekjoon.solvedac.class3;

import java.io.*;
import java.util.*;

public class B7569_토마토 {
    static int M, N, H;
    static int[][][] map;
    static Queue<Pair> q;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[N][M][H];
        q = new LinkedList<>();

        int input;
        for(int h=0; h<H; h++) {
            for(int n=0; n<N; n++) {
                st = new StringTokenizer(in.readLine(), " ");
                for(int m=0; m<M; m++) {
                    input = Integer.parseInt(st.nextToken());
                    map[n][m][h] = input;
                    if(input==1) q.offer(new Pair(n, m, h, 0));
                }
            }
        }

        int answer = bfs();
        if(check()) System.out.println(answer);
        else System.out.println(-1);
    }

    static int[] dr = {-1, 1, 0, 0, 0, 0}, dc = {0, 0, -1, 1, 0, 0}, dh = {0, 0, 0, 0, -1, 1};
    static int bfs() {
        int count = 0;
        while(!q.isEmpty()) {
            Pair p = q.poll();
            count = p.count;

            for(int d=0; d<6; d++) {
                int nr = p.r+dr[d];
                int nc = p.c+dc[d];
                int nh = p.h+dh[d];

                if(!isIn(nr, nc, nh) || map[nr][nc][nh]!=0) continue;
                map[nr][nc][nh] = 1;
                q.offer(new Pair(nr, nc, nh, p.count+1));
            }
        }

        return count;
    }

    static boolean isIn(int r, int c, int h) {
        return 0<=r && r<N && 0<=c && c<M && 0<=h && h<H;
    }

    static boolean check() {
        for(int h=0; h<H; h++) {
            for(int n=0; n<N; n++) {
                for(int m=0; m<M; m++) {
                    if(map[n][m][h]==0) return false;
                }
            }
        }

        return true;
    }

    static class Pair {
        int r, c, h, count;
        public Pair(int r, int c, int h, int count) {
            this.r=r;
            this.c=c;
            this.h=h;
            this.count=count;
        }
    }
}
