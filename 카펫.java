import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow;
        for(int i=(int)Math.sqrt(sum); i<=sum; i++){
            int x = i;
            int y = sum / x;
            
            if(x < y) continue;
            
            if((x - 2) * (y - 2) == yellow){
                answer[0] = x;
                answer[1] = y;
            } 
        }
        
        return answer;
    }
}
