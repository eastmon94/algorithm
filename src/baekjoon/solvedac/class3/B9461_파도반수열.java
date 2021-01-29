package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B941_파도반수열 {
    static long[] numbers;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(in.readLine());

        int N;
        numbers = new long[101];
        numbers[1]=1;
        numbers[2]=1;
        numbers[3]=1;
        numbers[4]=2;
        numbers[5]=2;
        numbers[6]=3;
        numbers[7]=4;
        numbers[8]=5;
        numbers[9]=7;
        numbers[10]=9;
        for(int i=11; i<=100; i++) {
            numbers[i] = numbers[i-1]+numbers[i-5];
        }
        while(T-->0) {
            N = Integer.parseInt(in.readLine());
            System.out.println(numbers[N]);
        }
    }
}
