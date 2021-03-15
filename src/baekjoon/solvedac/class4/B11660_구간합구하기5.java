package baekjoon.solvedac.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11660_구간합구하기5 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for(int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] memo = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                memo[i][j] = memo[i][j-1]+memo[i-1][j]-memo[i-1][j-1]+map[i][j];
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int x1, y1, x2, y2;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            int answer = memo[x2][y2]-memo[x1-1][y2]-memo[x2][y1-1]+memo[x1-1][y1-1];

            sb.append(answer+"\n");
        }

        System.out.println(sb.toString());
    }
}
