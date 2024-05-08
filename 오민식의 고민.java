import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Edge{
    int st, ed, cost;

    Edge(int st, int ed, int cost) {
        this.st = st;
        this.ed = ed;
        this.cost = cost;
    }
}
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 도시 수
        int S = Integer.parseInt(st.nextToken()); // 시작 도시
        int E = Integer.parseInt(st.nextToken()); // 도착 도시
        int M = Integer.parseInt(st.nextToken()); // 교통 수단 개수

        Edge[] graph = new Edge[N + 1];


        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken()); // 시작
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken()); // 비용

                graph[i] = new Edge(a, b, c);
            }
        }

        int[] cost = new int[N + 1]; // 도시 지나갈 때마다 비용
        int[] earnMoney = new int[N + 1]; // 벌 수 있는 최대 돈
        // 0번 도시부터 차례대로 각 도시에서 벌 수 있는 돈의 최댓값
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            earnMoney[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(cost, Integer.MIN_VALUE);
        cost[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge tmp = graph[j];
                int nowSt = tmp.st;
                int nowEd = tmp.ed;
                int nowCost = tmp.cost;

                if()
            }
        }


//        System.out.println(answer);
    }
}
