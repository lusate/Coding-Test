import java.util.*;

class Main{
    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};
    static int r, c, answer;
    static boolean[][] visit;
    static char[][] map;
    static boolean flag;

    public static void dfs(int cnt, int x, int y) {
        if(cnt == c-1){
            flag = true;
            answer++;
            return;
        }

        for (int k = 0; k < 3; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && ny >= 0 && nx < r && ny < c && map[nx][ny] != 'x' && !visit[nx][ny]) {
                visit[nx][ny] = true;
                dfs(cnt + 1, nx, ny);
                if(flag) break;
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();

        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String s = sc.next();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        visit = new boolean[r][c];
        answer = 0;

        for (int i = 0; i < r; i++) {
            flag = false;
            dfs(0, i, 0);
        }

        System.out.println(answer);

    }
}


/* 입력
5 5
.xx..
..x..
.....
...x.
...x.


6 10
..x.......
.....x....
.x....x...
...x...xx.
..........
....x.....
*/


/* 출력
2
5
*/
