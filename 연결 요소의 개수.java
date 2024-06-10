import java.io.*;
import java.util.*;

class Main{
    static int N, M;
    static boolean[] visit;
    static int[][] dy;

    /**
     * dy 관련해서 dfs를 돌리는데 방문을 했으면 return 해주고 정점 1부터 시작해서 깊이 L 이 있는 곳까지 재귀해준다.
     * 즉 dy에서 1인 곳을 찾아가는 것
     */
    public static void dfs(int L) {
        if (visit[L]) {
            return;
        }

        visit[L] = true;
        for (int i = 1; i <= N; i++) {
            if(dy[L][i] == 1){
                dfs(i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N + 1];

        dy = new int[N + 1][N + 1];

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dy[a][b] = 1;
            dy[b][a] = 1;
        }

        /**
         * 연결 요소를 만들었는데 방문하지 않았으면 dfs를 해야 한다.
         * dfs 하고 나서 cnt++
         */
        int cnt = 0;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if (!visit[i]) {
                    dfs(i);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}

/*
6 5
1 2
2 5
5 1
3 4
4 6
*/
