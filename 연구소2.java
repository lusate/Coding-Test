import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M, zeroCnt = 0, answer = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] visit;
    static ArrayList<Point> virus;

    private static void dfs(int virusCnt, int st) {
        // depth는 바이러스 개수 , st는 바이러스 현재 위치 다르게 하기 위함
        if (virusCnt == M) {
            int[][] copyMap = copyMap();
            bfs(copyMap, zeroCnt);
            return;
        }
        else{
            for (int i = st; i < virus.size(); i++) {
                visit[i] = true;
                dfs(virusCnt + 1, i + 1);
                visit[i] = false;
            }
        }
    }

    public static void bfs(int[][] map, int zeroCnt){
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < virus.size(); i++) {
            if(visit[i]) q.add(virus.get(i));
        }

        // 바이러스 시작할 위치 정해서 3개 부분이 true 인 상태 -> dfs를 돌렸기 때문에
        // 그래서 현재 q에는 바이러스로 위치 잡은 좌표가 들어가있음.
        int time = 0;
        while (!q.isEmpty()) {
            if (answer <= time) break; // 최소값을 뽑기 위함.

            int len = q.size();
            for (int t = 0; t < len; t++) {
                Point now = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] == 0) {
                        map[nx][ny] = 2;
                        q.add(new Point(nx, ny));
                        zeroCnt--; // 지날 수 있는 길 -1 -> 0 개수가 줄어듬.
                    }
                }
            }

            time++;
            if (zeroCnt == 0) { // 더 이상 이동 불가능 -> 바이러스 모두 퍼짐.
                answer = time;
                return;
            }
        }
    }

    private static int[][] copyMap() {
        int[][] copyMap = new int[N][N];
        // 바이러스 2일 것을 0으로 만들고 벽은 1로 한 2차원 배열
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                copyMap[i][j] = (map[i][j] == 2 ? 0 : map[i][j]);
        }

        // 바이러스 개수 만큼 for문 -> 현재 바이러스 위치를 넣어주는 반복문
        for (int i = 0; i < virus.size(); i++) {
            if (visit[i]) {
                Point node = virus.get(i);
                copyMap[node.x][node.y] = 2;
            }
        }

        return copyMap;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        zeroCnt = 0;

        virus = new ArrayList<>();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 0) {
                    zeroCnt++;
                }
                if (map[i][j] == 2) {
                    virus.add(new Point(i, j));
                }
            }
        }

        zeroCnt += (virus.size() - M); // 입력한 연구소의 바이러스 개수 - m => 총 0의 개수
        visit = new boolean[virus.size()];
        if (zeroCnt == 0) {
            answer = 0;
        }
        else{
            dfs(0, 0);
        }
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

    }
}



/* 입력
7 3
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 2 0 1 1
0 1 0 0 0 0 0
2 1 0 0 0 0 2



7 4
2 0 2 0 1 1 0
0 0 1 0 1 2 0
0 1 1 2 1 0 0
2 1 0 0 0 0 2
0 0 0 2 0 1 1
0 1 0 0 0 0 0
2 1 0 0 2 0 2



7 2
2 0 2 0 1 1 0
0 0 1 0 1 0 0
0 1 1 1 1 0 0
2 1 0 0 0 0 2
1 0 0 0 0 1 1
0 1 0 0 0 0 0
2 1 0 0 2 0 2
*/

/* 출력
5

4

-1
*/


/* 입력
7 3
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 2 0 1 1
0 1 0 0 0 0 0
2 1 0 0 0 0 2



7 4
2 0 2 0 1 1 0
0 0 1 0 1 2 0
0 1 1 2 1 0 0
2 1 0 0 0 0 2
0 0 0 2 0 1 1
0 1 0 0 0 0 0
2 1 0 0 2 0 2



7 2
2 0 2 0 1 1 0
0 0 1 0 1 0 0
0 1 1 1 1 0 0
2 1 0 0 0 0 2
1 0 0 0 0 1 1
0 1 0 0 0 0 0
2 1 0 0 2 0 2
*/

/* 출력
5

4

-1
*/
