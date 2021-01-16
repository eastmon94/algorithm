package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1107_리모컨 {
    static int N;
    static boolean[] broken;
    static int answer=Integer.MAX_VALUE;
    static int cipher;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());
        int K = Integer.parseInt(in.readLine());
        broken = new boolean[10];
        if(K!=0) {
            st = new StringTokenizer(in.readLine(), " ");
            for(int k=0; k<K; k++) {
                int temp = Integer.parseInt(st.nextToken());
                broken[temp] = true;
            }
        }
        cipher = (int)Math.log10(N)+1;
        solution();
        System.out.println(answer);
    }

    static void solution() {
        answer = Math.abs(N-100);

        permutation(0, 0, 1);
    }

    static void permutation(int idx, int number, int count) {
        if(idx >= 1) {
            int diff = Math.abs(number-N);
            answer = Math.min(answer, diff+idx);
        }
        if(idx == 7) return;

        for(int i=0; i<10; i++) {
            if(broken[i]) continue;
            permutation(idx+1, number+(i*count), count*10);
        }

    }
}
