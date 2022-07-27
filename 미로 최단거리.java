import java.util.*;
class Point{ //출발~도착지점까지의 *거리를 구함
	// 도착지점의 원소값을 알아내야 하므로 class Point를 생성
	// 송아지는 몇 번 점프해야 하는지 L(레벨)을 알아야 하므로 필요없음
	public int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
class Main {
	public int solution(int[][] board){
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int[][] dist = new int[7][7]; //board는 7*7 
		Queue<Point> Q = new LinkedList<>();

		Q.offer(new Point(0,0)); //Q에 (0, 0) 넣고 시작
		board[0][0]=1; //출발을 1로 체크하고 진행

		while(!Q.isEmpty()){
			Point tmp = Q.poll();
			//L을 구하는 문제가 아니어서 len으로 Q의 사이즈를 알 필요가 없음
				for(int i=0; i<4; i++){
					int nx = tmp.x + dx[i];
					int ny = tmp.y + dy[i];
					if(nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && board[nx][ny] == 0){
						board[nx][ny] = 1;
						Q.offer(new Point(nx, ny));
						dist[nx][ny] = dist[tmp.x][tmp.y] + 1;
					}
				}
		}
		if(dist[6][6] == 0) return -1; //벽에 막혀 더이상 움직일 수 없는 경우 -1
		else return dist[6][6]; //도착하면 그 값을 리턴
	}
	public static void main(String[] args){
		Main T = new Main();
		int[][] arr={{0, 0, 0, 0, 0, 0, 0}, 
			{0, 1, 1, 1, 1, 1, 0}, 
			{0, 0, 0, 1, 0, 0, 0}, 
			{1, 1, 0, 1, 0, 1, 1}, 
			{1, 1, 0, 1, 0, 0, 0}, 
			{1, 0, 0, 0, 1, 0, 0}, 
			{1, 0, 1, 0, 0, 0, 0}};

		System.out.println(T.solution(arr));
	}
}
