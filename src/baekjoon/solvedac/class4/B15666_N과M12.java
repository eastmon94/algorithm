package baekjoon.solvedac.class4;

import java.io.*;
import java.util.*;

public class B15666_N과M12 {
    static int N, M;
    static int[] numbers;
    static ArrayList<Integer> input;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        input = new ArrayList<>();
        numbers = new int[M];

        st = new StringTokenizer(in.readLine(), " ");
        for(int i=0; i<N; i++) {
            int inp = Integer.parseInt(st.nextToken());
            if(input.contains(inp)) continue;
            input.add(inp);
        }

        input.sort(null);
        N = input.size();
        
        sb=new StringBuilder();
        combination(0, 0);

        System.out.print(sb.toString());
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
            numbers[idx] = input.get(i);
            combination(idx+1, i);
        }
    }
}
