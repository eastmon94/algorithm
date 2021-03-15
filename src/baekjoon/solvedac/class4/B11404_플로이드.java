package baekjoon.solvedac.class4;

import java.io.*;
import java.util.*;

public class B11404_플로이드 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        final int INF = 987654321;

        int N = Integer.parseInt(in.readLine());
        int M = Integer.parseInt(in.readLine());

        int[][] map = new int[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                map[i][j] = INF;
            }
        }

        int s, e, c;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            s = Integer.parseInt(st.nextToken())-1;
            e = Integer.parseInt(st.nextToken())-1;
            c = Integer.parseInt(st.nextToken());

            map[s][e] = Math.min(map[s][e], c);
        }

        for(int k=0; k<N; k++) {
            for(int i=0; i<N; i++) {
                if(k==i) continue;
                for(int j=0; j<N; j++) {
                    if(j==i || j==k) continue;

                    if(map[i][j] > map[i][k]+map[k][j]) {
                        map[i][j] = map[i][k]+map[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                sb.append((map[i][j]==INF?0:map[i][j])+" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
    
}