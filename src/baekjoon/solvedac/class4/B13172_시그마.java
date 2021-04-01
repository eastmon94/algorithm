package baekjoon.solvedac.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13172_시그마 {
    static final long mod = 1000000007;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int M = Integer.parseInt(in.readLine());
        long answer = 0;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            long n = Integer.parseInt(st.nextToken());
            long s = Integer.parseInt(st.nextToken());

            long gcd = gcd(n, s);
            n /= gcd;
            s /= gcd;
            answer = (answer + (s * square(mod-2, n))%mod)%mod;
            
        }
        System.out.println(answer);
    }

    static long square(long n, long num) {
        
        if(n==1) return num;

        long half = square(n/2, num);
        
        if(n%2==0) return (half * half)%mod;
        else       return ((half * half)%mod * num)%mod;
    }

    static long gcd(long a, long  b) {
        long max = Math.max(a, b);
        long min = Math.min(a, b);

        while(min!=0) {
            long temp = min;
            min = max % min;
            max = temp;
        }

        return max;
    }
}
