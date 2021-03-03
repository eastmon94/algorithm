package baekjoon.solvedac.class4;

import java.io.*;
import java.util.*;

public class B5639_이진검색트리 {
    static ArrayList<Integer> preOrder;
    static ArrayList<Integer> inOrder;
    static StringBuilder sb;
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        preOrder = new ArrayList<>();
        inOrder = new ArrayList<>();
        sb = new StringBuilder();
        while(true) {
            try {
                int n = Integer.parseInt(in.readLine());
                preOrder.add(n);
            }catch(Exception e) {
                break;
            }
        }

        for(int n : preOrder) {
            inOrder.add(n);
        }

        inOrder.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        int size = preOrder.size();
        dfs(0, size-1, 0, size-1);
        System.out.println(sb.toString());
    }

    static void dfs(int preStart, int preEnd, int inStart, int inEnd) {
        if(preStart>preEnd || inStart>inEnd) return;
        int midVal = preOrder.get(preStart);

        int midIndex = inOrder.indexOf(midVal);
        int len = midIndex-inStart;
        dfs(preStart+1, preStart+len, inStart, inStart+len-1);
        dfs(preStart+len+1, preEnd, midIndex+1, inEnd);
        
        sb.append(midVal+"\n");
    }
    
}