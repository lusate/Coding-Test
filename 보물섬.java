import java.util.*;
class Point{
	public int x, y, time;
	public Point(int x, int y, int time){
		this.x=x;
		this.y=y;
		this.time = time;
	}
}
class Main {
	static int n, m;
	static int dis;
	static char[][] board;
	static boolean[][] visit;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	private static int bfs(int x, int y){
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(x, y, 0));
		visit[x][y] = true;
		//어느 한 보물에서 다른 보물이 있는 곳까지의 거리 저장

		while(!Q.isEmpty()){
			Point tmp = Q.poll();
			
			for(int i=0; i<4; i++){
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if(nx>=0 && ny>=0 && nx<n && ny<m && !visit[nx][ny] && board[nx][ny] == 'L'){
					visit[nx][ny] = true;
					Q.offer(new Point(nx, ny, tmp.time+1));
					dis = Math.max(dis, tmp.time+1);
				} //여기서 dis는 board에서 보물이 마지막 위치에 있을 때의 경우로 7임.
			} //그래서 지금까지 했던 보물의 위치를 정해준 것들을 모두 대상으로 해서 최대값을 정해주어야 함.
		}
		return dis;
	}

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		board = new char[n][m];
		
		for(int i=0; i<n; i++){
			String s = sc.next();
			for(int j=0; j<m; j++){
				board[i][j] = s.charAt(j);
			}
		}

		int answer=Integer.MIN_VALUE;
		for(int i=0; i<n; i++){
			for(int j=0; j<m ;j++){
				if(board[i][j] == 'L'){ //현재 위치가 L일 때
					visit = new boolean[n][m]; //bfs를 돌려주는데 방문처리를 항상 초기화 해야 함.
					int dis = bfs(i, j);
					answer = Math.max(answer, dis);
				}
			}
		}
		System.out.println(answer);
    }
}


/* 입력
5 7
WLLWWWL
LLLWLLL
LWLWLWW
LWLWLLL
WLLWLWW
*/


/* 출력
8
*/
