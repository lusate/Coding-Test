import java.util.*;
class Point{
	public int x;
	public int y;
	public int cost;
	Point(int x, int y, int cost){
		this.x=x;
		this.y=y;
		this.cost = cost;
	}
}
class Main{
	int[] dx = {-1, 0, 1, 0};
	int[] dy = {0, 1, 0, -1};
	boolean[][] visited;
	int n, m;
	public int solution(int[][] maps){
		n = maps.length; // maps 행 개수
		m = maps[0].length; // maps 열 개수
		visited = new boolean[n][m];
		
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(0,0,1));
		while(!Q.isEmpty()){
			Point tmp = Q.poll();
			if(tmp.x == n-1 && tmp.y == m-1) return tmp.cost;

			for(int i=0; i<4; i++){
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if(nx >= 0 && nx < n && ny >= 0 && ny < m){
					if(maps[nx][ny] == 1 && !visited[nx][ny]){
						visited[nx][ny] = true;
						Q.offer(new Point(nx, ny, tmp.cost + 1));
					}
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args){
		Main T = new Main();
		int[][] map = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		System.out.println(T.solution(map));
	}
}
