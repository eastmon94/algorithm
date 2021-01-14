package baekjoon.solvedac.class3;

import java.io.*;
import java.util.*;

public class B1012_유기농배추 {
    static int N, M, K;
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> q;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(in.readLine());
        q = new LinkedList<>();
        while(T-->0) {
            st = new StringTokenizer(in.readLine()," ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visited = new boolean[N][M];

            int n, m;
            for(int i=0; i<K; i++) {
                st = new StringTokenizer(in.readLine());
                m = Integer.parseInt(st.nextToken());
                n = Integer.parseInt(st.nextToken());

                map[n][m] = 1;
            }

            int count = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(map[i][j] == 0 || visited[i][j]) continue;
                    bfs(i, j);
                    count++;
                }
            }

            System.out.println(count);
        }
    }

    static int[] dr = {0, 0, -1, 1}, dc = {-1, 1, 0, 0};
    static void bfs(int r, int c) {
        q.clear();

        q.offer(new int[]{r, c});
        visited[r][c] = true;

        while(!q.isEmpty()) {
            int[] p = q.poll();

            for(int d=0; d<4; d++) {
                int nr = p[0]+dr[d];
                int nc = p[1]+dc[d];

                if(!isIn(nr, nc) || map[nr][nc] == 0 || visited[nr][nc]) continue;
                q.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
    }

    static boolean isIn(int r, int c) {
        return 0<=r && r<N && 0<=c && c<M;
    }
}
