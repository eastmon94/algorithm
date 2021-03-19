package baekjoon.solvedac.class4;

import java.io.*;
import java.util.*;

public class B15657_N과M8 {
    static int N, M;
    static int[] numbers, input;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        input = new int[N];
        numbers = new int[M];

        st = new StringTokenizer(in.readLine(), " ");

        for(int i=0; i<N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);
        sb = new StringBuilder();

        combination(0, 0);
        System.out.println(sb.toString());
    }

    static void combination(int idx, int cur) {

        if(idx==M) {
            for(int i=0; i<M; i++) {
                sb.append(numbers[i]).append(' ');
            }

            sb.append("\n");
            return;
        }

        for(int i=cur; i<N; i++) {
            numbers[idx] = input[i];
            combination(idx+1, i);
        }
    }
}
