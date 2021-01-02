package baekjoon.no1152;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15684_사다리조작 {
    static int N, M, H;
    static int[][] map;
    static int answer = Integer.MAX_VALUE;
    static boolean ok=false;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H+2][N+2];

        for(int m=0; m<M; m++) {
            st = new StringTokenizer(in.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 1;
        }

        for(int c=0; c<=3; c++) {
            dfs(0, 0, c);
        }

        System.out.println(answer==Integer.MAX_VALUE?-1:answer);
    }

    static void dfs(int idx, int count, int total) {
        if(ok) return;
        if(count==total) {
            if(simulate()) {
                answer = Math.min(answer, total);
                ok=true;
            }
            return;
        }
        
        int r,c;
        for(int i=idx; i<N*H; i++) {
            r=i/N+1;
            c=i%N+1;
            if(check(r, c)) {
                map[r][c]=1;
                dfs(i+1, count+1, total);
                map[r][c]=0;
            }
        }
    }

    static boolean check(int r, int c) {
        if(map[r][c-1]==1 || map[r][c]==1 || map[r][c+1]==1) return false;
        return true;
    }

    static boolean simulate() {
        for(int n=1; n<=N; n++) {
            int c = n;
            for(int r=1; r<=H; r++) {
                if(c != 0 && map[r][c-1] == 1) c--;
                else if(map[r][c] == 1) c++;
            }

            if(c != n) return false;
        }

        return true;
    }
}
