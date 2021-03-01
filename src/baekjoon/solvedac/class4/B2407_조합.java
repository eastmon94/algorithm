package baekjoon.solvedac.class4;

import java.io.*;
import java.math.BigInteger;

public class B2407_조합 {
    static BigInteger[][] memo;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] input = in.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        memo = new BigInteger[101][101];
        for(int i=0; i<101; i++) {
            for(int j=0; j<101; j++) {
                memo[i][j] = new BigInteger("0");
            }
        }
        System.out.println(dfs(n, m));
    }

    static BigInteger dfs(int n, int r) {
        if(n==r) return new BigInteger("1");
        if(r==1) return new BigInteger(Integer.toString(n));

        BigInteger n1, n2;
        if(!memo[n-1][r].equals(new BigInteger("0"))) n1 = memo[n-1][r];
        else n1 = dfs(n-1, r);
        if(!memo[n-1][r-1].equals(new BigInteger("0"))) n2 = memo[n-1][r-1];
        else n2 = dfs(n-1, r-1);
        memo[n][r]=n1.add(n2);
        memo[n][n-r]=n1.add(n2);
        return memo[n][r];
    }
}
