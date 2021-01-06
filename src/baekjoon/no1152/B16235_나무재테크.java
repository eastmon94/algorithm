package baekjoon.no1152;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B16235_나무재테크 {
    static int N, M, K;
    static int[][] map;
    static int[][] input;
    static ArrayList<Tree>[][] trees;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        input = new int[N][N];
        trees = new ArrayList[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(in.readLine());
            for(int j=0; j<N; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
                map[i][j]=5;
                trees[i][j] = new ArrayList<>();
            }
        }
        int r, c, age;
        for(int m=0; m<M; m++) {
            st = new StringTokenizer(in.readLine());
            r = Integer.parseInt(st.nextToken())-1;
            c = Integer.parseInt(st.nextToken())-1;
            age = Integer.parseInt(st.nextToken());
            trees[r][c].add(new Tree(age, 0));
        }

        for(int k=0; k<K; k++) {
            init();
            spring();
            summer();
            fall();
            winter();
        }

        long count=0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                count += trees[i][j].size();
            }
        }
        System.out.println(count);
    }
    static void init() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int size=trees[i][j].size();
                for(int s=0; s<size; s++) {
                    trees[i][j].get(s).check = 0;
                }
            }
        }
    }

    static void spring() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int size = trees[i][j].size();
                if(size==0) continue;
                trees[i][j].sort(new Comparator<Tree>(){
                    @Override
                    public int compare(Tree o1, Tree o2) {
                        if(o1.check==o2.check) return o1.age-o2.age;
                        return o1.check-o2.check;
                    }
                });
                for(int s=0; s<size; s++) {
                    Tree t = trees[i][j].get(s);
                    if(map[i][j] >= t.age && t.check==0) {
                        trees[i][j].get(s).check = 1;
                        map[i][j] -= t.age;
                        trees[i][j].get(s).age++;
                    }
                    else break;
                }
            }
        }
    }
    
    static void summer() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int size = trees[i][j].size();

                for(int s=size-1; s>=0; s--) {
                    if(trees[i][j].get(s).check==1) continue;
                    map[i][j]+=(trees[i][j].get(s).age)/2;
                    trees[i][j].remove(s);
                }
            }
        }
    }
    
    static void fall() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int size = trees[i][j].size();

                for(int s=0; s<size; s++) {
                    if(trees[i][j].get(s).age%5==0) {
                        for(int r=-1; r<=1; r++) {
                            for(int c=-1; c<=1; c++) {
                                if(r==0&&c==0) continue;
                                if(isIn(i+r, j+c)) trees[i+r][j+c].add(new Tree(1, 0));
                            }
                        }
                    }
                }
            }
        }
    }

    static void winter() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                map[i][j] += input[i][j];
            }
        }
    }

    static boolean isIn(int r, int c) {
        return 0<=r && r<N && 0<=c && c<N;
    }

    static class Tree {
        int age;
        int check;
        public Tree(int age, int check) {
            this.age = age;
            this.check = check;
        }
    }
}