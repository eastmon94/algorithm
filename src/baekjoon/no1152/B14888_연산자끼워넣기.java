package baekjoon.no1152;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14888_연산자끼워넣기 {
    static int N;
    static int[] numbers;
    static int[] operators;
    static long minValue = Long.MAX_VALUE, maxValue = Long.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());
        numbers = new int[N];

        st = new  StringTokenizer(in.readLine(), " ");
        for(int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        operators = new int[4];
        st = new StringTokenizer(in.readLine(), " ");
        for(int i=0; i<4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, numbers[0]);
        System.out.println(maxValue + "\n" + minValue);
    }
    static void dfs(int idx, long value) {

        if(idx==N-1) {
            minValue = Math.min(value, minValue);
            maxValue = Math.max(value, maxValue);

            return;
        }

        for(int i=0; i<4; i++) {
            if(operators[i] <= 0) continue;

            operators[i]--;
            switch(i) {
                case 0:
                dfs(idx+1, value+numbers[idx+1]);
                break;
                case 1:
                dfs(idx+1, value-numbers[idx+1]);
                break;
                case 2:
                dfs(idx+1, value*numbers[idx+1]);
                break;
                case 3:
                dfs(idx+1, value/numbers[idx+1]);
                break;
            }
            operators[i]++;
        }
    }
}
