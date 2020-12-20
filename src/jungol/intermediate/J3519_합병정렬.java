package jungol.intermediate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J3519_합병정렬 {
    static int N;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        N = Integer.parseInt(in.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        st = new StringTokenizer(in.readLine(), " ");
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(A, 0, N-1, B);
        System.out.print(sb.toString());
    }

    public static void mergeSort(int[] A, int low, int high, int[] B) {
        if(low >= high) return;

        int mid = (low+high)/2;
        mergeSort(A, low, mid, B);
        mergeSort(A, mid+1, high, B);

        int num1 = low, num2 = mid+1;
        for(int k=low; k<=high; k++) {
            if(num1 > mid) {
                B[k] = A[num2++];
            } else if(num2 > high) {
                B[k] = A[num1++];
            } else if(A[num1] > A[num2]) {
                B[k] = A[num2++];
            } else if(A[num1] <= A[num2]) {
                B[k] = A[num1++];
            }
        }

        for(int i=low; i<=high; i++) {
            A[i] = B[i];
        }
        for(int i=0; i<N; i++) {
            sb.append(A[i] + " ");
        }
        sb.append("\n");
    }
}