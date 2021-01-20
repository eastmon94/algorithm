package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B1541_잃어버린괄호 {
    static String input;
    static ArrayList<Integer> operand;
    static ArrayList<Character> operator;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        input = in.readLine();
        operator = new ArrayList<>();
        operand  = new ArrayList<>();

        int size = input.length();
        int num = 0, digit=1;

        for(int i=size-1; i>=0; i--) {
            char c = input.charAt(i);
            if(c=='+' || c=='-') {
                operator.add(c);
                operand.add(num);
                num=0; digit=1;
            } else {
                num += (c-'0')*digit;
                digit*=10;
            }

            if(i==0) operand.add(num);
        }

        size = operator.size();
        int point = -1;
        for(int i=size-1; i>=0; i--) {
            if(operator.get(i)=='+') continue;
            point = i;
            break;
        }

        int answer = operand.get(operand.size()-1);
        for(int i=operand.size()-2; i>point; i--) {
            answer += operand.get(i);
        }
        for(int i=point; i>=0; i--) {
            answer -= operand.get(i);
        }

        System.out.println(answer);
    }
}
