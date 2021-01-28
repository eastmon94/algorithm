package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B9019_DSLR {
    static char[] visited;
    static int[] parents;
    static Queue<Integer> q;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());

        int A, B;
        visited = new char[10000];
        parents = new int[10000];
        q = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while(T-->0) {
            st = new StringTokenizer(in.readLine(), " ");
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            Arrays.fill(visited, '0');
            Arrays.fill(parents, -1);
            q.clear();
            bfs(A, B);

            stack.clear();
            int nv=B;
            while(true) {
                if(nv==A) break;
                stack.push(visited[nv]);
                nv = parents[nv]; 
            }
            while(!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static char[] list = {'D', 'S', 'L', 'R'};
    static void bfs(int A, int B) {
        q.offer(A);
        visited[A] = 'A';
        parents[A] = 0;

        int n;
        while(!q.isEmpty()) {
            n = q.poll();

            for(int d=0; d<4; d++) {
                int nn = operate(n, d);
                if(visited[nn]!='0') continue;
                q.offer(nn);
                visited[nn] = list[d];
                parents[nn] = n;

                if(nn==B) return;
            }
        }
    }

    static int operate(int n, int d) {
        switch(d) {
            case 0:
            n = (n*2)%10000;
            break;
            case 1:
            n = (n+9999)%10000;
            break;
            case 2:
            n = (n*10)%10000+(n/1000);
            break;
            case 3:
            n = n/10 + (n%10)*1000;
            break;
        }

        return n;
    }
}
