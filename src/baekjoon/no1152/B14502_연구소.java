package baekjoon.no1152;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14502_연구소 {
    static int N, M;
    static int[][] map, input;
    static Queue<int[]> q;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        q = new LinkedList<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        input = new int[N][M];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for(int j=0; j<M; j++) {
                map[i][j] = input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, 0, 0);
        System.out.println(answer);
    }

    static void combination(int r, int c, int idx) {
        if(idx == 3) {
            bfs();
            return;
        }

        for(int i=r; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(i==r && j<c) continue;
                if(input[i][j] != 0) continue;

                input[i][j] = 1;
                if(j == M-1) combination(i+1, 0, idx+1);
                else combination(i, j+1, idx+1);
                input[i][j] = 0;
            }
        }
    }

    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static void bfs() {
        init();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j]==2) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] p = q.poll();
            
            int nr, nc;
            for(int d=0; d<4; d++) {
                nr = p[0] + dr[d];
                nc = p[1] + dc[d];

                if(!isIn(nr, nc) || map[nr][nc] != 0) continue;
                q.offer(new int[]{nr, nc});
                map[nr][nc] = 2;
            }
        }

        int count = countSafe();
        answer = Math.max(answer, count);
    }

    static int countSafe() {
        int count = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 0) count++;
            }
        }

        return count;
    }

    static boolean isIn(int r, int c) {
        return 0<=r && r<N && 0<=c && c<M;
    }

    static void init() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                map[i][j] = input[i][j];
            }
        }

        q.clear();
    }
}
