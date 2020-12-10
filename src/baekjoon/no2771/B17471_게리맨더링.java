package baekjoon.no2771;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17471_게리맨더링 {
    static int N;
    static int[] population;
    static int[] numbers;
    static ArrayList<Integer>[] graph; 
    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());
        population = new int[N];
        numbers = new int[N];
        graph = new ArrayList[N];

        st = new StringTokenizer(in.readLine(), " ");
        for(int i=0; i<N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++) {
            graph[i] = new ArrayList<>();
            st = new StringTokenizer(in.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            for(int j=0; j<n; j++) {
                graph[i].add(Integer.parseInt(st.nextToken())-1);
            }
        }

        dfs(0);
        System.out.println(answer==Integer.MAX_VALUE?-1:answer);
    }

    private static void dfs(int idx) {
        if(idx == N) {
            if(link()) {
                int g1=0, g2=0;
                for(int i=0; i<N; i++) {
                    if(numbers[i] == 0) {
                        g1 += population[i];
                    } else {
                        g2 += population[i];
                    }
                }

                answer = Math.min(answer, Math.abs(g1 - g2));
            }

            return;
        }

        numbers[idx] = 0;
        dfs(idx+1);
        numbers[idx] = 1;
        dfs(idx+1);
    }

    private static boolean link() {
        Queue<Pair> q = new LinkedList<>();
        boolean[] visited = new boolean[N];
        for(int i=0; i<N; i++) {
            if(numbers[i] == 0) {
                q.offer(new Pair(i, numbers[i]));
                visited[i] = true;
                break;
            }
        }
        for(int i=0; i<N; i++) {
            if(numbers[i] == 1) {
                q.offer(new Pair(i, numbers[i]));
                visited[i] = true;
                break;
            }
        }
        if(q.size() != 2) return false;

        while(!q.isEmpty()) {
            Pair p = q.poll();
            ArrayList<Integer> vertex = graph[p.num];
            for(int i=0; i<vertex.size(); i++) {
                int adj = vertex.get(i);
                if(!visited[adj] && p.count == numbers[adj]) {
                    visited[adj] = true;
                    q.offer(new Pair(adj, numbers[adj]));
                }
            }
        }

        for(int i=0; i<N; i++) {
            if(!visited[i]) return false;
        }

        return true;
    }

    static class Pair {
        int num, count;

        public Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}
