package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static boolean[][] visit;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    private static void dfs(int x, int y) {
        char ch = map[x][y];
        visit[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (!visit[nx][ny] && map[nx][ny] == ch) {
                    visit[nx][ny] = true;
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visit = new boolean[N][N];


        for (int i = 0; i < N; i++) {
            String S = br.readLine(); // RRRBB
            for (int j = 0; j < N; j++) {
                map[i][j] = S.charAt(j);
            }
        }

        // normal 인 경우
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        int normal_cnt = cnt;
        cnt=0;
        visit = new boolean[N][N];

        // dltonism 인 경우
        // G를 R로 바꿔주고 돌린다.

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j]=='G'){
                    map[i][j] = 'R'; // G를 R로 바꿔준다.
                }
            }
        }
        //

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visit[i][j]){
                    dfs(i,j);
                    cnt++;
                }
            }
        }
        int abnormal_cnt = cnt;
        System.out.println(normal_cnt + " " + abnormal_cnt);
    }
}
