package baekjoon.solvedac.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1916_최소비용구하기 {
    public static void main(String[] args) throws Exception {
        final int INF = 987654321;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(in.readLine());
        int M = Integer.parseInt(in.readLine());

        int[][] graph = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            Arrays.fill(graph[i], INF);
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[s][e] = Math.min(w, graph[s][e]);
        }

        st = new StringTokenizer(in.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[N+1];
        int[] key = new int[N+1];
        Arrays.fill(key, INF);
        key[A] = 0;

        for(int i=1; i<=N; i++) {
            int minVal = INF, idx = -1;
            
            for(int j=1; j<=N; j++) {
                if(!check[j] && key[j] < minVal) {
                    minVal = key[j];
                    idx=j;
                }
            }

            if(idx==-1) break;
            check[idx]=true;

            for(int j=1; j<=N; j++) {
                if(!check[j] && graph[idx][j]!=INF && key[j] > key[idx]+graph[idx][j]) {
                    key[j] = key[idx]+graph[idx][j];
                }
            }
        }

        System.out.println(key[B]);
    }
}
