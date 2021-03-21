package baekjoon.solvedac.class4;

import java.io.*;
import java.util.*;

public class B18119_단어암기 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] inputs = new int[N];
        for(int i=0; i<N; i++) {
            String input = in.readLine();
            int b = 0;
            for(int j=0; j<input.length(); j++) {
                b = b | (1 << input.charAt(j)-'a');
            }
            inputs[i] = b;
        }

        StringBuilder sb = new StringBuilder();

        int bitMask = 0xffffffff;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            int o = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            if(o==1) bitMask = bitMask & ~(1<<(c-'a'));
            else     bitMask = bitMask | 1<<(c-'a');

            int count = 0;
            for(int n=0; n<N; n++) {
                if((inputs[n] & bitMask)==inputs[n]) count++;
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb.toString());
    }
}
