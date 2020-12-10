import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S10888 {
    static int N;
    static int[][] map;
    static ArrayList<Pair> stores;
    static boolean[] subset;
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());
        stores = new ArrayList<>();
        for(int t=1; t<=T; t++) {
            stores.clear();
            N = Integer.parseInt(in.readLine());
            map = new int[N][N];
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] >= 2) stores.add(new Pair(i, j, 0));
                }
            }
            subset = new boolean[stores.size()];

            answer = Integer.MAX_VALUE;
            dfs(0);
            System.out.println("#"+t+" "+answer);
        }
    }
    static void dfs(int idx) {
        if(idx == subset.length) {
            int score = bfs();
            answer = Math.min(score, answer);
            return;
        }
        
        subset[idx] = true;
        dfs(idx+1);
        subset[idx] = false;
        dfs(idx+1);
    }

    static int[] dr = {0, 0, -1, 1}, dc = {-1, 1, 0, 0};
    static int bfs() {
        int score = 0;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        for(int i=0; i<subset.length; i++) {
            if(subset[i]) {
                Pair p = stores.get(i);
                q.offer(p);
                score += map[p.r][p.c];
            }
        }
        
        if(q.size() == 0) return Integer.MAX_VALUE;

        while(!q.isEmpty()) {
            Pair p = q.poll();
            visited[p.r][p.c] = true;
            if(map[p.r][p.c] == 1) score+=p.num;

            for(int i=0; i<4; i++) {
                int nr = p.r+dr[i];
                int nc = p.c+dc[i];
                if(isIn(nr, nc) && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new Pair(nr, nc, p.num+1));
                }
            }

        }
        return score;
    }

    static boolean isIn(int r, int c) {
        return 0<=r && r<N && 0<=c && c<N;
    }

    static class Pair {
        int r, c, num;

        public Pair(int r, int c, int num) {
            this.r = r;
            this.c = c;
            this.num = num;
        }
    }
}