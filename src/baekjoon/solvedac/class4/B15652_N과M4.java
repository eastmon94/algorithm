package baekjoon.solvedac.class4;

import java.io.*;
import java.util.*;

public class B15652_N과M4 {
    static int N, M;
    static int[] numbers;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[M];

        sb = new StringBuilder();
        combination(0, 1);

        System.out.print(sb.toString());
    }

    static void combination(int idx, int cur) {

        if(idx==M) {
            for(int i=0; i<M; i++) {
                sb.append(numbers[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=cur; i<=N; i++) {
            numbers[idx]=i;
            combination(idx+1, i);
        }
    }
}
