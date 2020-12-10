package baekjoon.no2771;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B17406_배열돌리기4 {
    static int N, M, K;
    static int[][] map;
    static Number[] numbers;
    static int[] permutations;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        numbers = new Number[K];
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            numbers[i] = new Number(Integer.parseInt(st.nextToken()),
            Integer.parseInt(st.nextToken()),
            Integer.parseInt(st.nextToken()));
        }
        
        permutations = new int[K];
        permutation(0, 0);
        System.out.println(answer);
    }

    static void permutation(int idx, int flag) {

        if(idx == K) {
            int num = solve();
            answer = answer < num ? answer : num;
            return;
        }

        for(int i=0; i<K; i++) {
            if((1<<i&flag) != 0) continue;

            permutations[idx] = i;
            permutation(idx+1, 1<<i|flag);
        }
    }

    static int solve() {
        int[][] A = new int[N][M];
        for(int i=0; i<N; i++) {
            A[i] = Arrays.copyOf(map[i], map[i].length);
        }

        for(int i=0; i<K; i++) {
            rotate(A, i);
        }

        int num = Integer.MAX_VALUE;
        for(int i=0; i<N; i++) {
            int temp = 0;
            for(int j=0; j<M; j++) {
                temp+=A[i][j];
            }
            num = num < temp ? num : temp;
        }
        return num;
    }
    // 오른쪽 아래 왼쪽 위
    static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0}; 
    static void rotate(int[][] A, int n) {
        Number number = numbers[permutations[n]];
        int r = number.r;
        int c = number.c;
        int s = number.s;

        for(int i=0; i<s; i++) {
            int d=0;
            int curRow = r-s-1+i, curCol = c-s-1+i;
            int curValue = A[curRow][curCol];
            int newRow, newCol, newValue;
            do {
                if(r-s-1+i > curRow+dr[d] || r+s-1-i < curRow+dr[d] 
                    || c-s-1+i > curCol+dc[d] || c+s-1-i < curCol+dc[d]) d = (d+1)%4;
                newRow = curRow+dr[d];
                newCol = curCol+dc[d];
                newValue = A[newRow][newCol];
                A[newRow][newCol] = curValue;
                curValue = newValue;
                curRow = newRow;
                curCol = newCol;
            } while(curRow != r-s-1+i || curCol != c-s-1+i);
        }
    }

    static class Number {
        int r, c, s;

        public Number(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        } 
    }
}
