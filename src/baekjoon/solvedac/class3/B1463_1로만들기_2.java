package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1463_1로만들기_2 {
    static int X;
    static int[] memo;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        X = Integer.parseInt(in.readLine());
        memo = new int[X+1];
        dfs(X);
        System.out.println(memo[X]);
    }

    static int dfs(int n) {
        if(n==1) return 0;
        if(memo[n]!=0) return memo[n];

        int n1, n2, n3;
        n1 = n%3==0 ? dfs(n/3)+1 : Integer.MAX_VALUE;
        n2 = n%2==0 ? dfs(n/2)+1 : Integer.MAX_VALUE;
        n3 = dfs(n-1)+1;

        return memo[n] = Math.min(Math.min(n1, n2), n3);
    }
}
