package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B11279_최대힙 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        maxHeap heap = new maxHeap(N);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            int input = Integer.parseInt(in.readLine());
            if(input==0) sb.append(heap.poll()+"\n");
            else heap.offer(input);
        }

        System.out.println(sb.toString());
    }

    static class maxHeap {
        int[] numbers;
        int count;

        public maxHeap(int n) {
            numbers = new int[n+1];
            count=0;
        }

        public void offer(int n) {
            int num = ++count;
            numbers[num] = n;
            while(num>1) {
                if(numbers[num/2] < numbers[num]) {
                    swap(num/2, num);
                    num /= 2;
                } else break;
            }
        }

        public int poll() {
            if(count==0) return 0;
            int rv = numbers[1];
            numbers[1] = numbers[count--];
            int c = 1;
            int switchNode;
            while(c <= count/2) {
                if(c*2+1 <= count) switchNode = numbers[c*2]>numbers[c*2+1] ? c*2 : c*2+1;
                else               switchNode = c*2;
                if(numbers[c] < numbers[switchNode]) {
                    swap(c, switchNode);
                    c=switchNode;
                } else break;
            }

            return rv;
        }

        public void swap(int a, int b) {
            int temp = numbers[a];
            numbers[a] = numbers[b];
            numbers[b] = temp;
        }
    }
}
