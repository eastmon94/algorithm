package baekjoon.solvedac.class5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B107_벡터매칭 {
    static int N;
    static double[][] coord;
    static boolean[] check;
    static double answer = Double.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0) {
            N = Integer.parseInt(in.readLine());
            coord = new double[N][2];
            check = new boolean[N];
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                for(int j=0; j<2; j++) {
                    coord[i][j] = Double.parseDouble(st.nextToken());
                }
            }
            answer = Double.MAX_VALUE;
            combination(0, 0);
            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString());

    }

    static void combination(int idx, int cur) {

        if(idx==N/2) {
            answer = Math.min(calc(), answer);

            return;
        }

        for(int i=cur; i<N; i++) {
            check[i] = true;
            combination(idx+1, i+1);
            check[i] = false;
        }
    }
    
    static double calc() {
        double[][] coordSum = new double[2][2];
        for(int i=0; i<N; i++) {
            if(check[i]) {
                coordSum[0][0]+=coord[i][0];
                coordSum[0][1]+=coord[i][1];
            } else {
                coordSum[1][0]+=coord[i][0];
                coordSum[1][1]+=coord[i][1];
            }
        }

        double dist = Math.sqrt(Math.pow(coordSum[0][0]-coordSum[1][0], 2)+Math.pow(coordSum[0][1]-coordSum[1][1], 2));
        return dist;
    }
}
