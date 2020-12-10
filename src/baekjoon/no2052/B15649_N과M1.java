package baekjoon.no2052;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15649_N과M1 {
    static int N, M;
    static int[] number;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        number = new int[M];

        permutation(0, 0);
    }

    static void permutation(int idx, int flag) {

        if(idx == M) {
            for(int i=0; i<M; i++) {
                System.out.print(number[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<=N; i++) {
            if((flag & 1<<i) != 0) continue;
            number[idx] = i;
            permutation(idx+1, flag | 1<<i);
        }
    }
}
