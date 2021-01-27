package baekjoon.solvedac.class3;

import java.io.*;
import java.util.*;

public class B6064_카잉달력 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());

        int N, M, x, y;
        while(T-->0) {
            st = new StringTokenizer(in.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            int len = LCM(M, N);
            boolean flag = false;
            int i=x;

            for(; i<=len; i+=M) {
                if(i%N==y || (i%N==0 && y==N)) {
                    flag = true;
                    break;
                }
            }

            if(flag) System.out.println(i);
            else System.out.println(-1);
        }
    }

    static int LCM(int x, int y) {
        int n1, n2;
        if(x<y) {
            n1 = y;
            n2 = x;
        }else {
            n1 = x;
            n2 = y;
        }

        int temp;
        while(n2!=0) {
            temp = n2;
            n2 = n1%n2;
            n1 = temp;
        }

        return x*y/n1;
    }
    
}