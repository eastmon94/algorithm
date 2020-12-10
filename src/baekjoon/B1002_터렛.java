package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1002_터렛 {
    static int T;
    static int count;
    public static void main(String args[]) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(in.readLine());

        while(T-->0) {
            st = new StringTokenizer(in.readLine());
            count = 0;
            int x1, y1, x2, y2;
            double r1, r2;
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            r1 = Double.parseDouble(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            r2 = Double.parseDouble(st.nextToken());

            double d = distance(x1, y1, x2, y2);
            double r = r1 + r2;
            if(d == 0) {
                if(r1 == r2) count = -1;
                else count = 0;
            }else if(d > r) {
                count = 0;
            }else if(d < r) {
                double max = r1>=r2 ? r1 : r2;
                double min = r1< r2 ? r1 : r2;
                if(min+d < max) count = 0;
                else if(min+d > max) count = 2;
                else count = 1;
            }else {
                count = 1;
            }

            System.out.println(count);
        }
    }

    private static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
    }
}