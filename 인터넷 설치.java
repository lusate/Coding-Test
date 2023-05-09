import java.util.*;

public class Main {
    static int N, P, K;
    static List<Edge>[] adj;
    static final int INF = 1000000;
    static int answer = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        P = sc.nextInt();
        K = sc.nextInt();

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < P; i++) {
            int v1, v2, cost;
            v1 = sc.nextInt();
            v2 = sc.nextInt();
            cost = sc.nextInt();

            adj[v1].add(new Edge(v2, cost));
            adj[v2].add(new Edge(v1, cost));
        }

        int left = 0, right = INF;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (dijkstra(mid)) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean dijkstra(int mid) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (now.cost > dist[now.vertex]) continue;

            for (Edge next : adj[now.vertex]) {
                int cost = (next.cost > mid) ? 1 : 0;

                if (dist[next.vertex] > now.cost + cost) {
                    dist[next.vertex] = now.cost + cost;
                    pq.add(new Edge(next.vertex, dist[next.vertex]));
                }
            }
        }

        return dist[N] <= K;
    }

    static class Edge implements Comparable<Edge> {
        int vertex;
        int cost;

        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}

/* 입력
5 7 1
1 2 5
3 1 4
2 4 8
3 2 3
5 2 9
3 4 7
4 5 6
*/

/* 출력
4
*/
