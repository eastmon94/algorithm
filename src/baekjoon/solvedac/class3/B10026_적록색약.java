package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B10026_적록색약 {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static Queue<int[]> q;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        String input;
        for(int i=0; i<N; i++) {
            input = in.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        q = new LinkedList<>();
        int weak=0, not=0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(visited[i][j]) continue;
                bfs(i, j);
                not++;
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                visited[i][j] = false;
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(visited[i][j]) continue;
                bfsWeak(i, j);
                weak++;
            }
        }

        System.out.println(not+" "+weak);
    }

    static int[] dr={-1, 1, 0, 0}, dc={0, 0, -1, 1};
    static void bfsWeak(int r, int c) {
        char startValue = map[r][c];
        q.offer(new int[]{r, c});
        visited[r][c] = true;

        while(!q.isEmpty()) {
            int[] p = q.poll();
            r = p[0]; c=p[1];
            for(int d=0; d<4; d++) {
                int nr = r+dr[d];
                int nc = c+dc[d];

                if(!isIn(nr, nc) || visited[nr][nc]) continue;
                if(startValue=='B') {
                    if(startValue!=map[nr][nc]) continue;
                } else {
                    if(map[nr][nc]=='B') continue;
                }
                q.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
    }
    static void bfs(int r, int c) {
        q.offer(new int[]{r, c});
        visited[r][c] = true;

        while(!q.isEmpty()) {
            int[] p = q.poll();
            r = p[0]; c=p[1];
            for(int d=0; d<4; d++) {
                int nr = r+dr[d];
                int nc = c+dc[d];

                if(!isIn(nr, nc) || visited[nr][nc] || map[r][c] != map[nr][nc]) continue;
                q.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
    }

    static boolean isIn(int r, int c) {
        return 0<=r && r<N && 0<=c && c<N;
    }
}
