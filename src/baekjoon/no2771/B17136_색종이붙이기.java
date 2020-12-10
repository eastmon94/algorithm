package baekjoon.no2771;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17136_색종이붙이기 {
    static int[][] map;
    static int[] papers = {0, 5, 5, 5, 5, 5};
    static int paperCount = 0;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[10][10];

        for(int i=0; i<10; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for(int j=0; j<10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution();
        System.out.println(answer == Integer.MAX_VALUE?-1:answer);

    }
    private static void solution() {
        if(answer < paperCount) return;
        if(isCovered()) {
            answer = Math.min(answer, paperCount);
            return;
        }

        for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
                if(map[i][j] == 0) continue;

                for(int k=5; k>=1; k--) {
                    if(check(i, j, k) && papers[k] > 0) {
                        cover(i, j, k);
                        solution();
                        uncover(i, j, k);
                    }
                }

                return;
            }
        }
    }
    private static boolean isCovered() {
        for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
                if(map[i][j] == 1) return false;
            }
        }

        return true;
    }

    private static void uncover(int r, int c, int n) {
        for(int i=r; i<r+n; i++) {
            for(int j=c; j<c+n; j++) {
                map[i][j] = 1;
            }
        }

        papers[n]++;
        paperCount--;
    }
    private static void cover(int r, int c, int n) {
        for(int i=r; i<r+n; i++) {
            for(int j=c; j<c+n; j++) {
                map[i][j] = 0;
            }
        }

        papers[n]--;
        paperCount++;
    }

    private static boolean check(int r, int c, int n) {
        if(r+n > 10 || c+n > 10) return false;
        for(int i=r; i<r+n; i++) {
            for(int j=c; j<c+n; j++) {
                if(map[i][j] == 0) return false;
            }
        }
        
        return true;
    }
}
