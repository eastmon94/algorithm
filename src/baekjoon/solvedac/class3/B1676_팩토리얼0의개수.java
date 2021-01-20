package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1676_팩토리얼0의개수 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        int answer = 0;
        for(int i=5; i<=N; i+=5) {
            int n = i, count=0;
            while(n%5==0) {
                n/=5;
                count++;
            }
            answer += count;
        }
        System.out.println(answer);
    }
}
