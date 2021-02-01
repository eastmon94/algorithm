package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11047_동전0 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];
        for(int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(in.readLine());
        }

        int count=0;
        for(int i=N-1; i>=0; i--) {
            count+=(K/numbers[i]);
            K %= numbers[i];
        }

        System.out.println(count);
    }
    
}