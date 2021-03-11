package baekjoon.solvedac.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10830_행렬제곱 {
    static int N;
    static long B;
    static int[][] input;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        input = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for(int j=0; j<N; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] s = new int[N][N];
        int[][] e = new int[N][N];
        int[][] answer = new int[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(i==j) answer[i][j]=1;
            }
        }
        while(B>0) {
            copy(s, input);
            solution(2, B, s, e);
            answer = prod(answer, s);
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }
    }

    static int[][] prod(int[][] a, int[][] b) {
        int[][] ans = new int[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                for(int k=0; k<N; k++) {
                    ans[i][j] += a[i][k]*b[k][j];
                }

                ans[i][j] %= 1000;
            }
        }

        return ans;
    }
    static void solution(long num, long limit, int[][] s, int[][] e) {
        if(num > limit) {
            B-=num/2;
            return;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                for(int k=0; k<N; k++) {
                    e[i][j] += s[i][k]*s[k][j];
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                e[i][j] %= 1000;
                s[i][j] = e[i][j];
                e[i][j] = 0;
            }
        }

        solution(num*2, limit, s, e);
    }

    static void copy(int[][] s, int[][] e) {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                s[i][j] = e[i][j];
            }
        }
    }
}
