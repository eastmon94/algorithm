package baekjoon.no4349;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12865_평범한배낭 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] weights = new int[N+1];
        int[] values = new int[N+1];
        int[][] memo = new int[N+1][K+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=K; j++) {
                memo[i][j] = memo[i-1][j];
                
                if(j >= weights[i]) memo[i][j] = Math.max(memo[i][j], memo[i-1][j-weights[i]]+values[i]);
            }
        }

        System.out.println(memo[N][K]);
    }

}
