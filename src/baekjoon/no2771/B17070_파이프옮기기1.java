package baekjoon.no2771;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17070_파이프옮기기1 {
    static int N;
    static int[][] map;
    static int totalCount;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());
        map = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        moveCol(0, 2);
        moveDiag(1, 2);
        System.out.println(totalCount);
    }

    static void moveRow(int r, int c) {
        if(!isIn(r, c) || map[r][c] != 0) return;

        if(r == N-1 && c == N-1) {
            totalCount++;
            return;
        }


        moveRow(r+1, c);
        moveDiag(r+1, c+1);
    }
    static void moveCol(int r, int c) {
        if(!isIn(r, c) || map[r][c] != 0) return;

        if(r == N-1 && c == N-1) {
            totalCount++;
            return;
        }


        moveCol(r, c+1);
        moveDiag(r+1, c+1);
    }
    static void moveDiag(int r, int c) {
        if(!isIn(r, c) || map[r][c] != 0 
            || map[r-1][c] != 0 || map[r][c-1] != 0) return;

        if(r == N-1 && c == N-1) {
            totalCount++;
            return;
        }

        moveRow(r+1, c);
        moveCol(r, c+1);
        moveDiag(r+1, c+1);
    }

    static boolean isIn(int r, int c) {
        return 0<=r && r<N && 0<=c && c<N;
    }
}
