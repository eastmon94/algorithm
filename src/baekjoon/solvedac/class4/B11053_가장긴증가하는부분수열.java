package baekjoon.solvedac.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11053_가장긴증가하는부분수열 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(in.readLine());
        int[] input = new int[N];

        st = new StringTokenizer(in.readLine(), " ");
        for(int i=0; i<N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int[] memo = new int[N];
        for(int i=0; i<N; i++) {
            memo[i] = 1;
            for(int j=0; j<i; j++) {
                if(input[i] > input[j] && memo[i] < memo[j]+1) {
                    memo[i] = memo[j]+1;
                }
            }
        }

        int answer = -1;
        for(int i=0; i<N; i++) {
            answer = Math.max(answer, memo[i]);
        }

        System.out.println(answer);
    }
}
