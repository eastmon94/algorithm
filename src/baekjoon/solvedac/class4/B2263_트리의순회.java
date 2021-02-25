package baekjoon.solvedac.class4;

import java.io.*;
import java.util.*;

public class B2263_트리의순회 {
    static StringBuilder sb;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(in.readLine());
        ArrayList<Integer> inOrder = new ArrayList<>();
        ArrayList<Integer> postOrder = new ArrayList<>();

        st = new StringTokenizer(in.readLine(), " ");
        for(int i=0; i<N; i++) {
            inOrder.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(in.readLine(), " ");
        for(int i=0; i<N; i++) {
            postOrder.add(Integer.parseInt(st.nextToken()));
        }

        sb = new StringBuilder();
        divideAndConquer(inOrder, postOrder, 0, N-1, 0, N-1);

        System.out.println(sb.toString());
    }

    static void divideAndConquer(ArrayList<Integer> inOrder, ArrayList<Integer> postOrder, int inOrderStart, int inOrderEnd, int postOrderStart, int postOrderEnd) {
        if(inOrderStart > inOrderEnd || postOrderStart > postOrderEnd) return;
        int root = postOrder.get(postOrderEnd);
        sb.append(root+" ");
        int idx = inOrder.indexOf(root);
        int len = idx-inOrderStart;
        divideAndConquer(inOrder, postOrder, inOrderStart, idx-1, postOrderStart, postOrderStart+len-1);
        divideAndConquer(inOrder, postOrder, idx+1, inOrderEnd, postOrderStart+len, postOrderEnd-1);
    }
}
