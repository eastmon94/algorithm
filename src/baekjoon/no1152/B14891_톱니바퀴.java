package baekjoon.no1152;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14891_톱니바퀴 {
    static int[][] sawTooths;
    static int K;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sawTooths = new int[5][8];
        
        for(int i=1; i<=4; i++) {
            String input = in.readLine();
            for(int j=0; j<8; j++) {
                sawTooths[i][j] = input.charAt(j)-'0';
            }
        }

        K = Integer.parseInt(in.readLine());
        int n, d;
        for(int k=0; k<K; k++) {
            st = new StringTokenizer(in.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            rotate(n, d, 0);
        }

        int answer = 0;
        for(int i=1; i<=4; i++) {
            answer += (sawTooths[i][0]*(int)Math.pow(2, i-1));
        }

        System.out.println(answer);
    }

    static void rotate(int n, int d, int flag) {
        if(flag == 0) { // 시작, 양쪽
            //왼쪽
            if(n != 1) {
                if(sawTooths[n][6] != sawTooths[n-1][2]){
                    rotate(n-1, -d, 1);
                }
            }
            //오른쪽
            if(n != 4) {
                if(sawTooths[n][2] != sawTooths[n+1][6]) {
                    rotate(n+1, -d, 2);
                }
            }
        }else if(flag == 1) { // 왼쪽으로 갔을 때
            //왼쪽
            if(n != 1) {
                if(sawTooths[n][6] != sawTooths[n-1][2]) {
                    rotate(n-1, -d, 1);
                }
            }
        }else if(flag == 2) { // 오른쪽으로 갔을 때
            if(n != 4) {
                if(sawTooths[n][2] != sawTooths[n+1][6]) {
                    rotate(n+1, -d, 2);
                }
            }
        }
        rotation(n, d);
    }

    static void rotation(int n, int d) {
        if(d == 1) {
            int temp = sawTooths[n][7];
            for(int i=7; i>=0; i--) {
                if(i==0) {
                    sawTooths[n][0] = temp;
                }else {
                    sawTooths[n][i] = sawTooths[n][i-1];
                }
            }
        }else if(d == -1) {
            int temp = sawTooths[n][0];
            for(int i=0; i<8; i++) {
                if(i==7) {
                    sawTooths[n][7] = temp;                    
                }else {
                    sawTooths[n][i] = sawTooths[n][i+1];
                }
            }
        }
    }
}
