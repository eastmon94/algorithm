package baekjoon.solvedac.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1238_파티_floyd {
    public static void main(String[] args) throws Exception {
        final int INF = Integer.MAX_VALUE;
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(i==j) continue;
                graph[i][j] = INF;
            }
        }

        for(int i=0; i<M; i++) {
            st=new StringTokenizer(in.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            graph[s][e] = n;
        }

        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                if(k==i) continue;
                for(int j=1; j<=N; j++) {
                    if(j==k || j==i) continue;

                    if(graph[i][k]!=INF && graph[k][j]!=INF &&
                       graph[i][j] > graph[i][k]+graph[k][j]) {
                        graph[i][j] = graph[i][k]+graph[k][j];    
                    }
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++) {
            if(graph[i][X]+graph[X][i] > answer) {
                answer = graph[i][X]+graph[X][i];
            }
        }

        System.out.println(answer);
    }
}
