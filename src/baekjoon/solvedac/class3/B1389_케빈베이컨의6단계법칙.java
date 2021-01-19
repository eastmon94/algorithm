package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1389_케빈베이컨의6단계법칙 {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static Queue<Pair> q;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        graph = new ArrayList[N+1];
        for(int n=1; n<=N; n++) {
            graph[n] = new ArrayList<>();
        }
        
        int n1, n2;
        for(int m=0; m<M; m++) {
            st = new StringTokenizer(in.readLine(), " ");
            
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());

            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        q = new LinkedList<>();
        int minValue = Integer.MAX_VALUE, minNum=0;
        for(int n=1; n<=N; n++) {
            int count = bfs(n);
            if(minValue > count) {
                minNum = n;
                minValue = count;
            }
            init();
        }

        System.out.println(minNum);
    }

    static int bfs(int s) {
        int count = 0;
        q.offer(new Pair(s, 0));
        visited[s] = true;

        while(!q.isEmpty()) {
            Pair p = q.poll();
            
            int size = graph[p.v].size();
            for(int i=0; i<size; i++) {
                int nv = graph[p.v].get(i);

                if(visited[nv]) continue;
                q.offer(new Pair(nv, p.count+1));
                visited[nv] = true;
                count += (p.count+1);
            }
        }

        return count;
    }

    static void init() {
        for(int n=1; n<=N; n++) {
            visited[n] = false;
        }
    }

    static class Pair {
        int v, count;
        public Pair(int v, int count) {
            this.v = v;
            this.count = count;
        }
    }
}
