import java.util.*;
class Main {
    static int n, k, answer = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] visit;

    public static void dfs(int cnt, int st, int sum) {
        if (cnt == n-1) {
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(cnt + 1, i, sum + map[st][i]);
                visit[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        map = new int[n][n];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 플로이드
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        visit[k] = true; // 이게 문제였음. 처음 시작점은 방문처리를 해줘야 함.
        dfs(0, k, 0);
        System.out.println(answer);
    }
}
