package baekjoon.solvedac.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14938_서강그라운드 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[] items = new int[N+1];
        st = new StringTokenizer(in.readLine(), " ");
        for(int i=1; i<=N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        final int INF = 987654321;
        int[][] graph = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(i==j) continue;
                graph[i][j] = INF;
            }
        }
        
        for(int i=0; i<R; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            int s, e, c;
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            graph[s][e] = Math.min(graph[s][e], c);
            graph[e][s] = Math.min(graph[e][s], c);
        }

        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                if(k==i) continue;
                for(int j=1; j<=N; j++) {
                    if(k==j || i==j) continue;

                    if(graph[i][j] > graph[i][k]+graph[k][j]) {
                        graph[i][j] = graph[i][k]+graph[k][j];
                    }
                }
            }
        }

        int answer = Integer.MIN_VALUE;

        for(int i=1; i<=N; i++) {
            int sum = 0;
            for(int j=1; j<=N; j++) {
                if(graph[i][j] > M) continue;
                sum+=items[j];
            }

            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}
