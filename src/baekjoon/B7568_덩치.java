package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B7568_덩치 {
    static int N;
    static int[] numbers;
    static int[][] men;
    static int[] memo;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());
        men = new int[N][2];
        numbers = new int[2];
        memo = new int[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(in.readLine());
            men[i][0] = Integer.parseInt(st.nextToken());
            men[i][1] = Integer.parseInt(st.nextToken());
        }

        combination(0, 0);
        for(int i=0; i<N; i++) {
            System.out.print( (memo[i]+1) + " ");
        }
    }

    private static void combination(int idx, int cur) {

        if(idx == 2) {
            if(men[numbers[0]][0] > men[numbers[1]][0] && men[numbers[0]][1] > men[numbers[1]][1]) {
                memo[numbers[1]]++;
            }else if(men[numbers[0]][0] < men[numbers[1]][0] && men[numbers[0]][1] < men[numbers[1]][1]) {
                memo[numbers[0]]++;
            }

            return;
        }

        for(int i=cur; i<N; i++) {
            numbers[idx] = i;
            combination(idx + 1, i + 1);
        }
    }
}
