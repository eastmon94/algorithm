package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B9095_123더하기 {
    static int N, answer=0;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-->0) {
            N = Integer.parseInt(in.readLine());
            answer=0;
            dfs(0);
            sb.append(answer+"\n");
        }
        System.out.print(sb.toString());
    }

    static void dfs(int num) {
        if(num > N) return;
        if(num==N) {
            answer++;

            return;
        }

        for(int i=1; i<=3; i++) {
            dfs(num+i);
        }
    }
}
