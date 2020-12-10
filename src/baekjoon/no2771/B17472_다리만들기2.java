package baekjoon.no2771;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17472_다리만들기2 {
    static int N, M;
    static int[][] map;
    static int numIsland;
    static int[][] edges;
    static int[] parents;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        checkNumber();
        calcDistance();

        Arrays.sort(edges, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        
        parents = new int[numIsland+1];
        for(int i=0; i<=numIsland; i++) {
            parents[i] = -1;
        }

        int MST = 0;
        for(int i=0; i<edges.length; i++) {
            if(union(edges[i][0], edges[i][1])) {
                MST += edges[i][2];
            }
        }
        int flag = 0;
        for(int i=1; i<parents.length; i++) {
            if(parents[i] < 0) flag++;
        }
        System.out.println(flag == 1 ? MST : -1);
    }

    static boolean union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if(xRoot != yRoot) {
            parents[yRoot] = xRoot;
            return true;
        }
        return false;
    }

    static int find(int x) {
        if(parents[x] < 0) return x;

        return parents[x] = find(parents[x]);
    }

    static boolean[][] visited;
    static void checkNumber() {
        visited = new boolean[N][M];
        
        int num = 1;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 0 || visited[i][j]) continue;

                bfs(i, j, num++);
            }
        }
        numIsland = num-1;
    }

    static int[] dr = {0, 0, -1, 1}, dc = {1, -1, 0, 0};
    static void bfs(int r, int c, int num) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(r, c));
        visited[r][c] = true;
        map[r][c] = num;

        while(!q.isEmpty()) {
            Pair p = q.poll();

            int nr, nc;
            for(int i=0; i<4; i++) {
                nr = p.r+dr[i];
                nc = p.c+dc[i];

                if(!isIn(nr, nc) || visited[nr][nc] || map[nr][nc] == 0) continue;
                map[nr][nc] = num;
                visited[nr][nc] = true;
                q.offer(new Pair(nr, nc));
            }
        }
    }

    static boolean isIn(int r, int c) {
        return 0<=r && r<N && 0<=c && c<M;
    }

    static void calcDistance() {
        int[][] temp = new int[numIsland+1][numIsland+1];
        int edgeNum = 0;
        for(int i=0; i<=numIsland; i++) {
            for(int j=0; j<=numIsland; j++) {
                temp[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j]==0) continue;
                int num = map[i][j];

                for(int d=0; d<4; d++) {
                    int cnt = 0;
                    int curRow = i; int curCol = j;
                    int newRow, newCol;
                    while(true) {
                        newRow = curRow+dr[d];
                        newCol = curCol+dc[d];
                        if(!isIn(newRow, newCol)) break;
                        if(map[newRow][newCol]!=0) {
                            if(map[newRow][newCol] == num) break;
                            if(cnt > 1 && temp[num][map[newRow][newCol]] > cnt) {
                                temp[num][map[newRow][newCol]] = cnt;
                                edgeNum++;
                                break;
                            }
                            break;
                        }
                        cnt++;
                        curRow = newRow;
                        curCol = newCol;
                    }
                }
            }
        }
        edges = new int[edgeNum][3];
        int cnt = 0;
        for(int i=0; i<=numIsland; i++) {
            for(int j=0; j<=numIsland; j++) {
                if(temp[i][j] == Integer.MAX_VALUE || temp[i][j] == 1) continue;
                edges[cnt][0] = i;
                edges[cnt][1] = j;
                edges[cnt][2] = temp[i][j];
                cnt++;
            }
        }
    }


    static class Pair {
        int r, c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
