package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B11286_절댓값힙 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int input;
        absHeap heap = new absHeap(N);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            input = Integer.parseInt(in.readLine());
            if(input==0) sb.append(heap.pop()+"\n");
            else heap.push(input);
        }
        System.out.println(sb.toString());
    }


    static class absHeap {
        int[] numbers;
        int count;
        
        public absHeap(int N) {
            numbers = new int[N+1];
            count=0;
        }

        public void push(int n) {
            int num = ++count;
            numbers[num] = n;

            while(num>1) {
                if(compare(num/2, num)) {
                    swap(num, num/2);
                    num /= 2;
                }else break;
            }
        }

        public int pop() {
            if(count==0) return 0;
            int rv = numbers[1];
            swap(count--, 1);
            
            int num=1;
            int switchNode;
            while(num*2 <= count) {
                if(num*2+1 <= count) {
                    if(compare(num*2, num*2+1)) switchNode = num*2+1;
                    else                        switchNode = num*2;
                }
                else switchNode=num*2;

                if(compare(num, switchNode)) {
                    swap(num, switchNode);
                    num=switchNode;
                }
                else break;
            }

            return rv;
        }

        public boolean compare(int a, int b) {
            int aAbs = Math.abs(numbers[a]);
            int bAbs = Math.abs(numbers[b]);
            if(aAbs==bAbs) return numbers[a]>numbers[b]?true:false;
            else           return aAbs>bAbs?true:false;
        }

        public void swap(int a, int b) {
            int temp = numbers[a];
            numbers[a]=numbers[b];
            numbers[b]=temp;
        }
    }
}
