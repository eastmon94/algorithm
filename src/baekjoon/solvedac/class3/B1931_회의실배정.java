package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B1931_회의실배정 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(in.readLine());

        int[][] times = new int[N][2];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]-o2[1]==0) return o1[0]-o2[0];
                return o1[1]-o2[1];
            }
        });

        int cEnd=Integer.MIN_VALUE, count=0;
        for(int i=0; i<N; i++) {
            if(times[i][0] >= cEnd) {
                count++;
                cEnd=times[i][1];
            }
        }

        System.out.println(count);
    }
}
