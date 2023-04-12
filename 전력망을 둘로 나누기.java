import java.util.*;
class Solution {
    int answer;
    int[][] map;
    boolean[] visit;

    public int dfs(int n, int cnt) {
        visit[cnt] = true;
        int child = 1;
        for (int i = 1; i <= n; i++) {
            if (map[cnt][i] == 1 && !visit[i]) {
                visit[i] = true;
                child += dfs(n, i);
            }
        }
        answer = Math.min(answer, Math.abs(child - (n - child)));

        return child;
    }
    public int solution(int n, int[][] wires) {
        answer = n;
        map = new int[n + 1][n + 1];
        visit = new boolean[n + 1];

        for (int[] x : wires) {
            int a = x[0];
            int b = x[1];

            map[a][b] = 1;
            map[b][a] = 1;
        }
        dfs(n, 1);

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
        System.out.println(T.solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}}));
        System.out.println(T.solution(7, new int[][]{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}}));
    }
}


/* 출력
[2, 3]
[6, 6]
[0, 2]
*/


// -------------------------------------------------------------------------------------------

import java.util.*;
class Solution {
    int[][] map;

    public int bfs(int n, int st) {
        int cnt = 1; //전력망 개수
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];
        q.add(st);
        visit[st] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 1; i <= n; i++) {
                if (map[now][i] == 1 && !visit[i]) {
                    q.add(i);
                    visit[i] = true;
                    cnt++;
                }
            }
        }
        // 한 곳은 cnt개, 다른 한 곳은 n - cnt
        // 그래서 n - cnt - cnt 이므로 (n-2*cnt)
        return (int) Math.abs(n-2*cnt);
    }
    public int solution(int n, int[][] wires) {
        int answer = n;
        map = new int[n + 1][n + 1];

        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            map[a][b] = 1; // 연결된 부분은 양방향으로 1로 체크.
            map[b][a] = 1;
        }

        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];

            map[a][b] = 0;
            map[b][a] = 0; // 한 부분을 끊었을 때

            // 개수가 최소인 것을 answer에 저장.
            answer = Math.min(answer, bfs(n, i + 1));

            map[a][b] = 1;
            map[b][a] = 1; // 원상 복귀
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
        System.out.println(T.solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}}));
        System.out.println(T.solution(7, new int[][]{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}}));
    }
}
