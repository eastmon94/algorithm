package baekjoon.solvedac.class4;

import java.io.*;
import java.util.*;

public class B11725_트리의부모찾기 {
    static ArrayList<Integer>[] tree;
    static int[] parent;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(in.readLine());

        tree = new ArrayList[N+1];
        parent = new int[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++) {
            tree[i] = new ArrayList<>();
        }

        while(true) {
            try {
                st = new StringTokenizer(in.readLine(), " ");
                int s=Integer.parseInt(st.nextToken());
                int e=Integer.parseInt(st.nextToken());
    
                tree[s].add(e);
                tree[e].add(s);

            } catch(Exception e) {
                break;
            }

        }

        dfs(1);
        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=N; i++) {
            sb.append(parent[i]+"\n");
        }
        System.out.println(sb.toString());
    }
    
    static void dfs(int num) {
        visited[num]=true;

        for(int i=0; i<tree[num].size(); i++) {
            int next = tree[num].get(i);
            if(visited[next]) continue;
            parent[next]=num;
            dfs(next);
        }
    }
}