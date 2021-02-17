package baekjoon.solvedac.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1865_웜홀 {
    static final int INF = 1000000000;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0) {
            st = new StringTokenizer(in.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            ArrayList<Edge> edges = new ArrayList<>();
            int[] key = new int[N+1];
            Arrays.fill(key, INF);

            int s, e, w;
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                s = Integer.parseInt(st.nextToken()); 
                e = Integer.parseInt(st.nextToken());
                w = Integer.parseInt(st.nextToken());
                edges.add(new Edge(s, e, w));
                edges.add(new Edge(e, s, w));
            }

            for(int i=0; i<W; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                s = Integer.parseInt(st.nextToken()); 
                e = Integer.parseInt(st.nextToken());
                w = Integer.parseInt(st.nextToken());

                edges.add(new Edge(s, e, -w));
            }


            key[1] = 0;
            for(int n=1; n<N; n++) {
                for(Edge edge : edges) {
                    
                    if(key[edge.e] > key[edge.s]+edge.w) {
                        key[edge.e] = key[edge.s]+edge.w;
                    }
                }
            }

            sb.append(answer(edges, key));
        
        }

        System.out.println(sb.toString());
    }

    static String answer(ArrayList<Edge> ls, int[] key) {
        for(Edge edge : ls) {
            if( key[edge.e] > key[edge.s]+edge.w) return "YES\n";
        }

        return "NO\n";
    }

    static class Edge {
        int s, e, w;

        public Edge(int s, int e, int w) {
            this.s=s;
            this.e=e;
            this.w=w;
        }
    }
}
