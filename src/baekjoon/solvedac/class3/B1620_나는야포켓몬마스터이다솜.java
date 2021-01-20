package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B1620_나는야포켓몬마스터이다솜 {
    static int N, M;
    static String[] pokemons;
    static Map<String, Integer> map;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        pokemons = new String[N+1];
        String input;
        for(int i=1; i<=N; i++) {
            input = in.readLine();
            pokemons[i] = input;
            map.put(input, i);
        }

        StringBuilder sb = new StringBuilder();
        String problem;
        for(int m=0; m<M; m++) {
            problem = in.readLine();
            if('0'<=problem.charAt(0) && problem.charAt(0) <= '9') {
                int num=0, digit=1;
                for(int s=problem.length()-1; s>=0; s--) {
                    num += (problem.charAt(s)-'0')*digit;
                    digit*=10;
                }
                sb.append(pokemons[num]+"\n");
            }else {
                sb.append(map.get(problem)+"\n");
            }
        }

        System.out.println(sb.toString());
    }
}
