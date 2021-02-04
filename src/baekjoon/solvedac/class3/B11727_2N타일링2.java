package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B11727_2N타일링2 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());

        if(N==1) {
            System.out.println(1);
            return;
        }
        int[] memo = new int[N+1];
        memo[1]=1;
        memo[2]=3;
        for(int i=3; i<=N; i++) {
            memo[i] = (memo[i-2]*2 + memo[i-1])%10007;
        }

        System.out.println(memo[N]);
    }
}
