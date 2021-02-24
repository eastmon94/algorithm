package baekjoon.solvedac.class4;

import java.io.*;
import java.util.*;

public class B2095_내려가기 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(in.readLine());
        int[][] numbers = new int[N][3];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for(int j=0;j<3; j++) {
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] max = new int[N][3];
        int[][] min = new int[N][3];

        for(int i=0; i<3; i++) {
            max[0][i] = numbers[0][i];
            min[0][i] = numbers[0][i];
        }

        for(int i=1; i<N; i++) {
            max[i][0] = Math.max(numbers[i][0]+max[i-1][0], numbers[i][0]+max[i-1][1]);
            max[i][2] = Math.max(numbers[i][2]+max[i-1][2], numbers[i][2]+max[i-1][1]);
            max[i][1] = Math.max(numbers[i][1]+max[i-1][0], Math.max(numbers[i][1]+max[i-1][1], numbers[i][1]+max[i-1][2]));
            
            min[i][0] = Math.min(numbers[i][0]+min[i-1][0], numbers[i][0]+min[i-1][1]);
            min[i][2] = Math.min(numbers[i][2]+min[i-1][2], numbers[i][2]+min[i-1][1]);
            min[i][1] = Math.min(numbers[i][1]+min[i-1][0], Math.min(numbers[i][1]+min[i-1][1], numbers[i][1]+min[i-1][2]));
        }

        System.out.println(Math.max(max[N-1][0], Math.max(max[N-1][1], max[N-1][2]))+" "+Math.min(min[N-1][0], Math.min(min[N-1][1], min[N-1][2])));
    }
}
