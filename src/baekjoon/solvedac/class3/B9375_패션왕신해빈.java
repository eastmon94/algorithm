package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B9375_패션왕신해빈 {
    static HashMap<String, Integer> map;
    static ArrayList<String> list;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());

        int N;
        map = new HashMap<>();
        list= new ArrayList<>();
        long answer=0;
        while(T-->0) {
            N = Integer.parseInt(in.readLine());
            map.clear();
            list.clear();
            String i1, i2;
            answer=1;
            for(int n=0; n<N; n++) {
                st = new StringTokenizer(in.readLine(), " ");
                i1 = st.nextToken();
                i2 = st.nextToken();
                if(map.get(i2)==null) {
                    map.put(i2, 1);
                    list.add(i2);
                }
                else map.replace(i2, map.get(i2)+1);
            }

            for(String key:list) {
                answer *= (map.get(key)+1);
            }
            System.out.println(--answer);
        }

    }
}
