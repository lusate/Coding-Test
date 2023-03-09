import java.util.*;
class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        // st 처음일 때 +1하고 시작.
        int st = section[0];
        
        for(int i=1; i<section.length; i++){
            if(section[i] > st + m - 1){ //윈도우 길이보다 크면 +1, st 초기화
                answer++;
                st = section[i];
            }
        }
        return answer;
    }
    
    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(8, 4, new int[]{2, 3, 6}));
        System.out.println(T.solution(5, 4, new int[]{1, 3}));
        System.out.println(T.solution(4, 1, new int[]{1, 2, 3, 4}));
    }
}
