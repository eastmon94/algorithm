package baekjoon.no2771;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B3954_bf인터프리터 {
    static int M, C, I;
    static int[] data;
    static int pointer;
    static char[] input, cmd;
    static int inputNum, cmdNum;
    static int[] bracket;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());

        while(T-->0) {
            st = new StringTokenizer(in.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            I = Integer.parseInt(st.nextToken());

            data = new int[M];
            pointer = 0;
            cmd = in.readLine().toCharArray();
            input = in.readLine().toCharArray();
            inputNum = 0; cmdNum = 0;
            int cmdCnt = 0;
            Stack<Integer> s = new Stack<>();
            bracket = new int[C];
            calcLoop(s);
            while(cmdCnt++ < 50000000) {
                if(cmdNum >= C) {
                    System.out.println("Terminates");
                    break;
                }

                calc(cmd[cmdNum]);
            }

            if(cmdNum < C) {
                int loopEnd = Integer.MIN_VALUE, loopStart = Integer.MAX_VALUE;
                while(cmdCnt-- >= 0) {
                    calc(cmd[cmdNum]);
                    loopEnd = Math.max(loopEnd, cmdNum);
                    loopStart = Math.min(loopStart, cmdNum);
                }

                System.out.println("Loops "+loopStart + " " + loopEnd);
            }
        }
    }

    static void calc(char c) {
        switch(c) {
            case '-' :
                data[pointer] = (data[pointer]+255)%256;
                cmdNum++;
                break;
            case '+' :
                data[pointer] = (data[pointer]+1)%256;
                cmdNum++;
                break;
            case '<' :
                pointer = (pointer-1+M)%M;
                cmdNum++;
                break;
            case '>' :
                pointer = (pointer+1)%M;
                cmdNum++;
                break;
            case '[' :
                if(data[pointer] == 0) {
                    cmdNum = bracket[cmdNum];
                } else {
                    cmdNum++;
                }
                break;
                
            case ']' :
                if(data[pointer] != 0) {
                    cmdNum = bracket[cmdNum];
                } 
                else {
                    cmdNum++;
                }
                break;
            case '.' :
                cmdNum++;
                break;
            case ',' :
                if(inputNum < I)
                    data[pointer] = input[inputNum++];
                else 
                    data[pointer] = 255;
                cmdNum++;
                break;
        }
    }

    static void calcLoop(Stack<Integer> s) {

        for(int i=0; i<C; i++) {
            if(cmd[i] == '[') s.push(i);
            else if(cmd[i]==']') {
                int start = s.pop();
                int end = i;

                bracket[start] = end;
                bracket[end] = start;
            }
        }

        s.clear();
    }

}