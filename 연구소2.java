import java.util.*;
class Point {
	int x, y, time;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }

	public Point(int x, int y, int time) {
		this.x = x;
		this.y = y;
        this.time = time;
	}
}
public class Main {
	static int n,m, count = 0, answer = Integer.MAX_VALUE;
    static Point sel[];
    static int[][] map;
    static boolean[][] visit;
    static ArrayList<Point> arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
 
    private static void dfs(int idx, int cnt) {
        if (cnt == m) {
            bfs();
            return;
        }
 
        if(idx == arr.size()){
            return;
        }
        
        sel[cnt] = arr.get(idx);
        dfs(idx+1, cnt+1);
        dfs(idx+1, cnt);
    }
 
    private static void bfs() {
        int zero = count;
        Queue<Point> Q = new LinkedList<>();

        for(int i=0; i<m; i++){
            visit[sel[i].x][sel[i].y] = true;
			Q.offer(new Point(sel[i].x, sel[i].y, 0));
        }

        int time = 0;
        while(!Q.isEmpty()){
            Point tmp = Q.poll();
            time = tmp.time;
            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<n && !visit[nx][ny]){
                    if(map[nx][ny] != 1){
                        Q.offer(new Point(nx, ny, tmp.time+1));
                        visit[nx][ny] = true;
                    }

                    if(map[nx][ny] == 0){
                        zero--;
                    }
                }
            }
        }

        if(zero == 0){
            answer = Math.min(answer, time);
        }
        
    }


    public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
 
        map = new int[n][n];
        visit = new boolean[n][n];
        arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 2) arr.add(new Point(i, j)); //현재 바이러스 설치 가능한 위치.
                if (map[i][j] == 0) count++; // 0 개수.
            }
        }
 
        sel = new Point[m];
        dfs(0, 0);
        System.out.println((answer == Integer.MAX_VALUE) ? -1 : answer);
    }
}


/* 입력
7 3
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 2 0 1 1
0 1 0 0 0 0 0
2 1 0 0 0 0 2



7 4
2 0 2 0 1 1 0
0 0 1 0 1 2 0
0 1 1 2 1 0 0
2 1 0 0 0 0 2
0 0 0 2 0 1 1
0 1 0 0 0 0 0
2 1 0 0 2 0 2



7 2
2 0 2 0 1 1 0
0 0 1 0 1 0 0
0 1 1 1 1 0 0
2 1 0 0 0 0 2
1 0 0 0 0 1 1
0 1 0 0 0 0 0
2 1 0 0 2 0 2
*/

/* 출력
5

4

-1
*/
