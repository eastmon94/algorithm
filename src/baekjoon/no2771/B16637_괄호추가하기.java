package baekjoon.no2771;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class B16637_괄호추가하기 {
    static int operandNum;
    static String expression;
    static boolean[] subset;
    static Deque<Integer> operand;
    static Deque<Character> operator;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(in.readLine());
        expression = in.readLine();

        operandNum = N/2+1;
        operand = new ArrayDeque<>();
        operator = new ArrayDeque<>();
        for(int i=0; i<expression.length(); i++) {
            char c = expression.charAt(i);
            if(i%2==0) operand.offerLast(Character.getNumericValue(c));
            else operator.offerLast(c);
        }

        subset = new boolean[operandNum];

        dfs(0);
        System.out.println(answer);
    }

    static void dfs(int idx) {

        if(idx == operandNum) {
            int num = solve();
            answer = answer > num ? answer : num;
            return;
        }

        subset[idx] = true;
        dfs(idx+1);
        subset[idx] = false;
        dfs(idx+1);
    }

    static int solve() {
        Deque<Integer> tempOperand = new ArrayDeque<>();
        Deque<Character> tempOperator = new ArrayDeque<>();
        for(int i=0; i<subset.length; i++) {
            if(!subset[i]) {
                tempOperand.add(operand.pollFirst());
                tempOperator.add(operator.pollFirst());
            } else {
                int num1 = 0;
                int num2 = 0;
                int num = 0;
                char oper = operator.pollFirst();
                if(i>0 && subset[i-1]) {
                    num1 = tempOperand.pollLast();
                    num2 = operand.pollFirst();
                } else {
                    num1 = operand.pollFirst();
                    num2 = operand.pollFirst();
                }
                switch(oper) {
                    case '+' :
                        num = num1+num2;
                        break;
                    case '-' :
                        num = num1-num2;
                        break;
                    case '*' :
                        num = num1 * num2;
                        break;
                }

                tempOperand.addLast(num);
            }
        }

        while(tempOperand.size() > 1) {
            int num1 = tempOperand.pollFirst();
            int num2 = tempOperand.pollFirst();
            int num = 0;
            char oper = tempOperator.pollFirst();
            switch(oper) {
                case '+' :
                    num = num1+num2;
                    break;
                case '-' :
                    num = num1-num2;
                    break;
                case '*' :
                    num = num1 * num2;
                    break;
            }

            tempOperand.addLast(num);
        }

        return tempOperand.pollFirst();
    }
}
