import java.util.*;
class Solution{
    public int solution(int sticker[]) {
        int answer = 0;
        int n = sticker.length;

        if(n == 1) return sticker[0];

        int[] dp = new int[n]; // 해당 위치까지의 최댓값
        dp[0] = sticker[0];
        dp[1] = dp[0];

        //첫 번째 스티커를 뗐을 때 결과
        for (int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + sticker[i], dp[i - 1]);
        }
        answer = dp[n - 2];

        dp[0] = 0;
        dp[1] = sticker[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + sticker[i], dp[i - 1]);
        }
        answer = Math.max(answer, dp[n - 1]);
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{14, 6, 5, 11, 3, 9, 2, 10}));
        System.out.println(T.solution(new int[]{1, 3, 2, 5, 4}));
    }
}


/* 출력
36
8
*/
