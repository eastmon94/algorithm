package baekjoon.no1983;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697_숨바꼭질 {
    static int[] step;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        step = new int[100001];
        Arrays.fill(step, Integer.MAX_VALUE);
        bfs(N, K);

        System.out.println(step[K]);
    }

    static int[] dn = {1, -1};
    private static void bfs(int N, int K) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(N, 0));
        step[N] = 0;

        while(!q.isEmpty()) {
            Pair p = q.poll();
            
            for(int i=0; i<3; i++) {
                if(i == 2) {
                    if(p.n*2 <= 100000 && step[p.n*2] > p.count+1) {
                        step[p.n*2] = p.count+1;
                        q.offer(new Pair(p.n*2, p.count+1));
                    }
                }
                else if(p.n+dn[i]<=100000 && p.n+dn[i]>=0 && 
                    step[p.n + dn[i]] > p.count+1) {
                    
                    step[p.n + dn[i]] = p.count+1;
                    q.offer(new Pair(p.n+dn[i], p.count+1));
                }
            }
        }
    }

    static class Pair {
        int n, count;

        public Pair(int n, int count) {
            this.n = n;
            this.count = count;
        }
    }
}
