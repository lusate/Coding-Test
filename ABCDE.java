import java.util.*;

public class Main {
    static boolean[] visit;
    static int N, M;
    static ArrayList<ArrayList<Integer>> graph;
    static ArrayList<Integer>[] list;

    public static void dfs(int num, int cnt) {
        if (cnt == 4) {
            System.out.println(1);
            System.exit(0);
        }

        visit[num] = true;
        for (int x : graph.get(num)) {
            if(!visit[x]){
                visit[x] = true;
                dfs(x, cnt + 1);
                visit[x] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        list = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            graph.get(v1).add(v2);
            graph.get(v2).add(v1);

            list[v1].add(v2);
            list[v2].add(v1);
        }
        System.out.println(graph.get(0));

        for (int i = 0; i < N; i++) {
            visit = new boolean[N];
            dfs(i, 0);
        }
        System.out.println(0);
    }
}

/* 입력
5 4
0 1
1 2
2 3
3 4


5 5
0 1
1 2
2 3
3 0
1 4


6 5
0 1
0 2
0 3
0 4
0 5
*/

/* 출력
1
1
0
*/
