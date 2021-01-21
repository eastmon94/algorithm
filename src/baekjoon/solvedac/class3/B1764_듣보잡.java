package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B1764_듣보잡 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        String input;
        for(int i=0; i<N; i++) {
            input = in.readLine();
            map.put(input, 1);
        }

        int answer=0;
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            input = in.readLine();
            if(map.get(input)==null) continue;
            answer++;
            list.add(input);
        }
        list.sort(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for(String s : list) {
            sb.append(s+"\n");
        }

        System.out.println(answer+"\n"+sb.toString());
    }
}
