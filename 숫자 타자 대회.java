//카카오 문제,

import java.util.*;
class Solution {
    // 0->0이면 가중치 1,  0->1이면 가중치 7,  0->2 가중치 6
    int[][] cost = {
            { 1, 7, 6, 7, 5, 4, 5, 3, 2, 3 },
            { 7, 1, 2, 4, 2, 3, 5, 4, 5, 6 },
            { 6, 2, 1, 2, 3, 2, 3, 5, 4, 5 },
            { 7, 4, 2, 1, 5, 3, 2, 6, 5, 4 },
            { 5, 2, 3, 5, 1, 2, 4, 2, 3, 5 },
            { 4, 3, 2, 3, 2, 1, 2, 3, 2, 3 },
            { 5, 5, 3, 2, 4, 2, 1, 5, 3, 2 },
            { 3, 4, 5, 6, 2, 3, 5, 1, 2, 4 },
            { 2, 5, 4, 5, 3, 2, 3, 2, 1, 2 },
            { 3, 6, 5, 4, 5, 3, 2, 4, 2, 1 }};

    String res;
    int n;
    int[][][] dp;

    public int dfs(int idx, int L, int R) {
        if (idx == n) { // numbers 길이 끝까지 도착하면 끝냄
            return 0;
        }
        if(dp[idx][L][R] != -1) return dp[idx][L][R];

        int num = res.charAt(idx) - '0'; //numbers의 int
        int result = Integer.MAX_VALUE;

        // numbers == 1756
        // num이 1일 때 L 위치인 4에서 이동할 때 최솟값을 구함.
        // 왼쪽은 왼쪽대로 오른쪽은 오른쪽대로 dfs 돌려서 최솟값을 dp에 저장한 것이다.
        if(num != L) result = Math.min(result, dfs(idx + 1, num, L) + cost[R][num]);
        // 왼쪽 하고나서 오른쪽을 할 때 다시 dp와 비교해서 최솟값을 갱신
        if(num != R) result = Math.min(result, dfs(idx + 1, num, R) + cost[L][num]);
        return dp[idx][L][R] = result;
    }
    public int solution(String numbers){
        res = numbers;
        n = numbers.length();

        dp = new int[n + 1][10][10];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < 10; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        int answer = dfs(0, 4, 6);
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("1756"));
        System.out.println(T.solution("5123"));
    }
}

/* 출력
10
8
*/
