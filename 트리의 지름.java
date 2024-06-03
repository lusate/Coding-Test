import java.io.*;
import java.util.*;

class Edge{
    int vest, cost;

    public Edge(int vest, int cost) {
        this.vest = vest;
        this.cost = cost;
    }
}
class Main{
    static int N, max, node;
    static ArrayList<Edge>[] graph;
    static boolean[] visited;
    private static void dfs(int L, int len) {
        if (max < len) {
            max = len;
            node = L;
        }
        visited[L] = true;

        for (int i = 0; i < graph[L].size(); i++) {
            Edge next = graph[L].get(i);
            if (!visited[next.vest]) {
                dfs(next.vest, len + next.cost);
                visited[L] = true;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /**
         * 트리의 지름이란: 트리에서 임의의 두 점 사이의 거리 중 가장 긴 것을 말한다.
         */
        N = Integer.parseInt(st.nextToken()); // 정점 개수

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());

            while (true) {
                int v = Integer.parseInt(st.nextToken());
                if(v == -1) break;
                int c = Integer.parseInt(st.nextToken());

                graph[u].add(new Edge(v, c));
            }
        }

        max = -1;
        visited = new boolean[N + 1];
        dfs(1, 0);

        visited = new boolean[N + 1];
        dfs(node, 0);

        System.out.println(max);
    }
}

/*
5
1 3 2 -1
2 4 4 -1
3 1 2 4 3 -1
4 2 4 3 3 5 6 -1
5 4 6 -1
*/
