package baekjoon.solvedac.class3;

import java.io.*;

public class B1992_쿼드트리 {
    static int N;
    static int[][] map;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());
        map = new int[N][N];

        String input;
        for(int i=0; i<N; i++) {
            input = in.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = input.charAt(j)-'0';
            }
        }

        sb = new StringBuilder();
        divideConquer(0, 0, N);
        System.out.println(sb.toString());
    }
    
    static void divideConquer(int r, int c, int length) {
        int v = map[r][c];
        boolean flag = false;
        L:for(int i=r; i<r+length; i++) {
            for(int j=c; j<c+length; j++) {
                if(v!=map[i][j]) {
                    flag = true;
                    break L;
                }
            }
        }

        if(flag) {
            int len = length/2;
            sb.append('(');
            divideConquer(r, c, length/2);
            divideConquer(r, c+len, length/2);
            divideConquer(r+len, c, length/2);
            divideConquer(r+len, c+len, length/2);
            sb.append(')');
        }else {
            sb.append(v);
        }
    }
}
