import java.util.*;
class Point{
	public int x;
	public int y;
	public int wall; //벽을 부시면서 왔는지 아닌지(0|1) 1이면 벽을 부심.
	public int day; //낮을 때 벽을 부쉴 수 있고 밤에는 불가능

	public Point(int x, int y, int day, int wall){
		this.x = x;
		this.y = y;
		this.day = day;
		this.wall = wall;
	}
}
class Main {
	static int n, m, k;
	static int[][] board;
	static int[][][][] dist; //크기 n*m과 낮밤으로 2, 벽 개수k
	public int solution(int x, int y){
		int answer = Integer.MAX_VALUE;
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};

		Queue<Point> Q = new LinkedList<>();
		dist[0][0][0][0] = 1;
		Q.offer(new Point(0,0,0,0));

		while(!Q.isEmpty()){
			Point tmp = Q.poll();
			for(int i=0; i<4; i++){
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				// 현재 위치가 낮인지 밤인지는 알 수 없는 상태이다. 
				if(nx >= 0 && nx < n && ny >= 0 && ny < m){
					if(tmp.day == 0){ //현재 낮인 경우
						// 현재 위치를 밤에 방문한 적이 없으면(처음 시작점)
						if(dist[tmp.x][tmp.y][1][tmp.wall] == 0){
							//현재 위치를 밤으로 변경
							dist[tmp.x][tmp.y][1][tmp.wall] = dist[tmp.x][tmp.y][0][tmp.wall]+1;
							Q.offer(new Point(tmp.x, tmp.y, 0, tmp.wall));
						}
						//다음 위치를 방문하지 않았고 다음 위치가 밤에 방문한 적이 없으면
						if(board[nx][ny] == 0 && dist[nx][ny][1][tmp.wall] == 0){
							dist[nx][ny][1][tmp.wall] = dist[tmp.x][tmp.y][0][tmp.wall]+1;
							Q.offer(new Point(nx, ny, 1, tmp.wall));
						}
						//다음 위치가 벽, 다음 위치를 밤에 방문한 적이 없으면
						if(board[nx][ny] == 1 && tmp.wall + 1 <= k && dist[nx][ny][1][tmp.wall+1] == 0){
							dist[nx][ny][1][tmp.wall+1] = dist[tmp.x][tmp.y][0][tmp.wall]+1;
							Q.offer(new Point(nx, ny, 1, tmp.wall+1));
						}
					}
					else{//현재 밤
						//현재 위치를 낮에 방문한 적이 없으면 (처음 시작점)
						if(dist[tmp.x][tmp.y][0][tmp.wall] == 0){
							dist[tmp.x][tmp.y][0][tmp.wall] = dist[tmp.x][tmp.y][1][tmp.wall]+1;
							Q.offer(new Point(tmp.x, tmp.y, 0, tmp.wall));
						}
						//다음 위치 방문한 적이 없고 
						if(board[nx][ny] == 0 && dist[nx][ny][tmp.day][tmp.wall] == 0){
							dist[nx][ny][0][tmp.wall] = dist[tmp.x][tmp.y][1][tmp.wall] + 1;
							Q.offer(new Point(nx, ny, 0, tmp.wall));
						}
					}
				}
			}
		}

		for(int i=0; i<=k; i++){
			if(dist[n-1][m-1][0][i] != 0){
				answer = Math.min(answer, dist[n-1][m-1][0][i]);
			}
			if(dist[n-1][m-1][1][i] != 0){
				answer = Math.min(answer, dist[n-1][m-1][1][i]);
			}
		}
		return answer != Integer.MAX_VALUE ? answer : -1;
	}
		
	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
 
        n = sc.nextInt();
        m = sc.nextInt();
		k = sc.nextInt();
        sc.nextLine();
		board = new int[n][m];
		dist = new int[n][m][2][k+1];
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }
 
        System.out.println(T.solution(1, 1));
	}
}
