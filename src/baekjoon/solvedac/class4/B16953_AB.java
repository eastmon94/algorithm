package baekjoon.solvedac.class4;

import java.io.*;
import java.util.*;

public class B16953_AB {
    static long A, B;
    static long answer = Long.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        dfs(A, 1);
        System.out.println(answer==Long.MAX_VALUE?-1:answer);
    }

    static void dfs(long n, long count) {
        if(n==B) {
            answer = Math.min(answer, count);
            return;
        }

        long next = n*2;
        if(next <= B) dfs(next, count+1);
        next = n*10+1;
        if(next <= B) dfs(next, count+1);

    }

}
