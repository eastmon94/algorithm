package baekjoon.solvedac.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1629_곱셈 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());
        System.out.println(dfs(A, B, C));
    }
    
    static long dfs(long a, long b, long c) {
        if(b==1) return a%c;

        long num = dfs(a, b/2, c);

        if(b%2==0) return (num*num)%c;
        else       return (( (num*num)%c ) * (a%c))%c;

    }
}