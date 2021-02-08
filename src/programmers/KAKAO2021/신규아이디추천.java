package programmers.KAKAO2021;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        sb.append(new_id);
        step1(sb);
        step2(sb);
        step3(sb);
        step4(sb);
        step5(sb);
        step6(sb);
        step7(sb);
        return sb.toString();
    }
    
    public void step1(StringBuilder sb) {
        for(int i=0; i<sb.length(); i++) {
            char c = sb.charAt(i);
            if(c>='A' && c<='Z') {
                sb.setCharAt(i, (char)(c-'A'+'a'));
            }
        }
    }
    
    public void step2(StringBuilder sb) {
        for(int i=sb.length()-1; i>=0; i--) {
            char c = sb.charAt(i);
            if((c>='a' && c<='z') || (c>='0' && c<='9') || c=='-' || c=='_' || c=='.') continue;
            sb.deleteCharAt(i);
        }
    }
    
    public void step3(StringBuilder sb) {
        int start=-1, end=-1;
        for(int i=sb.length()-1; i>=0; i--) {
            if(sb.charAt(i)=='.' && start==-1) start=i;
            if(sb.charAt(i)=='.' && i==0) {
                end=i;
                sb.replace(end, start+1, ".");
                start=-1; end=-1;
            } else if(sb.charAt(i)=='.' && sb.charAt(i-1)!='.'){
                end=i;
                sb.replace(end, start+1, ".");
                start=-1; end=-1;
            }
        }
    }
    
    public void step4(StringBuilder sb) {
        if(sb.length()!=0 && sb.charAt(sb.length()-1)=='.') sb.deleteCharAt(sb.length()-1);
        if(sb.length()!=0 && sb.charAt(0)=='.') sb.deleteCharAt(0);
    }
    
    public void step5(StringBuilder sb) {
        if(sb.length()==0) sb.append('a');
    } 
    
    public void step6(StringBuilder sb) {
        if(sb.length()>=16) {
            sb.delete(15, sb.length());
        }
        step4(sb);
    }
    
    public void step7(StringBuilder sb) {
        while(sb.length()<3) {
            sb.append(sb.charAt(sb.length()-1));
        }
    }
}