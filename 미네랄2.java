import java.util.*;
class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int r, c;
    static char[][] map;
    static boolean visit[][];
    public static void remove(int h, int num){
        h = r - h;
        if (num % 2 == 0) { //왼쪽부터 미네랄 없앰
            for (int i = 0; i < c; i++) {
                if(map[h][i] == 'x'){
                    map[h][i] ='.';
                    break; //하나만 제거하고 막대기가 사라짐.
                    // 문제에서 칸의 미네랄이 모두 제거된다고 함.
                }
            }
        }

        else{
            for (int i = c - 1; i >= 0; i--) {
                if (map[h][i] == 'x') {
                    map[h][i] = '.';
                    break;
                }
            }
        }
    }
    public static void bfs() { //미네랄 이동
        Queue<int[]> q = new LinkedList<>();

        for (int j = 0; j < c; j++) { //땅과 붙어있는 미네랄을 탐색
            if (map[r - 1][j] == 'x' && !visit[r - 1][j]) {
                q.add(new int[]{r - 1, j});
                visit[r-1][j] = true;
            }// 밑바닥의 x를 q에 넣고 방문처리 해줌.

            while (!q.isEmpty()) {
                int[] now = q.poll();

                for (int k = 0; k < 4; k++) {
                    int nx = now[0] + dx[k];
                    int ny = now[1] + dy[k];

                    if (nx>=0 && nx<r && ny>=0 && ny<c && map[nx][ny] =='x' && !visit[nx][ny]) {
                        q.add(new int[]{nx, ny});
                        visit[nx][ny] = true;
                    }
                }
            }// 밑바닥 위 줄의 x들은 더 이상 아래로 떨어질 수 없기 때문에 true로 해놓은 것
        }

        //공중에 떠있는 미네랄 찾음
        ArrayList<int[]> up = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'x' && !visit[i][j]) {
                    up.add(new int[]{i, j});
                    map[i][j] = '.';
                    visit[i][j] = true;
                }
            }
        }

        //찾은 미네랄 이동.
        if (!up.isEmpty()) {
            boolean stop = false;
            while (!stop) {
                for (int i = 0; i < up.size(); i++) {
                    int nx = up.get(i)[0] + 1; // 찾은 미네랄 한칸 아래로
                    if (nx >= r || map[nx][up.get(i)[1]] == 'x') { //길이가 범위를 벗어나거나 미네랄이라면 stop
                        stop = true;
                        break;
                    }
                }

                if(!stop){ //내려갈 수 있으면 한칸 내림.
                    for (int[] x : up) {
                        x[0]++;
                    }
                }
            }

            for (int i = 0; i < up.size(); i++) {
                map[up.get(i)[0]][up.get(i)[1]] = 'x';
            }
        }
    }
    public static void main(String[] args) {
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

        //n번 던짐
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int len = sc.nextInt(); //밑 바닥부터 길이 셈
            remove(len, i);
            visit = new boolean[r][c];

            bfs();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
