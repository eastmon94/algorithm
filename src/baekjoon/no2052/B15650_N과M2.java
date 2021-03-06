package baekjoon.no2052;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15650_N과M2 {
    static int N, M;
    static int[] numbers;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        numbers = new int[M];

        combination(0, 1);
        System.out.println(sb.toString());
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
            
            numbers[idx] = i;
            combination(idx+1, i+1);
        }
    }
}
