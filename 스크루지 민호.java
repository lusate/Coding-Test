import java.io.*;
import java.util.*;

class Node{
    int vest, cost;

    Node(int vest, int cost) {
        this.vest = vest;
        this.cost = cost;
    }
}
class Main{
    static int N, max, node;
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    private static void dfs(int L, int len) {
        if (max < len) {
            max = len;
            node = L;
        }
        visited[L] = true;

        for (int i = 0; i < graph[L].size(); i++) {
            Node next = graph[L].get(i);
            if (!visited[next.vest]) {
                dfs(next.vest, len + next.cost);
                visited[L] = true;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, 1));
            graph[v].add(new Node(u, 1));
        }

        /**
         * 임의의 노드에서 시작해서 다른 노드로 갈 때의 최대 거리와 가장 먼 노드를 구함.
         * max = 3, node = 5
         */
        max = -1;
        visited = new boolean[N + 1];
        dfs(1, 0); // 깊이 0에 도시 1부터 시작.

        /**
         * 가장 먼 노드를 구했으니 그 거리를 구해줌.
         * max = 3, node = 3
         */
        max = -1;
        visited = new boolean[N + 1];
        dfs(node, 0);

        System.out.println((1 + max) / 2);
    }
}

/*
5
4 5
4 2
2 3
1 2
*/
