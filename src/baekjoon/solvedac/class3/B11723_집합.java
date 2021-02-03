package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11723_집합 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int M = Integer.parseInt(in.readLine());
        boolean[] set = new boolean[20];
        String oper;
        int input;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            oper = st.nextToken();
            if(oper.equals("all")) {
                Arrays.fill(set, true);
                continue;
            }
            if(oper.equals("empty")) {
                Arrays.fill(set, false);
                continue;
            }
            input=Integer.parseInt(st.nextToken())-1;
            if(oper.equals("add")) {
                set[input] = true;                
            } else if(oper.equals("remove")) {
                set[input] = false;
            }else if(oper.equals("check")) {
                if(set[input]) sb.append("1\n");
                else sb.append("0\n");
            }else if(oper.equals("toggle")) {
                set[input] = set[input]?false:true;
            }
        }

        System.out.print(sb.toString());
    }
}
