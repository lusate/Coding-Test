import java.io.*;
import java.util.*;

class Main{
    static int N, M, K, cnt;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static boolean[][] visit;
    static int[][] map;

    static private void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visit[x][y] = true;
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = tmp[0] + dx[k];
                int ny = tmp[1] + dy[k];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visit[nx][ny] && map[nx][ny] == 1) {
                    q.add(new int[]{nx, ny});
                    visit[nx][ny] = true;
                    cnt++;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            map[x][y] = 1;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                /**
                 * 처음 위치에서의 값은 1로 고정을 해야 함.
                 */
                if (map[i][j] == 1) {
                    cnt = 1;
                    bfs(i, j);
                    max = Math.max(max, cnt);
                }
            }
        }
        System.out.println(max);
    }
}

/*
3 4 5
3 2
2 2
3 1
2 3
1 1
*/
