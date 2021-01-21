package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1927_최소힙 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int n=0; n<N; n++) {
            int i = Integer.parseInt(in.readLine());
            if(i==0) {
                if(pq.isEmpty()) sb.append(0+"\n");
                else sb.append(pq.poll()+"\n");
            }else {
                pq.offer(i);
            }
        }

        System.out.println(sb.toString());
    }
}
