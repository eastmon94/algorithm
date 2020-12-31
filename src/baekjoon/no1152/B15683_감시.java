package baekjoon.no1152;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B15683_감시 {
    static int N, M;
    static int[][] input;
    static ArrayList<int[]> cctvs;
    static boolean[][][] check;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new int[N][M];
        cctvs = new ArrayList<>();

        for(int n=0; n<N; n++) {
            st = new StringTokenizer(in.readLine(), " ");
            for(int m=0; m<M; m++) {
                int i = Integer.parseInt(st.nextToken());
                input[n][m] = i;
                if(i>=1 && i<=5) cctvs.add(new int[]{n, m});
            }
        }
        if(cctvs.size()==0) {
            int count = 0;
            for(int n=0; n<N; n++) {
                for(int m=0; m<M; m++) {
                    if(input[n][m] == 0) count++;
                }
            }
            System.out.println(count);
            return;
        }
        check = new boolean[cctvs.size()][N][M];
        int[] temp = cctvs.get(0);
        int cctv = input[temp[0]][temp[1]];
        if(cctv==1) {
            for(int d=0; d<4; d++) {
                dfs(0, d);
            }
        }else if(cctv==2) {
            for(int d=0; d<2; d++) {
                dfs(0, d);
            }
        }else if(cctv==3) {
            for(int d=0; d<4; d++) {
                dfs(0, d);
            }
        }else if(cctv==4) {
            for(int d=0; d<4; d++) {
                dfs(0, d);
            }
        }else if(cctv==5) {
            dfs(0, 0);
        }

        System.out.println(answer);
    }

    static void dfs(int idx, int dir) {
        if(idx == cctvs.size()-1) {
            cover(cctvs.get(idx), idx, dir, true);
            int count = solution();
            answer = Math.min(answer, count);
            cover(cctvs.get(idx), idx, dir, false);
            return;
        }
        
        cover(cctvs.get(idx), idx, dir, true);
        int[] c = cctvs.get(idx+1);
        int cctv = input[c[0]][c[1]];
        if(cctv==1) {
            for(int d=0; d<4; d++) {
                dfs(idx+1, d);
            }
        }else if(cctv==2) {
            for(int d=0; d<2; d++) {
                dfs(idx+1, d);
            }
        }else if(cctv==3) {
            for(int d=0; d<4; d++) {
                dfs(idx+1, d);
            }
        }else if(cctv==4) {
            for(int d=0; d<4; d++) {
                dfs(idx+1, d);
            }
        }else if(cctv==5) {
            dfs(idx+1, 0);
        }
        cover(cctvs.get(idx), idx, dir, false);
    }

    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};//상하좌우
    static void cover(int[] c, int idx, int d, boolean b) {
        int cctv = input[c[0]][c[1]];
        switch(cctv) {
            case 1:
            if(d == 0)    go(c[0], c[1], idx, b, 0); //상
            else if(d==1) go(c[0], c[1], idx, b, 1); //하
            else if(d==2) go(c[0], c[1], idx, b, 2); //좌
            else          go(c[0], c[1], idx, b, 3); //우
            break;
            case 2:
            if(d==0) {
                go(c[0], c[1], idx, b, 0); //상
                go(c[0], c[1], idx, b, 1); //하
            }else {
                go(c[0], c[1], idx, b, 2); //좌
                go(c[0], c[1], idx, b, 3); //우
            }
            break;
            case 3:
            if(d==0) {
                go(c[0], c[1], idx, b, 0); //상
                go(c[0], c[1], idx, b, 3); //우
            }else if(d==1) {
                go(c[0], c[1], idx, b, 3); //우
                go(c[0], c[1], idx, b, 1); //하
            }else if(d==2) {
                go(c[0], c[1], idx, b, 1); //하
                go(c[0], c[1], idx, b, 2); //좌
            }else if(d==3) {
                go(c[0], c[1], idx, b, 2); //좌
                go(c[0], c[1], idx, b, 0); //상
            }
            break;
            case 4:
            if(d==0) {
                go(c[0], c[1], idx, b, 2); //좌
                go(c[0], c[1], idx, b, 0); //상
                go(c[0], c[1], idx, b, 3); //우
            }else if(d==1) {
                go(c[0], c[1], idx, b, 0); //상
                go(c[0], c[1], idx, b, 3); //우
                go(c[0], c[1], idx, b, 1); //하
            }else if(d==2) {
                go(c[0], c[1], idx, b, 3); //우
                go(c[0], c[1], idx, b, 1); //하
                go(c[0], c[1], idx, b, 2); //좌
            }else if(d==3) {
                go(c[0], c[1], idx, b, 1); //하
                go(c[0], c[1], idx, b, 2); //좌
                go(c[0], c[1], idx, b, 0); //상
            }
            break;
            case 5:
            go(c[0], c[1], idx, b, 0); //상
            go(c[0], c[1], idx, b, 1); //하
            go(c[0], c[1], idx, b, 2); //좌
            go(c[0], c[1], idx, b, 3); //우
            break;
        }
    }

    static void go(int r, int c, int idx, boolean b, int flag) {
        int cr = r, cc = c;
        while(true) {
            int nr = cr+dr[flag];
            int nc = cc+dc[flag];

            if(!isIn(nr, nc) || input[nr][nc] == 6) return;
            else if(input[nr][nc]==0) check[idx][nr][nc] = b;
            
            cr = nr;
            cc = nc;
        }
    }

    static int solution() {
        int K = cctvs.size();
        int count = 0;
        for(int n=0; n<N; n++) {
            for(int m=0; m<M; m++) {
                if(input[n][m] != 0) continue;
                boolean flag =false;
                for(int k=0; k<K; k++) {
                    if(check[k][n][m]) flag = true;
                }
                if(!flag) count++;
            }
        }

        return count;
    }

    static boolean isIn(int r, int c) {
        return 0<=r && r<N && 0<=c && c<M;
    }
}
