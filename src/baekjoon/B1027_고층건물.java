package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1027_고층건물 {
    static int N;
    static double[] input;
    static int[] combination;
    static int[] answer;
    
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());
        input = new double[N];
        answer = new int[N];
        combination = new int[2];
        st = new StringTokenizer(in.readLine());
        for(int i=0; i<N; i++) {
            input[i] = Double.parseDouble(st.nextToken());
        }

        genCombination(0, 0);

        int max = max();
        System.out.println(max);
    }

    private static void genCombination(int idx, int cur) {

        if(idx == 2) {
            int startPoint = combination[0];
            int endPoint = combination[1];
            if(endPoint - startPoint == 1) {
                answer[startPoint]++;
                answer[endPoint]++;

                return;
            }

            double gradient = (input[endPoint] - input[startPoint]) / (endPoint - startPoint);
            for(int i=startPoint+1; i<endPoint; i++) {
                if(input[i] >= input[startPoint] + gradient*(i-startPoint)) return;
            }

            answer[startPoint]++;
            answer[endPoint]++;
            return;
        }

        for(int i=cur; i<N; i++) {
            combination[idx] = i;
            genCombination(idx+1, i+1);
        }
    }

    private static int max() {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++) {
            if(max < answer[i]) max = answer[i];
        }

        return max;
    }
}
