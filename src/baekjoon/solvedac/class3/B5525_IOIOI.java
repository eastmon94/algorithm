package baekjoon.solvedac.class3;

import java.io.*;

public class B5525_IOIOI {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int M = Integer.parseInt(in.readLine());
        String input = in.readLine();

        int count=0;
        int answer=0;
        int i=0;
        while(i<M-2) {
            if(input.charAt(i)=='I'&&input.charAt(i+1)=='O'&&input.charAt(i+2)=='I') {
                int j=i;
                for(; j<M-2; j+=2) {
                    if(input.charAt(j)=='I'&&input.charAt(j+1)=='O'&&input.charAt(j+2)=='I') {
                        count++;
                    }else {
                        break;
                    }
                }

                if(count-N+1>0)answer+=(count-N+1);
                count=0;
                i=j;
            }
            i++;

        }

        System.out.println(answer);
    }
}
