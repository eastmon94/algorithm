package baekjoon.no1983;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class B2606_바이러스 {
    static boolean[] visited;
    static List<Integer>[] list;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(in.readLine());
        int m = Integer.parseInt(in.readLine());
        
        list = new LinkedList[n];
        for(int i=0; i<n; i++) {
            list[i] = new LinkedList<Integer>();
        }
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(in.readLine());
            int t1, t2;
            t1 = Integer.parseInt(st.nextToken());
            t2 = Integer.parseInt(st.nextToken());

            list[t1-1].add(t2-1);
            list[t2-1].add(t1-1);
        }

        visited = new boolean[n];
        for(int i : list[0]) dfs(i);
        int count = 0;
        for(boolean b : visited) {
            if(b) count++;
        }
        System.out.println(count-1);
    }

    private static void dfs(int num) {
        if(visited[num]) return;
        visited[num] = true;

        for(int i : list[num]) dfs(i);
    }
}
