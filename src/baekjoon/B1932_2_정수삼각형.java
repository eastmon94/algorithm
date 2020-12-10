package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1932_2_정수삼각형 {
    static int N;
    static int[][] triangle;
    static int[][] memo;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());

        triangle = new int[N][N];
        memo = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for(int j=0; j<=i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
                memo[i][j] = -1;
            }
        }
        dfs(0, 0, triangle[0][0]);
        int answer = Integer.MIN_VALUE;
        for(int i=0; i<N; i++) {
            answer = Math.max(memo[N-1][i], answer);
        }

        System.out.println(answer);
    }

    static void dfs(int idx, int cnt, int sum) {
        if(memo[idx][cnt] >= sum) return;
        
        memo[idx][cnt] = Math.max(memo[idx][cnt], sum);
        
        if(idx == N-1) return;
        
        dfs(idx+1, cnt, sum+triangle[idx+1][cnt]);
        dfs(idx+1, cnt+1, sum+triangle[idx+1][cnt+1]);
    }
}
