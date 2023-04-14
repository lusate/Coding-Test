import java.util.*;
class Solution{
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public int solution(String dirs) {
        int answer = 0;
        int[][] map = new int[11][11];
        //방향에 따라 방문처리 해줘야 하므로 3차원
        boolean[][][] visit = new boolean[11][11][4];

        // 최소 거리를 구하는 문제가 아니므로 bfs를 사용할 필요가 없다!!!!!
        int x = 5, y = 5;
        for (int i = 0; i < dirs.length(); i++) {
            char ch = dirs.charAt(i);

            int k = 0;
            if (ch == 'U') {
                k = 0;
            } else if (ch == 'R') {
                k = 1;
            } else if (ch == 'D') {
                k = 2;
            } else if (ch == 'L') {
                k = 3;
            }

            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx < 0 || ny < 0 || nx >= 11 || ny >= 11) continue;

            if(!visit[nx][ny][k]){
                visit[nx][ny][k] = true;
                // UDU처럼 왕복을 하면 다시 돌아올 경우도 처리해야 하므로 시작 위치도 true로 초기화한다.
                // 다시 원래 자리이므로 k도 다시 초기화 해줘야 함.
                k = (k % 2 == 0) ? 2 - k : 4 - k;
                visit[x][y][k] = true;
                answer++;
            }
            x = nx;
            y = ny;
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution("ULURRDLLU"));
        System.out.println(T.solution("LULLLLLLU"));
        System.out.println(T.solution("UDU"));
    }
}


/* 출력
7
7
1
*/
