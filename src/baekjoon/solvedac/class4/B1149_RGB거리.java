package baekjoon.solvedac.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1149_RGB거리 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(in.readLine());
        int[][] memo = new int[N+1][3];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());

            memo[i][0] = Math.min(red+memo[i-1][1], red+memo[i-1][2]);
            memo[i][1] = Math.min(green+memo[i-1][0], green+memo[i-1][2]);
            memo[i][2] = Math.min(blue+memo[i-1][0], blue+memo[i-1][1]);
        }

        System.out.println(Math.min(memo[N][0], Math.min(memo[N][1], memo[N][2])));
    }
}
