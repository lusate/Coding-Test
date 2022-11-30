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
	static int[] dis = {1,2,4,8};
	static int room, maxRoom, wallRoom = 0;
	static int[][][] wallCount; // [0] 방의 id 저장, [1] 이어진 방의 개수.
	//벽을 id 기준으로 나눈 결과와 벽을 이어진 칸수로 나눈 결과를 알 수 있다.
	private static void bfs(int x, int y, int id){
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(x, y));
		visit[x][y] = true;
		ArrayList<Point> back = new ArrayList<>(); // 현재 위치의 좌표들을 저장.
		int tempRoom=0; // 방 개수로 이동할 때마다 1씩 증가시킨다.
		
		while(!Q.isEmpty()){
			Point tmp = Q.poll();
			tempRoom++;
			back.add(new Point(tmp.x, tmp.y));

			for(int i=0; i<4; i++){
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				// << 는 시프트 연산으로 왼쪽으로 비트를 옮긴다.
				// (1 << i) 를 하게 되면 1,2,4,8이 된다.
				// &는 두 비트가 모두 1일 때 1을 반환.
				if((board[tmp.x][tmp.y] & dis[i]) == 0){ //벽이 없은 경우.
					// ex) board[0][0] 은 11로 벽이 있는 방향은 1,2,8 이다. 값이 0이 되는 경우는
					// (1 << i) 가 4인 경우이다. 즉 4 방향인 동쪽이 벽이 없다.
					if(nx >= 0 && nx < m && ny >= 0 && ny < n && !visit[nx][ny]){
						visit[nx][ny] = true;
						Q.offer(new Point(nx, ny));
					}
				}
			}

			maxRoom = Math.max(maxRoom, tempRoom); //가장 넓은 방의 넓이.
			for(Point P : back){
				wallCount[P.x][P.y][0] = id;
				wallCount[P.x][P.y][1] = tempRoom;
			}
			/* id를 기준으로 나눈 결과           벽을 이어진 칸수로 나눈 결과
			 * 0 0 1 1 2 2 2					9 9 3 3 8 8 8
			 * 0 0 0 1 2 3 2					9 9 9 3 8 1 8
			 * 0 0 0 4 2 4 2					9 9 9 7 8 7 8
			 * 0 4 4 4 4 4 2					9 7 7 7 7 7 8
			 */
		}
	}
	private static void MaxRoom(){
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				for(int d=0; d<4; d++){
					int nx = i + dx[d];
					int ny = j + dy[d];

					if(nx>=0 && nx<m && ny>=0 && ny<n && wallCount[i][j][0] != wallCount[nx][ny][0]){ //현재 위치와 이동한 위치가 같지 않음
						//같지 않다는 것은 벽이 있다는 것.
						wallRoom = Math.max(wallRoom, wallCount[i][j][1] + wallCount[nx][ny][1]);
						//그 2개의 위치를 더해준다. 그 때 최대가 나오는 값이 하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기.
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
					bfs(i, j, room); //이동할 수 있는 벽이 없을 때까지 이동하고 나서
					//이동할 수 없게되면 room++;
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
