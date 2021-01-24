package baekjoon.solvedac.class3;

import java.io.*;
import java.util.*;

public class B2667_단지번호붙이기 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> q;
    static int[] counts;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());
        visited = new boolean[N][N];
        map = new int[N][N];

        String input;
        for(int i=0; i<N; i++) {
            input = in.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = input.charAt(j)-'0';
            }
        }

        int count=0;
        counts = new int[N*N];
        q = new LinkedList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(visited[i][j] || map[i][j]==0) continue;
                bfs(i, j, ++count);
            }
        }

        Arrays.sort(counts);
        StringBuilder sb = new StringBuilder();
        sb.append(count+"\n");
        for(int i=0; i<counts.length; i++) {
            if(counts[i]==0) continue;
            sb.append(counts[i]+"\n");
        }

        System.out.println(sb.toString());
    }

    static int[] dr = {0, 0, -1, 1}, dc = {-1, 1, 0, 0};
    static void bfs(int r, int c, int count) {
        q.offer(new int[]{r, c});
        visited[r][c] = true;
        counts[count]++;

        while(!q.isEmpty()) {
            int[] p = q.poll();

            for(int d=0; d<4; d++) {
                int nr = p[0]+dr[d];
                int nc = p[1]+dc[d];
                if(!isIn(nr, nc) || visited[nr][nc] || map[nr][nc]==0) continue;
                q.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
                counts[count]++;
            }
        }
    }

    static boolean isIn(int r, int c) {
        return 0<=r && r<N && 0<=c && c<N;
    }
}
