package baekjoon.solvedac.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class B1043_거짓말 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] input = new ArrayList[M];

        String truth = in.readLine();
        int answer = M;
        if(truth.charAt(0)=='0') ;
        else {
            TreeSet<Integer> ts = new TreeSet<>();
            String[] temp = truth.split(" ");
            int num = Integer.parseInt(temp[0]);
            for(int i=1; i<=num; i++) {
                ts.add(Integer.parseInt(temp[i]));
            }

            for(int i=0; i<M; i++) {
                input[i] = new ArrayList<>();
                st = new StringTokenizer(in.readLine(), " ");
                num = Integer.parseInt(st.nextToken());
                for(int n=0; n<num; n++) {
                    input[i].add(Integer.parseInt(st.nextToken()));
                }
            }

            for(int i=0; i<M; i++) {
                for(int j=0; j<M; j++) {
                    ArrayList<Integer> ls = input[j];
                    int size = ls.size();
                    for(int k=0; k<size; k++) {
                        if(ts.contains(ls.get(k))) {
                            for(int l=0; l<size; l++) {
                                ts.add(ls.get(l));
                            }
                            break;
                        }
                    }
                }
            }

            for(int i=0; i<M; i++) {
                for(int ps : input[i]) {
                    if(ts.contains(ps)) {
                        answer--;
                        break;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
