import java.util.*;
import java.io.*;
class Point{
	public int x, y;
	public Point(int x, int y){
		this.x=x;
		this.y=y;
	}
}
class Main {
	static int n;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0,- 1, 0, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		// 높이가 height 이하인 지점을 모두 잠기게 만든다.
		// 즉 map 에서 최대값인 9가 height로 9이하인 지점을 모두 잠기게 할 수도 있다.
		// 그래서 maxHeight를 구해서 height가 0~9까지 일 경우를 모두 탐색한다.
		int maxHeight=0;
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > maxHeight) {
					maxHeight = map[i][j];
				}
			}
		}
		
		int max = 0;
		// 1. 모든 지역 탐색
		for(int height=0; height<=maxHeight; height++) {
			visit = new boolean[n][n];
			int cnt=0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					// 2. 안전 영역 탐지
					// 현재 위치가 height보다 크고 방문하지 않았다면
					if(map[i][j] > height && !visit[i][j]){
						cnt+=bfs(i,j,height); // 해당 안전영역 탐색 시작
					}
				}
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}
	
	private static int bfs(int x, int y, int height) {
		Queue<Point> Q = new LinkedList<>();
		Q.add(new Point(x,y));
		visit[x][y] = true;
	
		while(!Q.isEmpty()) {
			Point tmp = Q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				
				if(nx>=0 && ny>=0 && nx<n && ny<n && !visit[nx][ny]){
					if(map[nx][ny] > height){
						visit[nx][ny] = true;
						Q.offer(new Point(nx, ny));
					}
				}
			}
		}
		return 1;
	}
}


/* 입력
5
6 8 2 6 2
3 2 3 4 6
6 7 3 3 2
7 2 5 3 6
8 9 5 2 7


7
9 9 9 9 9 9 9
9 2 1 2 1 2 9
9 1 8 7 8 1 9
9 2 7 9 7 2 9
9 1 8 7 8 1 9
9 2 1 2 1 2 9
9 9 9 9 9 9 9
*/


/* 출력
5

6
*/
