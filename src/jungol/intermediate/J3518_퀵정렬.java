package jungol.intermediate;

import java.io.*;
import java.util.*;

public class J3518_퀵정렬 {
    static int[] arr;
    static int N;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());
        st = new StringTokenizer(in.readLine(), " ");

        arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sb = new StringBuilder();
        quickSort(0, N-1);

        System.out.println(sb.toString());
    }

    static void quickSort(int low, int high) {
        if(low >= high) return;

        int pivot = arr[high];
        int i=low;
        for(int j=low; j<high; j++) {
            if(arr[j] < pivot) {
                swap(i++, j);
            }
        }

        swap(i, high);

        for(int n=0; n<N; n++) {
            sb.append(arr[n]+" ");
        }
        sb.append("\n");
        quickSort(low, i-1);
        quickSort(i+1, high);
    }

    static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}