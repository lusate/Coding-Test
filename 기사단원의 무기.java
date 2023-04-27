import java.util.*;
class Solution {
    //소수 개수 구함
    public int decimal(int number){
        int cnt = 1;
        if(number >= 2){
            for(int i=2; i<=number/2; i++){
                if(number % i == 0) cnt++;
            }
            cnt++;
        }

        return cnt;
    }
    public int solution(int number, int limit, int power) {
        int answer = 0;

        ArrayList<Integer> res = new ArrayList<>();
        for(int i=1; i<=number; i++){
            res.add(decimal(i));
        }
        // System.out.println(res);         

        for(int i=0; i<res.size(); i++){
            if(res.get(i) > limit){
                answer += power;
            }
            else answer += res.get(i);
        }

        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(5, 3, 2));
        System.out.println(T.solution(10, 3, 2));
    }
}


// ------------------------------------------------------------------------------------------------------------------------------------------------------------------


import java.util.*;
class Solution {
    public int solution(int number, int limit, int power) {
        int[] count = new int[number + 1];    
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number / i; j++) {
                count[i * j]++;
            }
        }
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            if (count[i] > limit) {
                answer += power;
            } else {
                answer += count[i];
            }
        }
        return answer;
    }
}
