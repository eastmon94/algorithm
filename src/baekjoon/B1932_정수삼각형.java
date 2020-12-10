package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1932_정수삼각형 {
    static int N;
    static int answer = Integer.MIN_VALUE;
    static int[][] memo;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());
        list = new ArrayList[N];
        memo = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            list[i] = new ArrayList<>();
            for(int j=0; j<=i; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        memo[0][0] = list[0].get(0);
        for(int i=1; i<N; i++) {
            for(int j=0; j<=i; j++) {
                int n = list[i].get(j);
                if(j==0) {
                    memo[i][j] = memo[i-1][j] + n;
                } else if(j==i) {
                    memo[i][j] = memo[i-1][j-1] + n;
                } else {
                    int t1 = memo[i-1][j-1] + n;
                    int t2 = memo[i-1][j] + n;

                    memo[i][j] = t1 < t2 ? t2 : t1;
                }
            }
        }
        int answer = Integer.MIN_VALUE;
        for(int i=0; i<N; i++) {
            if(answer < memo[N-1][i]) answer = memo[N-1][i];
        }
        System.out.println(answer);
    }
}
