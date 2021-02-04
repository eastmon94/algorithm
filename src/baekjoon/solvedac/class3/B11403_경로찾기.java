package baekjoon.solvedac.class3;

import java.io.*;
import java.util.*;

public class B11403_경로찾기 {
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(in.readLine());
        int[][] adj = new int[N][N];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for(int j=0; j<N; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k=0; k<N; k++) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(adj[i][j]==1) continue;
                    if(adj[i][k]==1 && adj[k][j]==1) adj[i][j]=1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                sb.append(adj[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}
