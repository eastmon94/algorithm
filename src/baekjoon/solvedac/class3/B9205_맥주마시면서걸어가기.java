package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B9205_맥주마시면서걸어가기 {
    static Queue<Pair> q;
    static Pair[] cList;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        q = new LinkedList<>();
        cList = new Pair[100];
        visited = new boolean[100];
        while(T-->0) {
            int n = Integer.parseInt(in.readLine());
            st = new StringTokenizer(in.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Pair start = new Pair(x, y);
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                cList[i] = new Pair(x, y);
            }
            Arrays.fill(visited, false);

            st = new StringTokenizer(in.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            Pair festival = new Pair(x, y);

            q.clear();
            if(bfs(start, festival, n)) sb.append("happy\n");
            else sb.append("sad\n");
        }

        System.out.print(sb.toString());

    }

    static boolean bfs(Pair start, Pair festival, int n) {
        q.offer(start);

        while(!q.isEmpty()) {
            Pair p = q.poll();
            if(Math.abs(p.r-festival.r)+Math.abs(p.c-festival.c)<=1000) return true;
            
            for(int i=0; i<n; i++) {
                Pair np = cList[i];
                if(visited[i] || Math.abs(p.r-np.r)+Math.abs(p.c-np.c)>1000) continue;
                q.offer(np);
                visited[i] = true;
            }
        }

        return false;
    }

    static class Pair {
        int r, c;
        public Pair(int r, int c) {
            this.r=r;
            this.c=c;
        }
    }
}
