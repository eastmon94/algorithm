package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11399_ATM {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(in.readLine());
        int[] list = new int[N];
        st = new StringTokenizer(in.readLine(), " ");
        for(int i=0; i<N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        int answer = 0;
        int time = 0;
        for(int i=0; i<N; i++) {
            time+=list[i];
            answer+=time;
        }
        System.out.println(answer);
    }
}
