package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11047_동전0 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] list = new int[N];
        for(int i=0; i<N; i++) list[i] = Integer.parseInt(in.readLine());
        
        int[] ans = new int[K+1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = 0;

        for(int i=0; i<N; i++) {
            
            for(int j=list[i]; j<=K; j++) {
                if(ans[j] > ans[j - list[i]] + 1) ans[j] = ans[j-list[i]]+1;
            }
        }

        System.out.println(ans[K]);
    }
}
