import java.util.*;
class Point{
	int x,y;
	Point(int x, int y){
		this.x=x;
		this.y=y;
	}
}

class Main {
	static int n, m;
	static int answer = Integer.MIN_VALUE;
	static int[][] map;
	static int[][] copy;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	private static void dfs(int cnt) { //벽 3개 세웠을 때 
		if(cnt == 3){
			//벽이 3개면 바이러스 퍼뜨림. 0개 개수 구함
			bfs();
			return;
		}
		else{
			for(int i=0; i<n; i++){
				for(int j=0; j<m; j++){
					if(map[i][j] == 0){
						map[i][j] = 1;
						dfs(cnt+1); //벽 개수 추가.
						map[i][j] = 0;
					}
				}
			}
		}
	}
	private static void bfs() { //바이러스 퍼짐
		Queue<Point> Q = new LinkedList<>();
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				copy[i][j] = map[i][j];
			}
		}
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(copy[i][j] == 2){
					Q.offer(new Point(i,j));
				}
			}
		}

		while(!Q.isEmpty()){
			Point tmp = Q.poll();
			for(int i=0; i<4; i++){
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<m){
					if(copy[nx][ny] == 0){ //0이면 이동
						copy[nx][ny] = 2;
						Q.offer(new Point(nx, ny));
					}
				}
			}
		}

		//0의 개수 세기
		int cnt = 0;
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(copy[i][j] == 0) cnt++;
			}
		}
		answer = Math.max(answer, cnt);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		copy = new int[n][m];
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				map[i][j] = sc.nextInt();
			}
		}
		//copy = map;
		dfs(0);
		System.out.println(answer);
	}
}





/* 입력
7 7
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0



4 6
0 0 0 0 0 0
1 0 0 0 0 2
1 1 1 0 0 2
0 0 0 0 0 2
*/


/* 출력
27


9
*/
