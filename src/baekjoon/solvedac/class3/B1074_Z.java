package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1074_Z {
    static int N, R, C, count;
    static boolean flag;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        dfs(0, (int)Math.pow(2, N)-1, 0, (int)Math.pow(2, N)-1);
        System.out.println(count-1);
    }

    static void dfs(int rStart, int rEnd, int cStart, int cEnd) {
        if(flag) return;
        if(rStart==rEnd && cStart==cEnd) {
            count++;
            if(rStart==R && cStart==C) {
                flag = true;
            }


            return;
        }
        if(rStart <= R && R <= rEnd && cStart <= C && C <= cEnd) {
            int rMid = (rStart + rEnd)/2;
            int cMid = (cStart + cEnd)/2;
            
            dfs(rStart, rMid, cStart, cMid);
            dfs(rStart, rMid, cMid+1, cEnd);
            dfs(rMid+1, rEnd, cStart, cMid);
            dfs(rMid+1, rEnd, cMid+1, cEnd);
        } else {
            count += (rEnd-rStart+1)*(rEnd-rStart+1);
        }

    }
}
