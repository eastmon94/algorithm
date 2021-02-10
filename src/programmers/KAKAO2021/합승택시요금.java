package programmers.KAKAO2021;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        final int INF = Integer.MAX_VALUE;
        int[][] map = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i==j) continue;
                map[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for(int i=0; i<fares.length; i++) {
            int v1 = fares[i][0], v2 = fares[i][1], e=fares[i][2];
            map[v1][v2]=e;
            map[v2][v1]=e;
        }
        
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                if(k==i) continue;
                for(int j=1; j<=n; j++) {
                    if(j==i || j==k) continue;
                    if(map[i][k]!=INF && map[k][j]!=INF &&
                       map[i][j] > map[i][k]+map[k][j]) {
                        map[i][j] = map[i][k]+map[k][j];
                    }
                }
            }
        }
        
        answer = Integer.MAX_VALUE;
        for(int k=1; k<=n; k++) {
            if(map[s][k]==INF || map[k][a]==INF || map[k][b]==INF) continue;
            answer = Math.min(answer, map[s][k]+map[k][a]+map[k][b]);
        }
        
        
        return answer;
    }
}