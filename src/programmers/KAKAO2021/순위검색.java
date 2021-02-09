package programmers.KAKAO2021;

import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        ArrayList<Integer>[][][][] ls = new ArrayList[3][2][2][2];
        for(int i=0; i<3; i++) {
            for(int j=0; j<2; j++) {
                for(int k=0; k<2; k++) {
                    for(int l=0; l<2; l++) {
                        ls[i][j][k][l]=new ArrayList<>();
                    }
                }
            }
        }
        for(int i=0; i<info.length; i++) {
            int lang, work, period, food;
            String[] infoArray = info[i].split(" ");
            if(infoArray[0].charAt(0)=='c') lang=0;
            else if(infoArray[0].charAt(0)=='j') lang=1;
            else lang=2;
            
            if(infoArray[1].charAt(0)=='b') work=0;
            else work=1;
            
            if(infoArray[2].charAt(0)=='j') period=0;
            else period=1;
            
            if(infoArray[3].charAt(0)=='c') food=0;
            else food=1;
            
            ls[lang][work][period][food].add(Integer.parseInt(infoArray[4]));
        }
        
        for(int i=0; i<3; i++) {
            for(int j=0; j<2; j++) {
                for(int k=0; k<2; k++) {
                    for(int l=0; l<2; l++) {
                        ls[i][j][k][l].sort(new Comparator<Integer>(){
                            
                            @Override
                            public int compare(Integer o1, Integer o2) {
                              return o1-o2;
                            }
                        });
                    }
                }
            }
        }
        int[] answer = new int[query.length];
        for(int i=0; i<query.length; i++) {
            int[] lang, work, period, food;
            String[] queryArr = query[i].split(" and ");
            if(queryArr[0].charAt(0)=='c') lang=new int[]{0};
            else if(queryArr[0].charAt(0)=='j') lang=new int[]{1};
            else if(queryArr[0].charAt(0)=='p') lang=new int[]{2};
            else lang=new int[]{0, 1, 2};
            
            if(queryArr[1].charAt(0)=='b') work=new int[]{0};
            else if(queryArr[1].charAt(0)=='f') work=new int[]{1};
            else work=new int[]{0, 1};
            
            if(queryArr[2].charAt(0)=='j') period=new int[]{0};
            else if(queryArr[2].charAt(0)=='s') period=new int[]{1};
            else period=new int[]{0, 1};
            
            String[] div = queryArr[3].split(" ");
            if(div[0].charAt(0)=='c') food=new int[]{0};
            else if(div[0].charAt(0)=='p') food=new int[]{1};
            else food=new int[]{0, 1};
            
            int sc = Integer.parseInt(div[1]);
            int count=0;
            for(int l:lang) {
                for(int w:work){
                    for(int p:period) {
                        for(int f:food) {
                            ArrayList<Integer> list = ls[l][w][p][f];
                            if(list.size()==0) continue;
                            int end = binarySearch(list, sc);
                            if(list.get(end)>=sc) count+=list.size()-end;
                            else count+=list.size()-end-1;
                        }
                    }
                }
            }
            
            answer[i]=count;
        }
        
        return answer;
    }
    
    int binarySearch(ArrayList<Integer> list, int score) {
        int start = 0, end = list.size()-1, mid;
        while(end  > start) {
            mid = (start + end) / 2;
            if (list.get(mid) >= score) end=mid;
            else start=mid+1;
        }
        
        return end;
    }
}