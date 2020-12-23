package baekjoon.no1152;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14500_테트로미노 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int n=0; n<N; n++) {
            st = new StringTokenizer(in.readLine(), " ");
            for(int m=0; m<M; m++) {
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        for(int n=0; n<N; n++) {
            for(int m=0; m<M; m++) {
                dfs(n, m, map[n][m], 1);
                int value = fkyu(n, m);
                answer = Math.max(answer, value);
            }
        }

        System.out.println(answer);
    }

    static int fkyu(int r, int c) {
        int nr, nc, total = map[r][c];
        for(int d=0; d<4; d++) {
            nr = r+dr[d]; nc = c+dc[d];
            if(!isIn(nr, nc)) continue;
            total += map[nr][nc];
        }

        int value = Integer.MIN_VALUE;
        for(int d=0; d<4; d++) {
            nr = r+dr[d]; nc = c+dc[d];
            if(!isIn(nr, nc)) {
                value = Math.max(value, total);
                continue;
            }
            value = Math.max(value, total-map[nr][nc]);
        }
        
        return value;
    }
    static int[] dr = {0, 0, -1, 1}, dc = {1, -1, 0, 0};
    static void dfs(int r, int c, int num, int count) {
        visited[r][c] = true;
        
        if(count == 4) {
            answer = Math.max(answer, num);    
            visited[r][c] = false;
            return;
        }
        int nr, nc;
        for(int d=0; d<4; d++) {
            nr = r+dr[d]; nc = c+dc[d];
            if(!isIn(nr, nc) || visited[nr][nc]) continue;
            dfs(nr, nc, num + map[nr][nc], count+1);
        }
        
        visited[r][c] = false;
    
    }

    static boolean isIn(int r, int c) {
        return 0<=r && r<N && 0<=c && c<M;
    }
}
