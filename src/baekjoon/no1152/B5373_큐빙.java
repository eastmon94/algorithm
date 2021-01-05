package baekjoon.no1152;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B5373_큐빙 {
    static int N;
    static String[] input;
    static char[][][] cube;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());
        cube = new char[6][3][3];
        input = new String[1000];
        StringBuilder sb = new StringBuilder();
        while(T-->0) {
            N = Integer.parseInt(in.readLine());
            st = new StringTokenizer(in.readLine(), " ");
            for(int n=0; n<N; n++) {
                input[n] = st.nextToken();
            }
            init();
            simulate();
            for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++) {
                    sb.append(cube[0][i][j]);
                }
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    static void simulate() {
        for(int n=0; n<N; n++) {
            char side = input[n].charAt(0);
            char d = input[n].charAt(1);
            char t1, t2, t3;
            rotate(side, d);
            switch(side) {
                case 'U':
                if(d=='+') {
                    t1 = cube[2][0][0];
                    t2 = cube[2][0][1];
                    t3 = cube[2][0][2];

                    for(int t=0; t<3; t++) {
                        cube[2][0][t] = cube[5][0][t];
                        cube[5][0][t] = cube[3][0][t];
                        cube[3][0][t] = cube[4][0][t];
                    }
                    cube[4][0][0]=t1;
                    cube[4][0][1]=t2;
                    cube[4][0][2]=t3;
                }else {
                    t1 = cube[5][0][0];
                    t2 = cube[5][0][1];
                    t3 = cube[5][0][2];

                    for(int t=0; t<3; t++) {
                        cube[5][0][t] = cube[2][0][t];
                        cube[2][0][t] = cube[4][0][t];
                        cube[4][0][t] = cube[3][0][t];
                    }
                    cube[3][0][0]=t1;
                    cube[3][0][1]=t2;
                    cube[3][0][2]=t3;
                }
                break;
                case 'D': //아래
                if(d=='-') {
                    t1 = cube[2][2][0];
                    t2 = cube[2][2][1];
                    t3 = cube[2][2][2];

                    for(int t=0; t<3; t++) {
                        cube[2][2][t] = cube[5][2][t];
                        cube[5][2][t] = cube[3][2][t];
                        cube[3][2][t] = cube[4][2][t];
                    }
                    cube[4][2][0]=t1;
                    cube[4][2][1]=t2;
                    cube[4][2][2]=t3;
                }else {
                    t1 = cube[5][2][0];
                    t2 = cube[5][2][1];
                    t3 = cube[5][2][2];

                    for(int t=0; t<3; t++) {
                        cube[5][2][t] = cube[2][2][t];
                        cube[2][2][t] = cube[4][2][t];
                        cube[4][2][t] = cube[3][2][t];
                    }
                    cube[3][2][0]=t1;
                    cube[3][2][1]=t2;
                    cube[3][2][2]=t3;
                }
                break;
                case 'F':
                if(d=='+') {
                    t1 = cube[0][2][0];
                    t2 = cube[0][2][1];
                    t3 = cube[0][2][2];

                    cube[0][2][0] = cube[4][2][2];
                    cube[0][2][1] = cube[4][1][2];
                    cube[0][2][2] = cube[4][0][2];

                    cube[4][2][2] = cube[1][0][2];
                    cube[4][1][2] = cube[1][0][1];
                    cube[4][0][2] = cube[1][0][0];

                    cube[1][0][2] = cube[5][0][0];
                    cube[1][0][1] = cube[5][1][0];
                    cube[1][0][0] = cube[5][2][0];

                    cube[5][0][0] = t1;
                    cube[5][1][0] = t2;
                    cube[5][2][0] = t3;
                }else {
                    t1 = cube[0][2][0];
                    t2 = cube[0][2][1];
                    t3 = cube[0][2][2];

                    cube[0][2][0] = cube[5][0][0];
                    cube[0][2][1] = cube[5][1][0];
                    cube[0][2][2] = cube[5][2][0];

                    cube[5][0][0] = cube[1][0][2];
                    cube[5][1][0] = cube[1][0][1];
                    cube[5][2][0] = cube[1][0][0];

                    cube[1][0][2] = cube[4][2][2];
                    cube[1][0][1] = cube[4][1][2];
                    cube[1][0][0] = cube[4][0][2];
                    
                    cube[4][2][2] = t1;
                    cube[4][1][2] = t2;
                    cube[4][0][2] = t3;
                }
                break;
                case 'B':
                if(d=='+') {
                    t1 = cube[0][0][0];
                    t2 = cube[0][0][1];
                    t3 = cube[0][0][2];

                    cube[0][0][0] = cube[5][0][2];
                    cube[0][0][1] = cube[5][1][2];
                    cube[0][0][2] = cube[5][2][2];

                    cube[5][0][2] = cube[1][2][2];
                    cube[5][1][2] = cube[1][2][1];
                    cube[5][2][2] = cube[1][2][0];

                    cube[1][2][2] = cube[4][2][0];
                    cube[1][2][1] = cube[4][1][0];
                    cube[1][2][0] = cube[4][0][0];

                    cube[4][2][0]=t1;
                    cube[4][1][0]=t2;
                    cube[4][0][0]=t3;
                }else {
                    t1 = cube[0][0][0];
                    t2 = cube[0][0][1];
                    t3 = cube[0][0][2];

                    cube[0][0][0] = cube[4][2][0];
                    cube[0][0][1] = cube[4][1][0];
                    cube[0][0][2] = cube[4][0][0];

                    cube[4][2][0] = cube[1][2][2];
                    cube[4][1][0] = cube[1][2][1];
                    cube[4][0][0] = cube[1][2][0];

                    cube[1][2][2] = cube[5][0][2];
                    cube[1][2][1] = cube[5][1][2];
                    cube[1][2][0] = cube[5][2][2];

                    cube[5][0][2]=t1;
                    cube[5][1][2]=t2;
                    cube[5][2][2]=t3;
                }
                break;
                case 'L':
                if(d=='+') {
                    t1 = cube[0][0][0];
                    t2 = cube[0][1][0];
                    t3 = cube[0][2][0];

                    cube[0][0][0] = cube[3][2][2];
                    cube[0][1][0] = cube[3][1][2];
                    cube[0][2][0] = cube[3][0][2];

                    cube[3][2][2] = cube[1][0][0];
                    cube[3][1][2] = cube[1][1][0];
                    cube[3][0][2] = cube[1][2][0];

                    cube[1][0][0] = cube[2][0][0];
                    cube[1][1][0] = cube[2][1][0];
                    cube[1][2][0] = cube[2][2][0];

                    cube[2][0][0]=t1;
                    cube[2][1][0]=t2;
                    cube[2][2][0]=t3;
                }else {
                    t1 = cube[0][0][0];
                    t2 = cube[0][1][0];
                    t3 = cube[0][2][0];

                    cube[0][0][0] = cube[2][0][0];
                    cube[0][1][0] = cube[2][1][0];
                    cube[0][2][0] = cube[2][2][0];

                    cube[2][0][0] = cube[1][0][0];
                    cube[2][1][0] = cube[1][1][0];
                    cube[2][2][0] = cube[1][2][0];

                    cube[1][0][0] = cube[3][2][2];
                    cube[1][1][0] = cube[3][1][2];
                    cube[1][2][0] = cube[3][0][2];

                    cube[3][2][2]=t1;
                    cube[3][1][2]=t2;
                    cube[3][0][2]=t3;
                }
                break;
                case 'R':
                if(d=='+') {
                    t1 = cube[0][0][2];
                    t2 = cube[0][1][2];
                    t3 = cube[0][2][2];

                    cube[0][0][2] = cube[2][0][2];
                    cube[0][1][2] = cube[2][1][2];
                    cube[0][2][2] = cube[2][2][2];

                    cube[2][0][2] = cube[1][0][2];
                    cube[2][1][2] = cube[1][1][2];
                    cube[2][2][2] = cube[1][2][2];

                    cube[1][0][2] = cube[3][2][0];
                    cube[1][1][2] = cube[3][1][0];
                    cube[1][2][2] = cube[3][0][0];

                    cube[3][2][0]=t1;
                    cube[3][1][0]=t2;
                    cube[3][0][0]=t3;
                }else {
                    t1 = cube[0][0][2];
                    t2 = cube[0][1][2];
                    t3 = cube[0][2][2];

                    cube[0][0][2] = cube[3][2][0];
                    cube[0][1][2] = cube[3][1][0];
                    cube[0][2][2] = cube[3][0][0];

                    cube[3][2][0] = cube[1][0][2];
                    cube[3][1][0] = cube[1][1][2];
                    cube[3][0][0] = cube[1][2][2];

                    cube[1][0][2] = cube[2][0][2];
                    cube[1][1][2] = cube[2][1][2];
                    cube[1][2][2] = cube[2][2][2];

                    cube[2][0][2]=t1;
                    cube[2][1][2]=t2;
                    cube[2][2][2]=t3;
                }
                break;
            }
        }
    }
    static void rotate(char side, char d) {
        int n=0;
        switch(side) {
            case 'U':
            n=0;
            break;
            
            case 'D':
            n=1;
            break;
            
            case 'F':
            n=2;
            break;
            
            case 'B':
            n=3;
            break;

            case 'L':
            n=4;
            break;

            case 'R':
            n=5;
            break;
        }

        if(d=='+') {
            char t1 = cube[n][0][0];
            char t2 = cube[n][0][1];
            char t3 = cube[n][0][2];

            cube[n][0][0] = cube[n][2][0];
            cube[n][0][1] = cube[n][1][0];
            cube[n][0][2] = cube[n][0][0];

            cube[n][0][0] = cube[n][2][0];
            cube[n][1][0] = cube[n][2][1];
            cube[n][2][0] = cube[n][2][2];

            cube[n][2][0] = cube[n][2][2];
            cube[n][2][1] = cube[n][1][2];
            cube[n][2][2] = t3;

            cube[n][0][2] = t1;
            cube[n][1][2] = t2;
            cube[n][2][2] = t3;
        }else {
            char t1 = cube[n][0][0];
            char t2 = cube[n][0][1];
            char t3 = cube[n][0][2];

            cube[n][0][0] = cube[n][0][2];
            cube[n][0][1] = cube[n][1][2];
            cube[n][0][2] = cube[n][2][2];

            cube[n][0][2] = cube[n][2][2];
            cube[n][1][2] = cube[n][2][1];
            cube[n][2][2] = cube[n][2][0];

            cube[n][2][2] = cube[n][2][0];
            cube[n][2][1] = cube[n][1][0];
            cube[n][2][0] = t1;

            cube[n][2][0] = t1;
            cube[n][1][0] = t2;
            cube[n][0][0] = t3;
        }
    }

    static void init() {
        char c;
        for(int i=0; i<6; i++) {
            if(i==0) c='w';
            else if(i==1) c='y';
            else if(i==2) c='r';
            else if(i==3) c='o';
            else if(i==4) c='g';
            else          c='b';
            for(int j=0; j<3; j++) {
                for(int k=0; k<3; k++) {
                    cube[i][j][k] = c;
                }
            }
        }
    }

}
