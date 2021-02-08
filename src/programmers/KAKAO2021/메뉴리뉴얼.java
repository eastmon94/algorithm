package programmers.KAKAO2021;

import java.util.*;

class Solution {
    HashMap<String, Integer> hashmap;
    ArrayList<String> answer;
    
    public String[] solution(String[] orders, int[] course) {
        hashmap = new HashMap<>();
        answer = new ArrayList<>();
        for(int i=0; i<orders.length; i++) {
            char[] ca = orders[i].toCharArray();
            Arrays.sort(ca);
            orders[i] = String.valueOf(ca);
        }
        
        for(int num : course) {
            hashmap.clear();
            for(String order : orders) {
                combination(0, 0, "", order, num);
            }
            Set<String> keySet = hashmap.keySet();
            int maxVal = Integer.MIN_VALUE;
            for(String key : keySet) {
                maxVal = Math.max(maxVal, hashmap.get(key));
            }
            if(maxVal==1) continue;
            for(String key:keySet) {
                if(hashmap.get(key)==maxVal) answer.add(key);
            }
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[answer.size()]);
    }
    
    public void combination(int idx, int cur, String comb, String order, int num) {
        if(idx==num) {
            if(hashmap.get(comb)==null) hashmap.put(comb, 1);
            else hashmap.put(comb, hashmap.get(comb)+1);
            
            return;
        }
        
        for(int i=cur; i<order.length(); i++) {
            combination(idx+1, i+1, comb+order.charAt(i), order, num);
        }
    }
}