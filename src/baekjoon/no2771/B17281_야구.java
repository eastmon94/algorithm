package baekjoon.no2771;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17281_야구 {

    static int N;
    static int[][] input;
    static int[] numbers;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());
        input = new int[N][9];
        numbers = new int[9];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for(int j=0; j<9; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int idx, int flag) {
        if(idx == 9) {
            int score = solution();
            if(answer < score) answer = score;

            return;
        }
        
        if(idx == 3) {
            numbers[idx] = 0;
            dfs(idx+1, flag | 1<<0);

            return;
        }

        for(int i=1; i<9; i++) {
            if((flag & 1<<i) == 0) {
                numbers[idx] = i;
                dfs(idx+1, flag | 1<<i);
            } 
        }
    }

    private static int solution() {
        int totalScore = 0;
        int i=0;
        for(int inning=0; inning<N; inning++) { // 이닝 돌리기
            
            int outCount = 0;
            int score = 0;
            int[] map = new int[3];
            
            while(true) { // 각 이닝의 선수들
                if(outCount == 3) break;
                int n = numbers[i];
                
                switch(input[inning][n]) {
                    case 0:
                        outCount++;
                        break;
                    case 1:
                        for(int k=2; k>=0; k--) {
                            if(map[k] == 1) {
                                if(k == 2) {
                                    score++;
                                    map[k] = 0;
                                } else {
                                    map[k] = 0;
                                    map[k+1] = 1;
                                }
                            }
                        }
                        map[0] = 1;
                        break;
                    case 2:
                        for(int k=2; k>=0; k--) {
                            if(map[k] == 1) {
                                if(k >= 1) {
                                    score++;
                                    map[k] = 0;
                                } else {
                                    map[k] = 0;
                                    map[k+2] = 1;
                                }
                            }
                        }
                        map[1] = 1;
                        break;
                    case 3:
                        int temp = 0;
                        for(int k=0; k<3; k++) {
                            if(map[k] == 1) {
                                temp++;
                                map[k] = 0;
                            }
                        }
                        score += temp;
                        map[2] = 1;
                        break;
                    case 4:
                        int t = 0;
                        for(int k=0; k<3; k++) {
                            if(map[k] == 1) {
                                t++;
                                map[k] = 0;
                            }
                        }
                        score += t+1;
                        break;
                }
                i = (i+1)%9;
            }
            totalScore += score;
        }

        return totalScore;
    }
}
