package baekjoon.no1152;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14889_스타트와링크 {
    static int N;
    static int[][] table;
    static boolean[] check;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());
        table = new int[N][N];
        check = new boolean[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for(int j=0; j<N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, 0);
        System.out.println(answer);
    }

    static void combination(int idx, int count) {
        if(count == N/2) {
            int value = solution();
            answer = Math.min(value, answer);
            return;
        }

        if(idx == N) return;

        check[idx] = true;
        combination(idx+1, count+1);
        check[idx] = false;
        combination(idx+1, count);
    }

    static int solution() {
        int startValue = 0, linkValue = 0;
        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                if(check[i]==check[j]) {
                    if(check[i]) {
                        startValue += table[i][j];
                        startValue += table[j][i];
                    }else {
                        linkValue += table[i][j];
                        linkValue += table[j][i];
                    }
                }
            }
        }

        return Math.abs(startValue - linkValue);
    }
}
