package baekjoon.no1152;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13460_구슬탈출2 {
    static int N, M;
    static char[][] map;
    static Pair blue, red;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        String input;
        for(int n=0; n<N; n++) {
            input = in.readLine();
            for(int m=0; m<M; m++) {
                char c = input.charAt(m);
                map[n][m] = c;
                if(c == 'B') {
                    blue = new Pair(n, m);
                    map[n][m] = '.';
                }
                if(c == 'R') {
                    red = new Pair(n, m);
                    map[n][m] = '.';
                }
            }
        }
    }
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    
    static void dfs(int idx, int d) {
        if(idx == 9) return;        

        for(int i=0; i<4; i++) {
            if(go(i)) {
                dfs(idx+1, i);
            }
        }
    }

    static boolean go(int d) {
        // R
        int nr, nc; 
        boolean redOk, blueOk;
        int count = 0;
        
        
        int redr = red.r, redc = red.c;
        boolean throughBlue = false;
        while(true) {
            nr = redr + dr[d];
            nc = redc + dc[d];

            if(map[nr][nc] == '#') {
                if(count == 0) {
                    redOk = false;
                    break;
                }

                redOk = true;
                break;
            }

            else if(nr==blue.r && nc==blue.c) {
                if(map[nr+dr[d]][nc+dc[d]] == '#') {
                    redOk = false;
                    break;
                }
                throughBlue = true;
            }

            redr = nr; redc = nc;
        }
        if(throughBlue) {
            redr -= dr[d];
            redc -= dc[d];
        }

        // B
        int bluer = blue.r, bluec = blue.c;
        boolean throughRed = false;
        count = 0;

        while(true) {
            nr = bluer + dr[d];
            nc = bluec + dc[d];

            if(map[nr][nc] == '#') {
                if(count == 0) {
                    blueOk = false;
                    break;
                }

                blueOk = true;
                break;
            }

            else if(map[nr][nc] == 'R') {
                if(map[nr+dr[d]][nc+dc[d]] == '#') {
                    blueOk = false;
                    break;
                }
                throughRed = true;
            }

            bluer = nr; bluec = nc;
        }

        if(throughRed) {
            bluer -= dr[d];
            bluec -= dc[d];
        }

        if(redOk || blueOk) {

        }
        return redOk || blueOk;
    }

    static class Pair {
        int r, c;
        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}