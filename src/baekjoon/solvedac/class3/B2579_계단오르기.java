package baekjoon.solvedac.class3;

import java.io.*;

public class B2579_계단오르기 {
    static int N;
    static int[] stairs;
    static int[] memo;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        memo = new int[N+1];
        stairs = new int[N+1];

        for(int i=1; i<=N; i++) {
            stairs[i] = Integer.parseInt(in.readLine());
        }

        int n1, n2;
        memo[1] = stairs[1];
        if(N>=2) memo[2] = stairs[1]+stairs[2];
        for(int i=3; i<=N; i++) {
            n1 = stairs[i]+stairs[i-1]+memo[i-3];
            n2 = stairs[i]+memo[i-2];
            memo[i] = Math.max(n1, n2);
        }

        System.out.println(memo[N]);
    }
}
