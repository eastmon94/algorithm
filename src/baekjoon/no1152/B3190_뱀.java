package baekjoon.no1152;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B3190_뱀 {
    static int N, K, L;
    static int[][] map;
    static LinkedList<int[]> sneak;
    static Pair[] dirs;
    
    static int d = 0, dirCount = 0;
    static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());
        map = new int[N][N];
        K = Integer.parseInt(in.readLine());
        int t1, t2;
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(in.readLine());
            t1 = Integer.parseInt(st.nextToken())-1;
            t2 = Integer.parseInt(st.nextToken())-1;

            map[t1][t2] = 1;
        }

        L = Integer.parseInt(in.readLine());
        char tc;
        dirs = new Pair[L];
        for(int i=0; i<L; i++) {
            st = new StringTokenizer(in.readLine());
            t1 = Integer.parseInt(st.nextToken());
            tc = st.nextToken().charAt(0);
            dirs[i] = new Pair(t1, tc);
        }

        int time = 0;
        int r = 0, c = 0;
        
        sneak = new LinkedList<>();
        
        while(true) {
            if(!isIn(r, c) || map[r][c] == -1) break;
            
            
            if(map[r][c] == 0 && sneak.size() > 0) {
                int[] tail = sneak.get(0);
                map[tail[0]][tail[1]] = 0;
                sneak.remove(0);
            }
            
            map[r][c] = -1;
            sneak.add(new int[] {r, c});
            
            changeDir(time);

            r+= dr[d];
            c+= dc[d];
            time++;
        }

        System.out.println(time);
    }

    static void changeDir(int time) {
        if(dirCount >= dirs.length || dirs[dirCount].x > time) return;
        else {
            if(dirs[dirCount].dir == 'D') d = (d+1)%4;
            else d = (d+3)%4;
            dirCount++;
            return;
        }
    }

    static boolean isIn(int c, int r) {
        return 0 <= c && c < N && 0 <= r && r < N;
    }

    static class Pair {
        int x;
        char dir;

        Pair(int x, char dir) {
            this.x = x;
            this.dir = dir;
        }
    }
}
