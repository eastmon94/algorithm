package baekjoon.solvedac.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11054_가장긴바이토닉부분수열 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(in.readLine());
        int[] input = new int[N];
        int[] up = new int[N];
        int[] down = new int[N];

        st = new StringTokenizer(in.readLine(), " ");
        for(int i=0; i<N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }


        for(int i=0; i<N; i++) {
            up[i] = 1;
            for(int j=0; j<i; j++) {
                if(input[i] > input[j] && up[i] < up[j]+1) {
                    up[i] = up[j]+1;
                }
            }
        }

        for(int i=N-1; i>=0; i--) {
            down[i] = 1;
            for(int j=N-1; j>=i; j--) {
                if(input[i] > input[j] && down[i] < down[j]+1) {
                    down[i] = down[j]+1;
                }
            }
        }

        int answer = -1;
        for(int i=0; i<N; i++) {
            answer = Math.max(answer, up[i]+down[i]);
        }

        System.out.println(answer-1);
    }
}
