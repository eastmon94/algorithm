package baekjoon.solvedac.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class B1918_후위표기식 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();

        Stack<Character> operator = new Stack<>();
        HashMap<Character, Integer> m = new HashMap<>();
        m.put('+', 1);m.put('-', 1);m.put('*', 2);m.put('/', 2);m.put('(', 0);
        StringBuilder answer = new StringBuilder();

        for(int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            char p;
            switch(c) {
                case '+' : case '-' : case '*' : case '/':
                while(!operator.isEmpty() && m.get(c) <= m.get(operator.peek())) {
                    answer.append(operator.pop());
                }
                operator.push(c);
                break;
                case '(' :
                operator.push(c);
                break;
                case ')':
                while((p = operator.pop())!='(') {
                    answer.append(p);
                }
                break;
                default :
                answer.append(c);
                break;
            }
        }

        while(!operator.isEmpty()) {
            answer.append(operator.pop());
        }

        System.out.println(answer.toString());
    }
}
