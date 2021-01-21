package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1780_종이의개수 {
    static int N;
    static int[][] map;
    static int[] counts;
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

        counts = new int[3];
        dfs(0, 0, N);
        for(int i=0; i<3; i++) {
            System.out.println(counts[i]);
        }
    }

    public static void dfs(int r, int c, int length) {
        int startValue = map[r][c];
        
        boolean flag = false;
        L:for(int i=r; i<r+length; i++) {
            for(int j=c; j<c+length; j++) {
                if(startValue!=map[i][j]) {
                    flag = true;
                    break L;
                }
            }
        }

        if(flag) {
            int nLength=length/3;
            for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++) {
                    dfs(r+nLength*i, c+nLength*j, nLength);
                }
            }
        }else {
            check(startValue);
        }
    }
    static void check(int n) {
        switch(n) {
            case -1:
            counts[0]++;
            break;
            case 0:
            counts[1]++;
            break;
            case 1:
            counts[2]++;
            break;
        }
    }
}