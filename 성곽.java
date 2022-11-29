import java.util.*;
class Point{
	public int x, y;
	public Point(int x, int y){
		this.x=x;
		this.y=y;
	}
}
class Main {
	static int m,n;
	static int[][] board;
	static boolean[][] visit;
	static int[] dx = {0, -1, 0, 1}; //서북동남 순서대로.
	static int[] dy = {-1, 0, 1, 0};
	static int room, maxRoom, wallRoom = 0;
	static int[][][] wallCount;
	private static void bfs(int x, int y, int id){
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(x, y));
		visit[x][y] = true;
		ArrayList<Point> back = new ArrayList<>(); //?
		int tempRoom=0; //?
		
		while(!Q.isEmpty()){
			Point tmp = Q.poll();
			tempRoom++;
			back.add(new Point(tmp.x, tmp.y));

			for(int i=0; i<4; i++){
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if((board[tmp.x][tmp.y] & (1 << i)) == 0){ // 벽이 없는 경우
					if(nx >= 0 && nx < m && ny >= 0 && ny < n && !visit[nx][ny]){
						visit[nx][ny] = true;
						Q.offer(new Point(nx, ny));
					}
				}
			}

			maxRoom = Math.max(maxRoom, tempRoom);
			for(Point P : back){
				wallCount[P.x][P.y][1] = tempRoom;
				wallCount[P.x][P.y][0] = id;
			}
		}
	}
	private static void MaxRoom(){
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				for(int d=0; d<4; d++){
					int nx = i + dx[d];
					int ny = j + dy[d];

					if(nx>=0 && nx<m && ny>=0 && ny<n && wallCount[i][j][0] != wallCount[nx][ny][0]){
						wallRoom = Math.max(wallRoom, wallCount[i][j][1] + wallCount[nx][ny][1]);
					}
				}
			}
		}
	}
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		board = new int[m][n];
		visit = new boolean[m][n];
		wallCount = new int[m][n][2];

		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				board[i][j] = sc.nextInt();
			}
		}


		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(!visit[i][j]){
					bfs(i, j, room);
					room++;
				}
			}
		}

		MaxRoom();
		System.out.println(room); //이 성에 있는 방의 개수
		System.out.println(maxRoom); //가장 넓은 방의 넓이
		System.out.println(wallRoom); //하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기.
    }
}


/* 입력
7 4
11 6 11 6 3 10 6
7 9 6 13 5 15 5
1 10 12 7 13 7 5
13 11 10 8 10 12 13
*/

/* 출력
5
9
16
*/
