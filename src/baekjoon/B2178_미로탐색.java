package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178_미로탐색 {
    static int N, M, ans;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+2][M+2];
        visited = new boolean[N+2][M+2];
        for(int i=1; i<=N; i++) {
            String line = in.readLine();
            for(int j=1; j<=M; j++) {
                map[i][j] = Character.getNumericValue(line.charAt(j-1));
            }
        }

        bfs();
        System.out.println(ans);
    }

    static int[] dr = {1, -1, 0, 0}, dc = {0, 0, 1, -1};
    public static void bfs() {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1, 1, 1));
        visited[1][1] = true;

        while(!q.isEmpty()) {
            Pair p = q.poll();
            for(int i=0; i<4; i++) {
                int r = p.r+dr[i];
                int c = p.c+dc[i];
                if(map[r][c] == 1 && !visited[r][c] ) {
                    q.add(new Pair(r, c, p.num+1));
                    visited[r][c] = true;
                }

                if(r == N && c == M) {
                    ans = p.num+1;
                    return;
                }
            }
        }
        
    }

    static class Pair{
        int r, c, num;
        
        public Pair(int r, int c, int num) {
            this.r = r;
            this.c = c;
            this.num = num;
        }
    }
}
