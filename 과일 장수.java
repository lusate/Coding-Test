import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        //내림차순
        Integer[] res = new Integer[score.length];
        for(int i=0; i<score.length; i++){
            res[i] = score[i];
        }
        Arrays.sort(res, Collections.reverseOrder());
        
        int sum = 0;
        int idx = 0;
        for(int i=0; i<res.length; i++){
            if((i+1) % m == 0){
                answer += res[i] * m;
            }
        }
        
        return answer;
    }
  
  public static void main(String[] args){
    Solution T = new Solution();
    System.out.println(T.solution(3, 4, new int[]{1, 2, 3, 1, 2, 3, 1}));
    System.out.println(T.solution(4, 3, new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}));
  }
}


// --------------------------------------------------------------------------------------------


import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        int sum = 0;
        for(int i=score.length%m; i<score.length; i+=m){
            sum += score[i];
        }
        answer += sum*m;
        return answer;
    }
  
  public static void main(String[] args){
    Solution T = new Solution();
    System.out.println(T.solution(3, 4, new int[]{1, 2, 3, 1, 2, 3, 1}));
    System.out.println(T.solution(4, 3, new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}));
  }
}
