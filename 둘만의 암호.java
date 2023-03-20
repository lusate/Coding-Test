import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        char[] ch = s.toCharArray();

        for(int i=0; i<ch.length; i++){
            for(int j=0; j<index; j++){
                ch[i]++;
                if(ch[i] > 'z'){ //z보다 크면 다시 a부터 시작하도록 함.
                    ch[i] -= 26;
                }
                
                while(skip.contains(String.valueOf(ch[i]))){
                    ch[i]++;
                    if(ch[i] > 'z'){
                        ch[i] -= 26;
                    }
                }
            }
        }
        
        answer = String.valueOf(ch);
        
        return answer;
    }

	public static void main(String args[]){
		Solution T = new Solution();
		System.out.println(T.solution("aukks", "wbqd", 5));
	}
}


/* 출력
happy
*/
