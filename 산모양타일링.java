package 프로그래머스문제;

import java.util.*;
public class 산모양타일링 {
    public int solution(int n, int[] tops) {
        int answer = 0;

        /**
         * 마름모 타일로 끝나지 않은 경우의 수를 dp[n][0], 마름모 타일로 끝나는 경우의 수를 dp[n][1]
         * dp[n][0] = dp[n - 1][0] * 2 + dp[n - 1][1]
         * dp[n][1] = dp[n - 1][0] + dp[n - 1][1]
         */
        int[][] dp = new int[n+1][2];
        dp[1][0] = tops[0] == 1 ? 3 : 2;
        dp[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            // 마름모 타일로 끝나지 않을 경우 마름모로 덮을 때 경우의 수
            int cover1 = tops[i - 1] == 1 ? 3 : 2;
            // 마름모 타일로 끝날 경우 마름모로 덮을 때 경우의 수
            int cover2 = tops[i - 1] == 1 ? 2 : 1;
            // tops가 있는 경우와 없는 경우를 나눴으므로 이전 것 가지 수에서 곱해주면 된다.

            dp[i][0] = (dp[i - 1][0] * cover1 + dp[i - 1][1] * cover2) % 10007;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][1]) % 10007;
        }

        answer = (dp[n][0] + dp[n][1]) % 10007;
        return answer;
    }

    /*public static int solution(int n, int[] tops) {
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];

        a[1] = 1;
        if (tops[0] == 1) b[1] = 3;
        else b[1] = 2;

        for (int i = 2; i <= n; i++) {
            a[i] = (a[i - 1] + b[i - 1]) % 10007;
            if (tops[i - 1] == 1) {
                b[i] = (a[i - 1] * 2 + b[i - 1] * 3) % 10007;
            } else {
                b[i] = (a[i - 1] + b[i - 1] * 2) % 10007;
            }
        }
        return (a[n] + b[n]) % 10007;
    }*/

    /*int[][] dp;
    int[] topList;

    // ind 위치에 num 모양을 놓았을 때 총 경우의 수
    int dfs(int ind, int num) {
        //기저조건
        if (num == 1 && topList[ind] == 0) return dp[ind][num] = 0;
        if (ind == 0) return 1;
        if (dp[ind][num] != -1) return dp[ind][num];

        int result = 0;
        for (int i = 0; i < 4; i++) {
            if (num == 2 && i == 3) continue;
            result = (dfs(ind-1, i) + result) % 10007;
        }
        return dp[ind][num] = result;
    }

    public int solution(int n, int[] tops) {
        //초기화
        dp = new int[n+1][4];
        topList = tops;
        for (int i = 0; i <= n; i++)
            Arrays.fill(dp[i], -1);
        return dfs(n, 0);
    }*/

    public static void main(String[] args) {
        산모양타일링 T = new 산모양타일링();
        System.out.println(T.solution(4, new int[]{1, 1, 0, 1}));
        System.out.println(T.solution(2, new int[]{0, 1}));
        System.out.println(T.solution(10, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    }
}
