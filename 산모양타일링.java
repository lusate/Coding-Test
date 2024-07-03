public class 산모양타일링 {
    /*public int solution(int n, int[] tops) {
        int answer = 0;

        *//**
         * 마름모 타일로 끝나지 않은 경우의 수를 dp[n][0], 마름모 타일로 끝나는 경우의 수를 dp[n][1]
         * dp[n][0] = dp[n - 1][0] * 2 + dp[n - 1][1]
         * dp[n][1] = dp[n - 1][0] + dp[n - 1][1]
         *//*
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
    }*/

    public int solution(int n, int[] tops) {
        //이 풀이 방식든 집에서 다시
//        https://velog.io/@funnysunny08/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%B9%B4%EC%B9%B4%EC%98%A4-%EC%82%B0-%EB%AA%A8%EC%96%91-%ED%83%80%EC%9D%BC%EB%A7%81-java
    }

    public static void main(String[] args) {
        산모양타일링 T = new 산모양타일링();
        System.out.println(T.solution(4, new int[]{1, 1, 0, 1}));
        System.out.println(T.solution(2, new int[]{0, 1}));
        System.out.println(T.solution(10, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    }
}
