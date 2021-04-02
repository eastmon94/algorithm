package baekjoon.solvedac.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B11444_피보나치수6 {
    final static long mod = 1000000007;
    static long[][] base = {{1,1}, {1,0}};
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(in.readLine());

        long[][] answer = divide(n);

        System.out.println(answer[0][1]);
    }
    static long[][] divide(long n) {
        if(n==1) {
            return base;
        }

        long[][] half = divide(n/2);

        long[][] answer = multiple(half, half);
        if(n%2==1) {
            answer = multiple(answer, base);
        }

        return answer;
    }

    static long[][] multiple(long[][] base, long[][] oper) {
        long[][] temp = new long[2][2];
        
        for(int i=0; i<2; i++) {
            for(int j=0; j<2; j++) {
                for(int k=0; k<2; k++) {
                    temp[i][j] += base[i][k]*oper[k][j];
                }

                temp[i][j] %= mod;
            }
        }

        return temp;
    }
}
