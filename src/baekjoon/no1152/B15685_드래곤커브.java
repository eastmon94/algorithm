package baekjoon.no1152;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15685_드래곤커브 {
    static int N;
    static int[][] input;
    static int[][] direction;
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[101][101];
        N = Integer.parseInt(in.readLine());
        input = new int[N][4];
        for(int n=0; n<N; n++) {
            st = new StringTokenizer(in.readLine(), " ");
            for(int i=0; i<4; i++) {
                input[n][i] = Integer.parseInt(st.nextToken());
            }
        }

        direction = new int[10][512];
        genDirection(0);
        
        for(int n=0; n<N; n++) {
            simulate(input[n][1], input[n][0], input[n][2], input[n][3], n+1);
        }

        System.out.println(recCount());
    }
    
    static int[] dr = {0, -1, 0, 1}, dc = {1, 0, -1, 0};
    static void simulate(int r, int c, int d, int g, int n) {
        int cr = r+dr[d], cc = c+dc[d];
        int nr, nc;
        map[r][c]=n;
        map[cr][cc]=n;
        for(int i=0; i<=g-1; i++) {
            for(int j=0; j<512; j++) {
                if(direction[i][j]==0) break;
                d=(d+direction[i][j]+4)%4;
                nr = cr+dr[d];
                nc = cc+dc[d];
                map[nr][nc] = n;
                cr = nr; cc = nc;
            }
        }
    }

    static void genDirection(int idx) {
        if(idx==10) return;
        direction[idx][0] = 1;
        
        int count = 1;
        for(int i=idx-1; i>=0; i--) {
            int num = (int)Math.pow(2, i)-1;
            for(int n=num; n>=0; n--) {
                direction[idx][count++] = -direction[i][n];
            }
        }
        genDirection(idx+1);
    }


    static int recCount() {
        int count=0;
        for(int i=0; i<100; i++) {
            for(int j=0; j<100; j++) {
                if(map[i][j] == 0) continue;
                
                if(map[i+1][j]!=0 && map[i][j+1]!=0 && map[i+1][j+1]!=0) count++;
            }
        }

        return count;
    }

    static boolean isIn(int r, int c) {
        return 0<=r && r<100 && 0<=c && c<100;
    }
}
