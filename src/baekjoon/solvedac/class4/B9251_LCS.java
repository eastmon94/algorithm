package baekjoon.solvedac.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B9251_LCS {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String s1 = in.readLine();
        String s2 = in.readLine();

        int[][] memo = new int[s1.length()+1][s2.length()+1];

        for(int i=1; i<=s1.length(); i++) {
            for(int j=1; j<=s2.length(); j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)) memo[i][j] = memo[i-1][j-1]+1;
                else                               memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
                
            }
        }

        System.out.println(memo[s1.length()][s2.length()]);
    }
}
