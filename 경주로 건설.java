import java.util.*;
class Solution{
	int[] dx = new int[]{-1, 0, 1, 0};
    int[] dy = new int[]{0, 1, 0, -1};
	public int solution(int[][] board) {
		int answer = Integer.MAX_VALUE;
		int n = board.length;
		// 들어오는 방향에 따라 비용이 달라지므로 3자원 배열.
		int[][][] costs = new int[n][n][4];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				Arrays.fill(costs[i][j], Integer.MAX_VALUE);

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0, -500, -1 }); 
		// 처음에 방향이 -1 이기 때문에 k와 같지 않아서 비용을 500 더한 상태에서 시작함.
        // 시작점에서 아래, 오른쪽 두 방향 모두 코너로 간주하기 때문에 비용 -500으로 설정

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			// 끝점 도달하면 최솟값 갱신
			if (cur[0] == n - 1 && cur[1] == n - 1) {
				answer = Integer.min(answer, cur[2]);
			}

			for (int k = 0; k < 4; k++) {
				int nx = cur[0] + dx[k];
				int ny = cur[1] + dy[k];

				if (nx < 0 || ny < 0 || nx >= n || ny >= n || board[nx][ny] == 1) continue;

				// 직전 탐색한 방향과 같은 방향으로 진행
				// 직선 도로를 놓았을 때 costs 보다 적은 비용일 때만 진행
				if (k == cur[3] && costs[nx][ny][k] > cur[2] + 100) {
					costs[nx][ny][k] = cur[2] + 100;
					q.offer(new int[] { nx, ny, cur[2] + 100, k});
				}

				// 코너 돌 때 costs 보다 적은 비용일 때만 진행
				else if (k != cur[3] && costs[nx][ny][k] > cur[2] + 600) {
					costs[nx][ny][k] = cur[2] + 600;
					q.offer(new int[] { nx, ny, cur[2] + 600, k});
				}
			}
		}

		return answer;
	}

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}));
		System.out.println(T.solution(new int[][]{{0,0,0,0,0,0,0,1}, {0,0,0,0,0,0,0,0}, 
		{0,0,0,0,0,1,0,0}, {0,0,0,0,1,0,0,0}, {0,0,0,1,0,0,0,1}, {0,0,1,0,0,0,1,0}, 
		{0,1,0,0,0,1,0,0}, {1,0,0,0,0,0,0,0}}));

		System.out.println(T.solution(new int[][]{{0,0,0,0,0,0}, {0,1,1,1,1,0}, 
		{0,0,1,0,0,0}, {1,0,0,1,0,1}, {0,1,0,0,0,1}, {0,0,0,0,0,0}}));
	}
}


// ------------ ------------ ------------ ------------ ------------ ------------ ------------


import java.util.*;
class Point{
	int x, y, dir, total;
	Point(int x, int y, int dir, int total){
		this.x=x;
		this.y=y;
		this.dir=dir;
		this.total=total;
	}
}
class Solution {
	int[] dx = {0, 1, 0, -1};
	int[] dy = {-1, 0, 1, 0};
	int INF = 10000000;
	public int solution(int[][] board) {
		int answer = INF;
		int n = board.length;

		int[][] cost = new int[n][n];
		int[][] map = board;

		for(int i=0; i<n; i++){
			Arrays.fill(cost[i], INF);
		}

		cost[0][0] = 0;

		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0, 0, -1, 0));
		while(!q.isEmpty()){
			Point now = q.poll();
			if(now.x == n-1 && now.y == n-1){
				answer = Math.min(answer, now.total);
			}

			for(int k=0; k<4; k++){
				int nx = now.x + dx[k];
				int ny = now.y + dy[k];
				
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || board[nx][ny] == 1 || cost[nx][ny] <= now.total) continue;

				if(now.dir == -1 || now.dir == k){ //처음 이동할 때 or 같은 방향
					cost[nx][ny] = now.total + 100;
					q.offer(new Point(nx, ny, k, now.total+100));
				}
				else{ // 방향 바꿀 때
					cost[nx][ny] = now.total + 100;
					q.offer(new Point(nx, ny, k, now.total+600));
				}

				// if(ny >= 0 && ny < n && nx >=0 && nx < n && map[nx][ny] == 0 && cost[nx][ny] > now.total) {
				// 	if(now.dir == -1 || now.dir == k){ //처음 이동할 때 or 같은 방향
				// 		cost[nx][ny] = now.total + 100;
				// 		q.offer(new Point(nx, ny, k, now.total+100));
				// 	}
				// 	else{ // 방향 바꿀 때
				// 		cost[nx][ny] = now.total + 100;
				// 		q.offer(new Point(nx, ny, k, now.total+600));
				// 	}
				// }
			}
		}


		return answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}));
		System.out.println(T.solution(new int[][]{{0,0,0,0,0,0,0,1}, {0,0,0,0,0,0,0,0}, 
		{0,0,0,0,0,1,0,0}, {0,0,0,0,1,0,0,0}, {0,0,0,1,0,0,0,1}, {0,0,1,0,0,0,1,0}, 
		{0,1,0,0,0,1,0,0}, {1,0,0,0,0,0,0,0}}));

		System.out.println(T.solution(new int[][]{{0,0,0,0,0,0}, {0,1,1,1,1,0}, 
		{0,0,1,0,0,0}, {1,0,0,1,0,1}, {0,1,0,0,0,1}, {0,0,0,0,0,0}}));
	}
}


/* 출력
900
3800
3200
*/
