package baekjoon.solvedac.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9465_스티커 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());

        while(T-->0) {
            int N = Integer.parseInt(in.readLine());
            int[][] numbers = new int[2][N];
            int[][] memo = new int[2][N];

            for(int i=0; i<2; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                for(int j=0; j<N; j++) {
                    numbers[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            memo[0][0] = numbers[0][0];
            memo[1][0] = numbers[1][0];

            for(int i=1; i<N; i++) {
                if(i==1) {
                    memo[0][i] = memo[1][i-1]+numbers[0][i];
                    memo[1][i] = memo[0][i-1]+numbers[1][i];
                } else {
                    memo[0][i] = Math.max(memo[1][i-1], Math.max(memo[0][i-2], memo[1][i-2]))+numbers[0][i];
                    memo[1][i] = Math.max(memo[0][i-1], Math.max(memo[0][i-2], memo[1][i-2]))+numbers[1][i];
                }
            }

            System.out.println(Math.max(memo[0][N-1], memo[1][N-1]));
        }
    }
}
