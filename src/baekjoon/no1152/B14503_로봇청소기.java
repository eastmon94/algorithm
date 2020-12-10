package baekjoon.no1152;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B14503_로봇청소기 {
    static int N, M, R, C, d;
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N+2][M+2];
        for(int i=0; i<=N+1; i++) {
            Arrays.fill(map[i], 1);
        }
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(in.readLine());
            for(int j=1; j<=M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int totalCount = simulate();
        System.out.println(totalCount);
    }

    static int[] dr = {-1, 0, 1, 0}, dc={0, 1, 0, -1};
    static int simulate() {
        int totalCount = 0;
        int cr = R+1, cc = C+1;
        int count = 0;
        while(true) {

            // 청소
            if(map[cr][cc] == 0){
                map[cr][cc] = -1;
                totalCount++;
                count = 0;
            }

            // 회전
            findDir();

            //이동
            if(map[cr+dr[d]][cc+dc[d]] == 0) {
                cr = cr+dr[d];
                cc = cc+dc[d];
            }

            // 이동불가
            else {
                if(count == 4) {
                    // 원래 방향
                    d=(d+1)%4;

                    if(map[cr+dr[(d+2)%4]][cc+dc[(d+2)%4]]==1) {
                        return totalCount;
                    }
                    else {
                        count = 0;
                        cr = cr + dr[(d+2)%4];
                        cc = cc + dc[(d+2)%4];
                    }
                }
                else count++;
            }
        }
    }

    static void findDir() {
        switch(d) {
            case 0: 
                d=3;
                break;
            case 1: 
                d=0;
                break;
            case 2: 
                d=1;
                break;
            case 3: 
                d=2;
                break;
        }
    }
}
