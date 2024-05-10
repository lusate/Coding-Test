import java.io.*;
import java.util.*;

public class Main {
    static int M, N;

    static int[][] map;
    static int[][] dp;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        int answer = dfs(0, 0);
        System.out.println(answer); // 출발 지점
    }

    public static int dfs(int x, int y) {
        if (x == N-1 && y == M-1) return 1;

        /**
         * -1로 하는 이유
         * 오직 visit으로 0과 1을 구분하기 위해서 dp를 쓴 것이 아니다.
         * -1은 방문하지 않은 것으로 해놓고 방문 한 곳을 +1을 하기 위함이다.
         * 이렇게 하면 dp[0][0] 이 3이 된다. answer = 3
         */
        if (dp[x][y] == -1) {
            dp[x][y] = 0;
            for (int k=0; k<4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (map[x][y] > map[nx][ny]) {
                    dp[x][y] += dfs(nx, ny);
                }
            }
        }
        return dp[x][y];
    }
}


/*
4 5
50 45 37 32 30
35 50 40 20 25
30 30 25 17 28
27 24 22 15 10

3
*/
