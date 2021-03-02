package baekjoon.solvedac.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2448_별찍기11 {
    static int N;
    static StringBuilder[] stars;
    static StringBuilder sb;
    static int totalCount;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());
        sb = new StringBuilder();
        stars = new StringBuilder[N];
        for(int i=0; i<N; i++) {
            stars[i] = new StringBuilder();
        }
        stars[0].append("*");
        stars[1].append("* *");
        stars[2].append("*****");
        dfs(6, 5);
        
        for(int i=0; i<N; i++) {
            int len = stars[i].length();
            stars[i].insert(0, " ".repeat((totalCount-len)/2));
            stars[i].append(" ".repeat((totalCount-len)/2));
            System.out.println(stars[i].toString());
        }
    }

    static void dfs(int n, int count) {
        if(n>N) {
            totalCount = count;
            return;
        }

        for(int i=n/2; i<n; i++) {
            stars[i].append(stars[i-n/2].toString());
        }

        int c = count;
        for(int i=n/2; i<n; i++) {
            stars[i].append(" ".repeat(c));
            c-=2;
        }

        for(int i=n/2; i<n; i++) {
            stars[i].append(stars[i-n/2].toString());
        }

        dfs(n*2, count*2+1);
    }
}
