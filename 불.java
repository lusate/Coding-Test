import java.util.*;
class Point{
	int x, y;
	static int time;
	public Point(int x, int y, int time){
		this.x=x;
		this.y=y;
		this.time = time;
	}
}
class Solution{
	static int r,c,answer;
	static char[][] board;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Queue<Point> Q1 = new LinkedList<>(); //지훈
	static Queue<Point> Q2 = new LinkedList<>(); //불
	public static boolean bfs() {
		while(!Q1.isEmpty()) {
			int fire_len = Q2.size();
			for(int i=0; i<fire_len; i++) {
				Point tmp = Q2.poll();
				for(int d=0; d<4; d++) {
					int nx = tmp.x + dx[d];
					int ny = tmp.y + dy[d];
					if(nx >= 0 && nx < r && ny >= 0 && ny < c) {
						if(board[nx][ny] != '#' && board[nx][ny] != 'F') {
							Q2.offer(new Point(nx, ny, Point.time+1));
						}
					}
				}
			}
			
			int ji_len = Q1.size();
			for(int i=0; i<ji_len; i++) {
				Point tmp = Q1.poll();
				for(int d=0; d<4; d++) {
					int nx = tmp.x + dx[d];
					int ny = tmp.y + dy[d];
					if(nx >= 0 && nx < r && ny >= 0 && ny < c) {
						if(board[nx][ny] != '#' && board[nx][ny] != 'F' && board[nx][ny] != 'J') {
							answer = Point.time + 1;
							Q1.offer(new Point(nx, ny, Point.time+1));
							board[nx][ny] = 'J';
						}
					}
					
				}
			}
			
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		board = new char[r][c];
		
		for(int i=0; i<r; i++) {
			String tmp = sc.next();
			
			for(int j=0; j<c; j++) {
				board[i][j] = tmp.charAt(j);
				if(board[i][j] == 'J') {
					Q1.offer(new Point(i, j, 0));
				}
				if(board[i][j] == 'F') {
					Q2.offer(new Point(i, j, 0));
				}
				
			}
		}
		answer = 0;
		if(bfs()) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(answer);
		}
	}
}


/* 입력
4 4
####
#JF#
#..#
#..#
*/

/* 출력
3
*/
