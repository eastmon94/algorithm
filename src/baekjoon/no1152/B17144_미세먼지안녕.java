package baekjoon.no1152;

import java.io.*;
import java.util.*;

public class B17144_미세먼지안녕 {
    static int R, C, T;
    static int[][] map;
    static Queue<Pair> q;
    static int[][] cleaners;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        cleaners = new int[2][2];
        int i, n=0;
        for(int r=0; r<R; r++) {
            st = new StringTokenizer(in.readLine(), " ");
            for(int c=0; c<C; c++) {
                i=Integer.parseInt(st.nextToken());
                map[r][c] = i;
                if(i==-1) cleaners[n++] = new int[]{r, c};
            }
        }

        q = new LinkedList<>();

        for(int t=0; t<T; t++) {
            simulate();
        }

        int answer = 0;
        for(int r=0; r<R; r++) {
            for(int c=0; c<C; c++) {
                if(map[r][c]==-1) continue;
                answer += map[r][c];
            }
        }
        System.out.println(answer);
    }

    static void simulate() {
        for(int r=0; r<R; r++) {
            for(int c=0; c<C; c++) {
                if(map[r][c]==0 || map[r][c]==-1) continue;
                q.offer(new Pair(r, c, map[r][c]));
            }
        }

        spread();
        airClean(0);
        airClean(1);
    }

    static void airClean(int f) {
        int[] cleaner = cleaners[f];
        int r = cleaner[0];
        int c = cleaner[1];

        int d=f;
        int cr=r+dr[d], cc=c+dc[d];
        int nr, nc;
        
        while(true) {
            nr = cr+dr[d];
            nc = cc+dc[d];
            if(!isIn(nr, nc) || check(nr, r, f)) {
                d=changeDir(d, f);
                continue;
            }
            
            if(map[nr][nc]==-1) {
                map[cr][cc] = 0;
                break;
            }

            map[cr][cc] = map[nr][nc];
            cr = nr;
            cc = nc;
        }
        
    }

    static int changeDir(int d, int f) {
        if(f==0) {
            if(d==0) return 3;
            else if(d==3) return 1;
            else return 2;
        }else {
            if(d==1) return 3;
            else if(d==3) return 0;
            else return 2;
        }
        
    }
    static boolean check(int nr, int r, int f) {
        if(f==0) return nr > r;
        else return nr < r;
    }

    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1}; //상하좌우 0123
    static void spread() {
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int count=0;
            int r=p.r;
            int c=p.c;
            for(int d=0; d<4; d++) {
                int nr = r+dr[d];
                int nc = c+dc[d];
                if(!isIn(nr, nc) || map[nr][nc]==-1) continue;
                map[nr][nc] += p.num/5;
                count++;
            }
    
            if(count==0) continue;
            map[r][c] -= (p.num/5)*count;
        }
    }

    static boolean isIn(int r, int c) {
        return 0<=r && r<R && 0<=c && c<C;
    }

    static class Pair {
        int r, c, num;
        public Pair(int r, int c, int num) {
            this.r = r;
            this.c = c;
            this.num = num;
        }
    }
}
