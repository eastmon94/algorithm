package baekjoon.solvedac.class3;

import java.io.*;
import java.util.*;

public class B2630_색종이만들기 {
    static int N;
    static int[][] map;
    static int[] answer;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = new int[2];
        dfs(0, 0, N);
        System.out.println(answer[0]+"\n"+answer[1]);
    }

    static void dfs(int r, int c, int length) {
        boolean flag = false;
        int sValue = map[r][c];
        L:for(int i=r; i<r+length; i++) {
            for(int j=c; j<c+length; j++) {
                if(map[i][j]==sValue) continue;
                flag=true;
                break L;
            }
        }

        if(flag) {
            int len = length/2;
            for(int i=0; i<2; i++) {
                for(int j=0; j<2; j++) {
                    dfs(r+i*len, c+j*len, len);
                }
            }
        }
        else answer[sValue]++;
    }
}
