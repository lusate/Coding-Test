import java.util.*;

public class 이웃한_칸 {
    static int[] dw = {0, 1, -1, 0};
    static int[] dh = {1, 0, 0, -1};
    static int n, cnt;

    private static int bfs(int h, int w, String[][] board) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{h, w});

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int k = 0; k < 4; k++) {
                int nh = tmp[0] + dh[k];
                int nw = tmp[1] + dw[k];

                if(nh < 0 || nw < 0 || nh >= n || nw >= n) continue;
                if (board[nh][nw].equals(board[tmp[0]][tmp[1]])) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public int solution(String[][] board, int h, int w) {

        n = board.length;

        // bfs 해서 cnt 구하기
        return bfs(h, w, board);
    }

    public static void main(String[] args) {
        이웃한_칸 T = new 이웃한_칸();
        System.out.println(T.solution(new String[][]{{"blue", "red", "orange", "red"}, {"red", "red", "blue", "orange"}, {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}},
                1, 1));

        System.out.println(T.solution(new String[][]{{"yellow", "green", "blue"}, {"blue", "green", "yellow"}, {"yellow", "blue", "blue"}},
                0, 1));
    }
}

/*
2
1
 */
