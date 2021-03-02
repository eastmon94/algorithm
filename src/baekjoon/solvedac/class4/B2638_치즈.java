package baekjoon.solvedac.class4;

import java.io.*;
import java.util.*;

public class B2638_치즈 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Pair> q;
    static ArrayList<Pair> ls;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for(int j=0; j<M; j++) {
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        ls = new ArrayList<>();
        q = new LinkedList<>();
        
        int answer = 0;
        while(true) {
            init();
            bfs();
            if(!delete()) break;
            answer++;
        }

        System.out.println(answer);

    }

    static void init() {
        q.clear();
        ls.clear();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                visited[i][j] = false;
                if(i==0 || i==N || j==0 || j==M) {
                    q.offer(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }
    }

    static int[] dr={0, 0, -1, 1}, dc={-1, 1, 0, 0};
    static void bfs() {
        while(!q.isEmpty()) {
            Pair p = q.poll();
    
            for(int d=0; d<4; d++) {
                int nr = p.r+dr[d];
                int nc = p.c+dc[d];
    
                if(!isIn(nr, nc) || visited[nr][nc]) continue;
                if(map[nr][nc]==0) {
                    q.offer(new Pair(nr, nc));
                    visited[nr][nc] = true;
                } else {
                    map[nr][nc]++;
                }
            }
        }
    }

    
    static boolean delete() {
        int count=0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j]==0) count++;

                if(map[i][j] >= 3) map[i][j] = 0;
                else if(map[i][j]>1) map[i][j] = 1;
            }
        }

        if(count==N*M) return false;
        return true;
    }

    static boolean isIn(int r, int c) {
        return 0<=r && r<N && 0<=c && c<M;
    }

    

    static class Pair {
        int r, c;

        public Pair(int r, int c) {
            this.r=r;
            this.c=c;
        }
    }
}
