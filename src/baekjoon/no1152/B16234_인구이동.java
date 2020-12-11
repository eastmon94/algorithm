package baekjoon.no1152;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16234_인구이동 {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer=0;
        while(solution()) {
            answer++;
            for(int i=0; i<N; i++) {
                Arrays.fill(visited[i], false);
            }
        }
        System.out.println(answer);
    }

    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, 1, -1};
    static boolean solution() {
        Queue<Pair> q = new LinkedList<>();
        ArrayList<Pair> list = new ArrayList<>();
        boolean flag = false;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    q.offer(new Pair(i, j));
                    visited[i][j] = true;
                    list.add(new Pair(i, j));
                                        
                    int num = 1;
                    int totalCount = map[i][j];

                    while(!q.isEmpty()) {
                        Pair p = q.poll();
                        
                        for(int d=0; d<4; d++) {
                            int nr = p.r+dr[d];
                            int nc = p.c+dc[d];

                            if(isIn(nr, nc)) {
                                int diff = Math.abs(map[nr][nc]-map[p.r][p.c]);
                                if(!visited[nr][nc] && (L <= diff && diff <= R)) {
                                    flag = true;
                                    q.offer(new Pair(nr, nc));
                                    visited[nr][nc] = true;
                                    list.add(new Pair(nr, nc));
                                    num++;
                                    totalCount += map[nr][nc];
                                }
                            }
                        }
                    }

                    for(Pair p : list) {
                        map[p.r][p.c] = totalCount / num;
                    }
                    list.clear();
                }
            }
        }

        return flag;
    }

    static boolean isIn(int r, int c) {
        return 0<=r && r<N && 0<=c && c<N;
    }

    static class Pair {
        int r, c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}