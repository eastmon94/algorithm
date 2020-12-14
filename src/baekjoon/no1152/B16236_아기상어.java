package baekjoon.no1152;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16236_아기상어 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int fishNum;
    static Shark shark;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        int point;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for(int j=0; j<N; j++) {
                point = Integer.parseInt(st.nextToken());
                map[i][j] = point;
                if(point != 0 && point != 9) fishNum++;
                if(point == 9) {
                    shark = new Shark(i, j, 2, 2);
                    map[i][j] = 0;
                }
            }
        }

        int answer = solution();
        System.out.println(answer);
    }

    static int solution() {
        int count = 0;
        int[] point;
        while((point = bfs()) != null) {
            shark.r = point[0];
            shark.c = point[1];
            map[point[0]][point[1]] = 0;
            
            shark.num--;
            if(shark.num == 0) {
                shark.size++;
                shark.num = shark.size;
            }

            count+=point[2];
        }

        return count;
    }

    static int[] dr = {0, 0, -1, 1}, dc = {1, -1, 0, 0};
    static int[] bfs() {
        init();
        Queue<int[]> q = new LinkedList<>();
        ArrayList<int[]> eat = new ArrayList<>();
        q.offer(new int[]{shark.r, shark.c, 0});
        visited[shark.r][shark.c] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int d=0; d<4; d++) {
                int nr = cur[0]+dr[d];
                int nc = cur[1]+dc[d];
                if(!isIn(nr, nc) || visited[nr][nc]) continue;
                if(map[nr][nc] == 0 || map[nr][nc] == shark.size) {
                    q.offer(new int[]{nr, nc, cur[2]+1});
                    visited[nr][nc] = true;
                }

                if(map[nr][nc] > 0 && map[nr][nc] < shark.size) {
                    eat.add(new int[]{nr, nc, cur[2]+1});
                    visited[nr][nc] = true;
                }
            }
        }

        if(eat.size() == 0) return null;
        else {
            eat.sort(new Comparator<int[]>(){
                @Override
                public int compare(int[] o1, int[] o2) {
                    int answer = 0;
                    answer = o1[2]-o2[2];
                    if(answer == 0) {
                        answer = o1[0]-o2[0];
                        if(answer == 0) {
                            answer = o1[1]-o2[1];
                        }
                    }
                    return answer;
                }
            });

            return eat.get(0);
        }
    }

    static void init() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                visited[i][j] = false;
            }
        }
    }

    static boolean isIn(int r, int c) {
        return 0<=r && r<N && 0<=c && c<N;
    }


    static class Shark {
        int r, c, size, num;

        public Shark(int r, int c, int size, int num) {
            this.r = r;
            this.c = c;
            this.size = size;
            this.num = num;
        }
    }
}
