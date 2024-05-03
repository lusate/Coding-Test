import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N, M, count = 0, answer = Integer.MAX_VALUE;
    private static int[][] map;
    private static boolean[] check;
    private static List<Node> virus = new ArrayList<>();
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) virus.add(new Node(i, j));
                if (map[i][j] == 0) count++;
            }
        }

        count += virus.size() - M; // 입력한 연구소의 바이러스 개수 - m => 총 0의 개수
        check = new boolean[virus.size()];

        if (count == 0) answer = 0;
        else dfs(0, 0);

        System.out.println((answer == Integer.MAX_VALUE) ? -1 : answer);
    }

    private static void dfs(int depth, int start) {
        // depth는 바이러스 개수 , start는 
        if (depth == M) {
            int[][] copyMap = copy();
            bfs(copyMap, count);
            return;
        }

        for (int i = start; i < virus.size(); i++) {
            check[i] = true;
            dfs(depth + 1, i + 1);
            check[i] = false;
        }
    }

    private static void bfs(int[][] map, int count) {
        Queue<Node> queue = new LinkedList<>();

        // 바이러스 시작할 위치 정해서 3개 부분이 true 인 상태 -> dfs를 돌렸기 때문에
        // 그래서 현재 q에는 바이러스로 위치 잡은 좌표가 들어가있음.
        for (int i = 0; i < virus.size(); i++) {
            if (check[i]) queue.add(virus.get(i));
        }

        int time = 0;
        while (!queue.isEmpty()) {
            if (answer <= time) break; // 최소값을 뽑기 위함.

            int len = queue.size();
            for (int t = 0; t < len; t++) { // 시작 지점이 여러 개이기 때문에 반복문으로 한 번 더 감싼다.
                Node now = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (map[nx][ny] != 0) continue;

                    map[nx][ny] = 2;
                    queue.add(new Node(nx, ny));
                    count--; // 지날 수 있는 길 -1 -> 0 개수가 줄어듬.
                }
            }

            time++;
            if (count == 0) { // 더 이상 이동 불가능 -> 바이러스 모두 퍼짐.
                answer = time;
                return;
            }
        }
    }

    private static int[][] copy() {
        int[][] copyMap = new int[N][N];
        // 바이러스 2일 것을 0으로 만들고 벽은 1로 한 2차원 배열
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                copyMap[i][j] = (map[i][j] == 2 ? 0 : map[i][j]);
        }

        // 바이러스 개수 만큼 for문
        for (int i = 0; i < virus.size(); i++) {
            if (check[i]) {
                Node node = virus.get(i);
                copyMap[node.x][node.y] = 2;
            }
        }

        return copyMap;
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
