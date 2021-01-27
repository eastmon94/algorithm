package baekjoon.solvedac.class3;

import java.io.*;
import java.util.*;

public class B7662_이중우선순위큐 {
    static TreeMap<Integer, Integer> map;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();

        map = new TreeMap<>();
        while(T-->0) {
            int K = Integer.parseInt(in.readLine());
            map.clear();
            for(int k=0; k<K; k++) {
                st = new StringTokenizer(in.readLine(), " ");
                char o = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());
                if(o=='I') {
                    if(map.get(num)==null) map.put(num, 1);
                    else map.replace(num, map.get(num)+1);
                }else {
                    if(map.size()==0)  continue;

                    int key;
                    if(num==1) key = map.lastKey();
                    else       key = map.firstKey();

                    if(map.get(key)==1) map.remove(key);
                    else map.replace(key, map.get(key)-1);
                }
            }

            if(map.isEmpty()) sb.append("EMPTY\n");
            else sb.append(map.lastKey()+" "+map.firstKey()+"\n");
        }

        System.out.println(sb.toString());
    }
}
