package baekjoon.solvedac.class4;

import java.io.*;
import java.util.*;

public class B1991_트리순회 {
    static StringBuilder sb;
    static Node[] tree;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(in.readLine());
        tree = new Node[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            char node = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree[node-'A'] = new Node(node, left, right);
        }

        sb = new StringBuilder();
        preorder(tree[0]);
        sb.append("\n");
        inorder(tree[0]);
        sb.append("\n");
        postorder(tree[0]);

        System.out.println(sb.toString());
    }

    static void preorder(Node node) {
        if(node==null) return;
        sb.append(node.n);
        if(node.left!='.')  preorder(tree[node.left-'A']);
        if(node.right!='.') preorder(tree[node.right-'A']);
    }

    static void inorder(Node node) {
        if(node==null) return;
        if(node.left!='.')  inorder(tree[node.left-'A']);
        sb.append(node.n);
        if(node.right!='.') inorder(tree[node.right-'A']);
    }

    static void postorder(Node node) {
        if(node==null) return;
        if(node.left!='.')  postorder(tree[node.left-'A']);
        if(node.right!='.') postorder(tree[node.right-'A']);
        sb.append(node.n);
    }

    static class Node {
        char n, left, right;

        public Node(char n, char left, char right) {
            this.n=n;
            this.left = left;
            this.right = right;
        }
    }
}