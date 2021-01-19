package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1463_1로만들기 {
    static int X;
    static int[] memo;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        X = Integer.parseInt(in.readLine());
        memo = new int[X+1];

        int t1, t2, t3;
        for(int i=X-1; i>=1; i--) {
            t1=t2=t3=Integer.MAX_VALUE;
            t1 = memo[i+1]+1;
            if(i*2 <= X) t2 = memo[i*2]+1;
            if(i*3 <= X) t3 = memo[i*3]+1;
            memo[i] = Math.min(Math.min(t1, t2), t3);
        }
        System.out.println(memo[1]);
    }
}
