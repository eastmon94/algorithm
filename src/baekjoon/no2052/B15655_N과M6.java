package baekjoon.no2052;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15655_N과M6 {
    static int[] seq;
    static int[] numbers;
    static boolean[] selected;
    static int N, M;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        seq = new int[N];
        numbers = new int[M];
        selected = new boolean[N];
        st = new StringTokenizer(in.readLine());

        for(int i=0; i<N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(seq);

        // permutation(0);
        combination(0, 0);
    }

    private static void combination(int idx, int cur) {
        if(idx == M) {
            for(int i=0; i<M; i++) System.out.print(numbers[i] + " ");
            System.out.println();
            return;
        }        

        for(int i=cur; i<N; i++) {
            numbers[idx] = seq[i];
            combination(idx + 1, i + 1);
        }
    }


    private static void permutation(int idx) {

        if(idx == M) {
            System.out.println(Arrays.toString(numbers));

            return;
        }
        
        for(int i=0; i<N; i++) {
            if(selected[i]) continue;

            selected[i] = true;
            numbers[idx] = seq[i];
            permutation(idx+1);
            selected[i] = false;
        }
    }
}