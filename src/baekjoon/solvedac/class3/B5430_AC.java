package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B5430_AC {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(in.readLine());

        String func, input;
        String[] temp;
        int[] numbers;
        int n;
        StringBuilder sb = new StringBuilder();
        L:while(T-->0) {
            func = in.readLine();
            n = Integer.parseInt(in.readLine());
            input = in.readLine();
            input = input.replace('[', ' ').replace(']', ' ').trim();
            temp = input.split(",");
            numbers = new int[n];
            if(n>0) {
                for(int i=0; i<n; i++) {
                    numbers[i] = Integer.parseInt(temp[i]);
                }
            }

            boolean reverse = false;
            int startPoint=0, endPoint=n-1;

            char c;
            for(int i=0; i<func.length(); i++) {
                c=func.charAt(i);
                switch(c) {
                    case 'R':
                    reverse=reverse?false:true;
                    break;
                    case 'D':
                    if(reverse) {
                        endPoint--;
                    }else {
                        startPoint++;
                    }
                    break;
                }
                if(startPoint - endPoint >= 2) {
                    sb.append("error\n");
                    continue L;
                }
            }

            sb.append('[');
            if(reverse) {
                for(int i=endPoint; i>=startPoint; i--) {
                    sb.append(numbers[i]);
                    if(i!=startPoint) sb.append(',');
                }
            }else {
                for(int i=startPoint; i<=endPoint; i++) {
                    sb.append(numbers[i]);
                    if(i!=endPoint) sb.append(',');
                }   
            }
            sb.append("]\n");

        }
        System.out.println(sb.toString());
    }
}
