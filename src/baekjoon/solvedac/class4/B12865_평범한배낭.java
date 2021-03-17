package baekjoon.solvedac.class4;

import java.io.*;
import java.util.*;

public class B12865_평범한배낭 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] input = new int[N+1][2];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] memo = new int[N+1][K+1];

        for(int i=1; i<=N; i++) {
            int w = input[i][0];
            int v = input[i][1];
            for(int j=0; j<=K; j++) {
                memo[i][j] = memo[i-1][j];

                if(j >= w) memo[i][j] = Math.max(memo[i-1][j-w]+v, memo[i-1][j]);
            }
        }

        System.out.println(memo[N][K]);
    }
}
