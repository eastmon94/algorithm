package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11659_구간합구하기4 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];
        int[] memo = new int[N+1];

        st = new StringTokenizer(in.readLine(), " ");
        for(int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            memo[i+1] = memo[i]+numbers[i];
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            sb.append(memo[e]-memo[s-1]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
