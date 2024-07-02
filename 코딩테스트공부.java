package 프로그래머스;

import java.util.*;
public class 코딩테스트공부 {
    static final int INF = 1000000;
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        int maxAlp = Integer.MIN_VALUE;
        int maxCop = Integer.MIN_VALUE;


        for (int[] p : problems) {
            maxAlp = Math.max(maxAlp, p[0]);
            maxCop = Math.max(maxCop, p[1]);
        }

        /**
         * 최단 거리를 구할 때 dp도 한번 생각을 해보자.
         * dp[alp][cop] 은 (alp, cop) 위치까지 도달하는데 걸리는 최대 시간이다.
         * 현재 dp는 문제에서 최대 alp, cop이 각각 20이기 때문에 저렇게 한 것이다.
         * 즉 dp는 알고력, 코딩력에 대한 점수들이다.
         */
        int[][] dp = new int[maxAlp + 1][maxCop + 1];
        alp = Math.min(alp, maxAlp);
        cop = Math.min(cop, maxCop);

        for (int[] map : dp) {
            Arrays.fill(map, INF);
        }

        // dp에서 인덱스를 알고력과 코딩력으로 정의함.
        dp[alp][cop] = 0; // 시작 위치

        for(int i = alp; i <= maxAlp; i++) {
            for(int j = cop; j <= maxCop; j++) {
                // 문제를 풀기 위해 그냥 능력만 1 증가시키는 경우
                if(i + 1 <= maxAlp) {
                    // 처음 dp를 모두 INF로 해놓고 최단 거리를 구하려는 것이기 때문에 해줌.
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                }
                if(j + 1 <= maxCop) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                }
                // 선택해서 문제를 풀 경우
                for (int[] problem : problems) {
                    if(problem[0] <= i && problem[1] <= j) { // 풀 수 있는 경우
                        int nextAlp = Math.min(maxAlp, i + problem[2]); // maxAlp 범위를 초과하는 경우
                        int nextCop = Math.min(maxCop, j + problem[3]); // maxCop 범위를 초과하는 경우
                        dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], dp[i][j] + problem[4]); // 최단 시간을 더해줌.
                    }
                }
            }
        }

        return dp[maxAlp][maxCop];
    }

    public static void main(String[] args) {
        코딩테스트공부 T = new 코딩테스트공부();
        System.out.println(T.solution(10, 10, new int[][]{{10, 15, 2, 1, 2}, {20, 20, 3, 3, 4}}));
//        System.out.println(T.solution(0,0,new int[][]{{0,0,2,1,2}, {4,5,3,1,2}, {4,11,4,0,2}, {10,4,0,4,2}}));
    }
}
