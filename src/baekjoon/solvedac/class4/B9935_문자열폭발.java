package baekjoon.solvedac.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class B9935_문자열폭발 {
    static char[] str;
    static char[] burst;
    static LinkedList<Character> ls;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        str = in.readLine().toCharArray();
        burst = in.readLine().toCharArray();


        solution();
        StringBuilder sb = new StringBuilder();
        if(ls.size()==0) {
            sb.append("FRULA");
        } else {
            for(char c : ls) {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());

    }

    static void solution() {
        ls = new LinkedList<>();
        int bLen = burst.length;
        for(int i=0; i<str.length; i++) {
            boolean flag = false;
            ls.add(str[i]);
            if(str[i]==burst[bLen-1]) {
                for(int j=ls.size()-burst.length, k=0; j<ls.size(); j++, k++) {
                    if(j<0 || ls.get(j)!=burst[k]) flag = true;
                }

                if(!flag) {
                    for(int n=0; n<bLen; n++) {
                        ls.remove(ls.size()-1);
                    }
                }
            }

        }
    }
}
