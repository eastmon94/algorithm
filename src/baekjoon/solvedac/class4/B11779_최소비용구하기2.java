package baekjoon.solvedac.class4;

import java.io.*;
import java.util.*;

public class B11779_최소비용구하기2 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        final int INF = 987654321;

        int N = Integer.parseInt(in.readLine());
        int M = Integer.parseInt(in.readLine());

        int[][] map = new int[N][N];
        for(int i=0; i<N; i++) {
            Arrays.fill(map[i], INF);
        }

        int s, e, c;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            s = Integer.parseInt(st.nextToken())-1;
            e = Integer.parseInt(st.nextToken())-1;
            c = Integer.parseInt(st.nextToken());

            map[s][e] = Math.min(map[s][e], c);
        }

        st = new StringTokenizer(in.readLine(), " ");
        int start = Integer.parseInt(st.nextToken())-1;
        int end = Integer.parseInt(st.nextToken())-1;

        int[] key = new int[N];
        boolean[] visited = new boolean[N];
        int[] parent = new int[N];
        Arrays.fill(key, INF);
        key[start] = 0;
        parent[start] = -1;

        for(int i=0; i<N; i++) {
            int minVal = INF, idx = -1;
            for(int j=0; j<N; j++) {
                if(!visited[j] && key[j] < minVal) {
                    minVal = key[j];
                    idx = j;
                }
            }
            if(idx==-1) break;
            visited[idx] = true;
            
            for(int j=0; j<N; j++) {
                if(!visited[j] && map[idx][j]!=INF && key[idx]+map[idx][j] < key[j]) {
                    key[j] = key[idx]+map[idx][j];
                    parent[j] = idx;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(key[end]+"\n");
        Stack<Integer> stack = new Stack<>();
        
        for(int i=end; i!=-1; i=parent[i]) {
            stack.push(i);
        }

        sb.append(stack.size()+"\n");

        while(!stack.isEmpty()) {
            sb.append((stack.pop()+1)+" ");
        }

        System.out.println(sb.toString());
    }
}
