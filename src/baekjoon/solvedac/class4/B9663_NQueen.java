package baekjoon.solvedac.class4;

import java.io.*;

public class B9663_NQueen {
    static int[][] map;
    static int N;
    static int answer=0;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());

        map = new int[N][N];

        dfs(0);

        System.out.println(answer);
    }

    static void dfs(int r) {

        if(r==N) {
            answer++;
            return;
        }

        for(int c=0; c<N; c++) {
            if(check(r, c)) {
                map[r][c] = 1;
                dfs(r+1);
                map[r][c] = 0;
            }
        }
    }


    static int[] dr = {-1, -1, -1}, dc = {0, 1, -1};
    static boolean check(int r, int c) {
        for(int d=0; d<3; d++) {
            int tr = r, tc = c;
            while(true) {
                int nr = tr+dr[d];
                int nc = tc+dc[d];

                if(!isIn(nr, nc)) break;
                if(map[nr][nc]==1) return false;

                tr = nr; tc = nc;
            }

        }
        return true;
    }

    static boolean isIn(int r, int c) {
        return 0<=r && r<N && 0<=c && c<N;
    }

}
