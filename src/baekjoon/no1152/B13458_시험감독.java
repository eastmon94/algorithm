package baekjoon.no1152;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13458_시험감독 {
    static int N, B, C;
    static int[] A;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());
        A = new int[N];
        st = new StringTokenizer(in.readLine(), " ");
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(in.readLine(), " ");
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        ////////////////////////////////////////////
        long totalCount = N;
        for(int i=0; i<N; i++) {
            int num = A[i]-B;
            if(num <= 0) continue;
            else {
                if(num%C==0) totalCount += num/C;
                else totalCount += num/C+1;
            }
        }
        System.out.println(totalCount);
    }
}
