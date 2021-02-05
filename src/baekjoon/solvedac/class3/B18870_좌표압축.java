package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B18870_좌표압축 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(in.readLine());
        st = new StringTokenizer(in.readLine(), " ");

        int[] numbers = new int[N];
        int[] sortedNum = new int[N];
        int[] counts = new int[N];
        int input;
        for(int i=0; i<N; i++) {
            input = Integer.parseInt(st.nextToken());
            numbers[i]=input;
            sortedNum[i]=input;
        }
        Arrays.sort(sortedNum);
        HashMap<Integer, Integer> map = new HashMap<>();
        int prevNum = sortedNum[0];
        int count=0;
        for(int i=1; i<N; i++) {
            if(sortedNum[i]!=prevNum) count++;
            counts[i]=count;
            prevNum=sortedNum[i];
        }

        for(int i=0; i<N; i++) {
            map.put(sortedNum[i], counts[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            sb.append(map.get(numbers[i])+" ");
        }
        
        System.out.println(sb.toString());
    }
    
}