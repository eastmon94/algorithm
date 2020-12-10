package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11724_2_연결요소의개수 {
    
    static int N, M;
    static int[] parents;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N+1];
        
        int u, v;
        while(M-->0) {
            st = new StringTokenizer(in.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            union(u, v);
        }

        int totalCount = 0;
        for(int i=1; i<=N; i++) {
            if(parents[i] == 0) totalCount++;
        }
        System.out.println(totalCount);
    }

    private static int find(int x) {
        if(parents[x] == 0) return x;
        return parents[x] = find(parents[x]);
    }

    private static boolean union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if(xRoot != yRoot) {
            parents[yRoot] = xRoot;
            return true;
        }
        return false;
    }
}
