package baekjoon.no1152;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14890_경사로 {
    static int N, L;
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int r=0; r<N; r++) {
            st = new StringTokenizer(in.readLine(), " ");
            for(int c=0; c<N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution());
    }

    static int solution() {
        int count = 0;
        //행
        for(int r=0; r<N; r++) {
            if(calcRow(r)){
                count++;
            }
        }

        //열
        for(int c=0; c<N; c++) {
            if(calcCol(c)) {
                count++;
            }
        }

        return count;
    }

    static boolean calcRow(int r) {
        boolean[][] check = new boolean[N][N];
        for(int c=0; c<N-1; c++) {
            if(map[r][c]-map[r][c+1] == 0) continue;
            else if(map[r][c]-map[r][c+1] == 1) { //forward
                
                for(int l=c+1; l<=c+L; l++) {
                    if(l>=N) return false;
                    if(map[r][c+1] == map[r][l]) {
                        if(check[r][l]) return false;

                        check[r][l] = true;
                        continue;
                    }
                    else return false;
                }

            } else if(map[r][c]-map[r][c+1] == -1) { //backward
                for(int l=c; l>c-L; l--) {
                    if(l<0) return false;
                    if(map[r][c] == map[r][l]) {
                        if(check[r][l]) return false;

                        check[r][l] = true;
                        continue;
                    }
                    else return false;
                }

            }else {
                return false;
            }
        }

        return true;
    }

    static boolean calcCol(int c) {
        boolean[][] check = new boolean[N][N];
        for(int r=0; r<N-1; r++) {
            if(map[r][c]-map[r+1][c] == 0) continue;
            else if(map[r][c]-map[r+1][c] == 1) { //forward
                
                for(int l=r+1; l<=r+L; l++) {
                    if(l>=N) return false;
                    if(map[r+1][c] == map[l][c]) {
                        if(check[l][c]) return false;

                        check[l][c] = true;
                        continue;
                    }
                    else return false;
                }

            } else if(map[r][c]-map[r+1][c] == -1) { //backward
                for(int l=r; l>r-L; l--) {
                    if(l<0) return false;
                    if(map[r][c] == map[l][c]) {
                        if(check[l][c]) return false;

                        check[l][c] = true;
                        continue;
                    }
                    else return false;
                }

            }else {
                return false;
            }
        }

        return true;
    }
}
