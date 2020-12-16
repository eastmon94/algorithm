package baekjoon.no1152;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14499_주사위굴리기 {
    static int N, M, X, Y, K;
    static int[][] map;
    static Dice dice;
    public static void main(String[] args) throws Exception{
        
        dice = new Dice(0, 0, 0, 0, 0, 0);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(in.readLine(), " ");
        solution(st);
    }
    
    static int[] dr = {0, 0, 0, -1, 1}, dc = {0, 1, -1, 0, 0};
    static void solution(StringTokenizer st) {
        int command;
        int r = X, c = Y;
        for(int i=0; i<K; i++) {
            command = Integer.parseInt(st.nextToken());
            
            int nr = r+dr[command];
            int nc = c+dc[command];
            if(!isIn(nr, nc)) continue;
            
            direction(command);

            if(map[nr][nc] == 0) map[nr][nc] = dice.bottom;
            else {
                dice.bottom = map[nr][nc];
                map[nr][nc] = 0;
            }
            System.out.println(dice.top);
            r = nr; c = nc;
        }
    }

    static boolean isIn(int r, int c) {
        return 0<=r && r<N && 0<=c && c<M;
    }

    public static void direction(int d) {
        int temp;
        switch(d) {
            case 1:
            temp = dice.right;
            dice.right  = dice.top;
            dice.top    = dice.left;
            dice.left   = dice.bottom;
            dice.bottom = temp;
            break;
            
            case 2:
            temp = dice.top;
            dice.top = dice.right;
            dice.right = dice.bottom;
            dice.bottom = dice.left;
            dice.left = temp;
            break;

            case 3:
            temp = dice.top;
            dice.top = dice.down;
            dice.down = dice.bottom;
            dice.bottom = dice.up;
            dice.up = temp;
            break;

            case 4:
            temp = dice.top;
            dice.top = dice.up;
            dice.up = dice.bottom;
            dice.bottom = dice.down;
            dice.down = temp;
            break;
        }
        
    }

    static class Dice {
        int top, left, right, up, down, bottom;
        public Dice(int top, int left, int right, int up, int down, int bottom) {
            this.top = top;
            this.left = left;
            this.right = right;
            this.up = up;
            this.down = down;
            this.bottom = bottom;
        }
    }
}
