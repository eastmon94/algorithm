package baekjoon.solvedac.class4;

import java.io.*;
import java.util.*;

public class B15663_N과M9 {
    static int N, M;
    static ArrayList<Integer> input;
    static int[] check, numbers;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        input = new ArrayList<>();
        check = new int[10001];
        numbers = new int[M];

        st = new StringTokenizer(in.readLine(), " ");
        for(int i=0; i<N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if(input.contains(n)) {
                check[n]++;
            } else {
                input.add(n);
                check[n]=1;
            }
        }

        N = input.size();
        input.sort(null);

        sb = new StringBuilder();
        permutation(0);

        System.out.print(sb.toString());
    }

    static void permutation(int idx) {

        if(idx==M) {
            for(int i=0; i<M; i++) {
                sb.append(numbers[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++) {
            int num = input.get(i);
            if(check[num] == 0) continue;

            numbers[idx] = num;
            check[num]--;
            permutation(idx+1);
            check[num]++;
        }
    }
}
