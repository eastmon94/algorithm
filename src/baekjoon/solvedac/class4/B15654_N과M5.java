package baekjoon.solvedac.class4;

import java.io.*;
import java.util.*;

public class B15654_N과M5 {
    static int N, M;
    static int[] input, numbers;
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
        permutation(0, 0);
        System.out.print(sb.toString());
    }

    static void permutation(int idx, int flag) {

        if(idx==M) {
            for(int i=0; i<M; i++) {
                sb.append(numbers[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++) {
            if((flag & 1<<i)!=0) continue;
            numbers[idx] = input[i];
            permutation(idx+1, flag | 1<<i);
        }
    }
}
