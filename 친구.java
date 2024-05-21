import java.io.*;
import java.util.*;

class Main{
    static final int INF = 10000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N + 1][N + 1];
        char[][] map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i == j) cost[i][j] = 0;
                else if(map[i-1][j-1] == 'Y') cost[i][j] = 1;
                else cost[i][j] = INF;
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (cost[i][j] > cost[i][k] + cost[k][j]) {
                        cost[i][j] = cost[i][k] + cost[k][j];
                    }
                }
            }
        }
        /** cost는 이 상태!!
         * 01234
         * 10123
         * 21012
         * 32101
         * 43210
         * cost[0][2] = cost[0][1] + cost[1][2] 일 경우
         * 0,1이 친구고 1,2 가 친구면  0,2 도 친구가 된다.
         */

        int answer = Integer.MIN_VALUE; // 최대 2-친구 수
        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            for (int j = 1; j <= N; j++) {
                // A와 친구고 B와 친구인 C가 존재하면 2-친구가 되면 cnt++
                if(cost[i][j] == 2 || cost[i][j] == 1){
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);
    }
}

