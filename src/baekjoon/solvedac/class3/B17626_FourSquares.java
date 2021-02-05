package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B17626_FourSquares {
    static int INF = Integer.MAX_VALUE/2;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int[][] memo = new int[4][N+1];
        for(int i=0; i<4; i++){
            Arrays.fill(memo[i], INF);
            memo[i][0]=0;
        }

        int sqrt = (int) Math.sqrt(N);
        for(int i=1, num=1; i<=sqrt; i++, num=i*i) {
            memo[0][num]=1;
        }
        for(int count=1; count<=3; count++) {
            for(int n=1; n<=N; n++) {
                for(int i=1, num=1; i<=sqrt; i++, num=i*i) {
                    if(n-num < 0) continue;
                    if(memo[count-1][n-num]>=INF) continue;
                    memo[count][n] = Math.min(memo[count-1][n], memo[count-1][n-num]+1);
                }
            }
        }
        System.out.println(memo[3][N]);
    }
}
