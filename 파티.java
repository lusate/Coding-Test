import java.util.*;
import java.io.*;
class Main {
    static int INF = 10000000;
    static ArrayList<ArrayList<int[]>> graph;
    static int n, m, x;

    private static int dijkstra(int st, int ed) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        boolean[] visit = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);

        dist[st] = 0;
        pq.add(new int[]{st, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];

            if (!visit[now]) {
                visit[now] = true;

                for (int[] x : graph.get(now)) {
                    int next = x[0];
                    int nextCost = x[1];
                    if (!visit[next] && dist[next] > dist[now] + nextCost) {
                        dist[next] = dist[now] + nextCost;
                        pq.add(new int[]{next, dist[now] + nextCost});
                    }
                }
            }
        }

        return dist[ed];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //학생 수
        m = Integer.parseInt(st.nextToken()); // 도로 개수
        x = Integer.parseInt(st.nextToken()); // 모일 마을 번호

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 출발
            int b = Integer.parseInt(st.nextToken()); // 도착
            int c = Integer.parseInt(st.nextToken()); // 소요 시간
            graph.get(a).add(new int[]{b, c}); //단방향으로만
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (i == x) {
                continue;
            }

            int goResult = dijkstra(i, x);
            int backResult = dijkstra(x, i);

            max = Math.max(max, goResult + backResult);
        }

        System.out.println(max);
    }
}

/* 입력
4 8 2
1 2 4
1 3 2
1 4 7
2 1 1
2 3 5
3 1 2
3 4 4
4 2 3
*/


/* 출력
10
*/
