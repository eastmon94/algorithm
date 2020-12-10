package baekjoon.no1152;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15686_치킨배달 {
    static int N, M, chickenNum;
    static ArrayList<Pair> houses;
    static ArrayList<Pair> chickens;
    static int[] combination;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        houses = new ArrayList<>();
        chickens = new ArrayList<>();
        int input;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for(int j=0; j<N; j++) {
                input = Integer.parseInt(st.nextToken());
                if(input == 1) houses.add(new Pair(i, j));
                if(input == 2) {
                    chickens.add(new Pair(i, j));
                    chickenNum++;
                }
            }
        }
        combination = new int[M];
        Arrays.fill(combination, -1);
        for(int i=1; i<=M; i++) {
            combination(0, 0, i);
        }
        System.out.println(answer);

    }

    static void combination(int idx, int cur, int num) {

        if(idx == num) {
            int dist = solution(num);
            answer = Math.min(dist, answer);
            return;
        }

        for(int i=cur; i<chickenNum; i++) {
            combination[idx] = i;
            combination(idx+1, i+1, num);
        }
    }

    static int solution(int num) {
        int totalDist = 0;
        for(Pair p : houses) {
            int dist = Integer.MAX_VALUE;
            for(int i=0; i<num; i++) {
                if(combination[i] == -1)  return Integer.MAX_VALUE;
                
                Pair c = chickens.get(combination[i]);
                dist = Math.min(dist, Math.abs(p.n - c.n) + Math.abs(p.r - c.r));
                
            }
            totalDist += dist;
        }


        return totalDist;
    }

    static class Pair {
        int n, r;
        public Pair(int n, int r) {
            this.n = n;
            this.r = r;
        }
    }
}
