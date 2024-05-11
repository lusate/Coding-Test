import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Edge {
    int st;
    int end;

    public Edge(int s, int e, int c) {
        this.st = s;
        this.end = e;
    }
}

public class Main {
    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    q.add(new int[]{i, j});
                }
            }
        }


        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = tmp[0] + dx[k];
                int ny = tmp[1] + dy[k];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == 0 && !visit[nx][ny]) {
                        if (map[nx][ny] > 0) {
                            map[nx][ny]--;
                        }
                    }
                }
            }
        }
    }
}
