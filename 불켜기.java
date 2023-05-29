import java.util.*;
import java.io.*;
class Point{
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Main {
    static int n, answer = 1;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visit;
    static int[][] res;
    static ArrayList<Point>[][] graph;

    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));

        res[0][0] = 1; // 불을 켠 결과, 1이면 불을 킨 상태
        visit[0][0] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (!graph[now.x][now.y].isEmpty()) {
                visit = new boolean[n][n];
                visit[now.x][now.y] = true;
                for (Point tmp : graph[now.x][now.y]) { //불을 킬 수 있는 상태들
                    if (res[tmp.x][tmp.y] == 0) {
                        res[tmp.x][tmp.y] = 1; //불을 켜줌
                        answer++;
                    }
                }

                graph[now.x][now.y].clear();
            }

            for (int k = 0; k < 4; k++) {
                int nx = now.x + dx[k];
                int ny = now.y + dy[k];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (!visit[nx][ny] && res[nx][ny] == 1) {
                        visit[nx][ny] = true;
                        q.add(new Point(nx, ny));
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[m][4]; // 입력

        graph = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = new ArrayList<>();
            }
        }

        visit = new boolean[n][n];
        res = new int[n][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                // (0, 0) 부터 시작하기 위해 1을 뺌
                map[i][j] = Integer.parseInt(st.nextToken()) - 1;
            }
            graph[map[i][0]][map[i][1]].add(new Point(map[i][2], map[i][3]));
        }

        bfs();
        System.out.println(answer);
    }
}

/* 입력
3 6
1 1 1 2
2 1 2 2
1 1 1 3
2 3 3 1
1 3 1 2
1 3 2 1
*/


/* 출력
5
*/
