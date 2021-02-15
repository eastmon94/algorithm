package baekjoon.solvedac.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1504_특정한최단경로 {
    static int N, E;
    static final int INF = Integer.MAX_VALUE;
    static int[][] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        graph = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(i==j) continue;
                graph[i][j] = INF;
            } 
        }

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[s][e] = w;
            graph[e][s] = w;
        }

        st = new StringTokenizer(in.readLine(), " ");
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        int answer = Math.min(calc(1, n1, n2, N), calc(1, n2, n1, N));
        System.out.println(answer==INF?-1:answer);
    }

    static int dijkstra(int s, int e) {
        boolean[] check = new boolean[N+1];
        int[] key = new int[N+1];
        // int[] p = new int[N+1];
        Arrays.fill(key, INF);
        // Arrays.fill(p, -1);

        key[s] = 0;

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
                if(!check[j] && graph[idx][j]!=INF && 
                    key[j] > key[idx]+graph[idx][j]) {
                    
                    key[j]=key[idx]+graph[idx][j];
                    // p[j]=idx;
                }
            }
        }

        // for(int i=p[e]; i!=-1; i=p[i]) {
        //     if(i==N) return INF;
        // }
        return key[e];
    }

    static int calc(int s, int n1, int n2, int e) {
        int e1 = dijkstra(s, n1);
        if(e1==INF) return INF;
        int e2 = dijkstra(n1, n2);
        if(e2==INF) return INF;
        int e3 = dijkstra(n2, N);
        if(e3==INF) return INF;

        return e1+e2+e3;
    }
}
