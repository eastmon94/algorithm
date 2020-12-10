package baekjoon.no1152;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14501_퇴사 {
    static int N;
    static int[] period, price;
    static int[][] memo;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());

        period = new int[N];
        price  = new int[N];
        memo = new int[N+1][2];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            period[i] = Integer.parseInt(st.nextToken());
            price[i]  = Integer.parseInt(st.nextToken());
        }

        for(int i=N-1; i>=0; i--) {
            if(i+period[i] > N) {
                memo[i][0] = memo[i+1][0];
                memo[i][1] = memo[i+1][1];
                continue;
            }
            memo[i][0] = Math.max(memo[i+1][0], memo[i+1][1]);
            int num = Math.max(memo[i+period[i]][0], memo[i+period[i]][1]);
            memo[i][1] = num+price[i];
        }

        System.out.println(Math.max(memo[0][0], memo[0][1]));
    }
}
