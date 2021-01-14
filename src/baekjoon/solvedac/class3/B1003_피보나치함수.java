package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1003_피보나치함수 {
    static int N;
    static int[] count0;
    static int[] count1;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        count0 = new int[41];
        count1 = new int[41];
        while(T-->0) {
            N = Integer.parseInt(in.readLine());
            Arrays.fill(count0, -1);
            Arrays.fill(count1, -1);
            fibonacci0(N);
            fibonacci1(N);

            System.out.println(count0[N]+" "+count1[N]);
        }
    }

    static int fibonacci0(int n) {
        if(n==0) {
            count0[0] = 1;
            return 1;
        }
        if(n==1) {
            count0[1] = 0;
            return 0;
        }

        int n_1, n_2;
        if(count0[n-1]==-1) {
            n_1 = fibonacci0(n-1);
            count0[n-1] = n_1;
        }
        else n_1 = count0[n-1];

        if(count0[n-2]==-1) {
            n_2 = fibonacci0(n-2);
            count0[n-2] = n_2;
        }
        else n_2 = count0[n-2];
        count0[n] = n_1+n_2;
        return n_1+n_2;
    }
    static int fibonacci1(int n) {
        if(n==0) {
            count1[0] = 0;
            return 0;
        }
        if(n==1) {
            count1[1] = 1;
            return 1;
        }

        int n_1, n_2;
        if(count1[n-1]==-1) {
            n_1 = fibonacci1(n-1);
            count1[n-1] = n_1;
        }
        else n_1 = count1[n-1];

        if(count1[n-2]==-1) {
            n_2 = fibonacci1(n-2);
            count1[n-2] = n_2;
        }
        else n_2 = count1[n-2];
        count1[n] = n_1+n_2;
        return n_1+n_2;
    }
}
