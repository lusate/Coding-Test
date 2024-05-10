import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge {
    int st;
    int end;
    int cost;

    public Edge(int s, int e, int c) {
        this.st = s;
        this.end = e;
        this.cost = c;
    }
}

public class Main {
    static Edge[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 노드의 수
        int S = Integer.parseInt(st.nextToken()); // 시작도시
        int E = Integer.parseInt(st.nextToken()); // 도착 도시
        int M = Integer.parseInt(st.nextToken()); // 에지의 수

        graph = new Edge[M + 1];
        long[] cost = new long[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()); // 버는 돈이 아닌 쓰는 돈이다!!!
            graph[i] = new Edge(a, b, c);
        }
        long[] money = new long[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            money[i] = Integer.parseInt(st.nextToken()); // 벌 수 있는 최대 돈
        }

        // 벨만 포드 알고리즘
        Arrays.fill(cost, Long.MIN_VALUE);
        cost[S] = money[S];

        /**
         * a -> b && b -> a 둘 다 가능
         * 무한히 계속 돌 수 있기 때문에 최대인 도시의 개수 100으로 설정하고
         */
        for(int i = 0 ; i <= N+100; i++){
            for(int j = 0 ; j < M; j++){
                Edge tmp = graph[j];

                int nowSt = tmp.st;
                int nowEd = tmp.end;
                int nowCost = tmp.cost;

                if(cost[nowSt]==Long.MIN_VALUE)
                    continue; // [0] 제외하고 모든 cost가 현재 MIN이기 때문에 continue로 넘어감.
                else if(cost[nowSt]==Long.MAX_VALUE){
                    cost[nowEd] = Long.MAX_VALUE; // 최대라면 Gee를 출력하기 위해
                }
                // 번 돈에서 사용한 돈을 빼준다.  cost[nowSt] 는 총 합을 구하기 위함.
                else if(cost[nowEd] < cost[nowSt]+money[nowEd]-nowCost){
                    cost[nowEd] = cost[nowSt]+money[nowEd]-nowCost;
                    if(i > N) // 현 도시의 개수를 넘으면 cost는 MAX가 됨.
                        cost[nowEd] = Long.MAX_VALUE;
                }
            }
        }
        if(cost[E] == Long.MIN_VALUE)
            System.out.println("gg");
        else if(cost[E] == Long.MAX_VALUE)
            System.out.println("Gee");
        else System.out.println(cost[E]);
    }
}


/*
5 0 4 7
0 1 13
1 2 17
2 4 20
0 3 22
1 3 4747
2 0 10
3 4 10
0 0 0 0 0

-32


5 0 4 5
0 1 10
1 2 10
2 3 10
3 1 10
2 4 10
0 10 10 110 10

Gee
*/
