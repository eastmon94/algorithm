package baekjoon.solvedac.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1016_제곱ㄴㄴ수 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        int count = (int)(max-min+1);

        boolean[] number = new boolean[1000001];

        for(int i=2; i*i<1000001; i++) {
            for(int j=i; j*i<1000001; j++) {
                number[i*j]=true;
            }
        }

        ArrayList<Long> list = new ArrayList<>();
        for(int i=2; i<1000001; i++) {
            if(number[i]) continue;
            list.add((long)i*i);
        }

        boolean[] check = new boolean[count+1];

        for(long sq : list) {
            if(sq > max) break;
            long start = min/sq;
            for(long s=start*sq; s<=max; s+=sq) {
                if(s<min) continue;
                int t = (int)(s-min+1);
                check[t] = true;
            }
        }

        int answer = count;
        for(int i=1; i<=count; i++) {
            if(check[i]) answer--;
        }

        System.out.println(answer);
    } 
}
