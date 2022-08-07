import java.util.*;
class Point{
	public int x;
	public int y;
	public int dist;
	public int wall;
	public Point(int x, int y, int dist, int wall){
		this.x = x;
		this.y = y;
		this.dist = dist; //이동거리
		this.wall = wall; //0이면 벽을 부시지 않음 / 1이면 벽을 부쉼
	}
}
class Main{
	static int n, m, k;
	static int[][] board;
	static boolean[][][] visited;
	public int solution(int[][] board){
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(0, 0, 1, 0));
		visited[0][0][0] = true;
		visited[0][0][1] = true;

		while(!Q.isEmpty()){
			Point tmp = Q.poll();
			for(int i=0; i<4; i++){
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<m){
					if(board[nx][ny] == 0){
						if(visited[nx][ny][tmp.wall] == false){
							visited[nx][ny][tmp.wall] = true;
							Q.offer(new Point(nx, ny, tmp.dist+1, tmp.wall));
						}
					}

					else if(board[nx][ny] == 1){
						if(tmp.wall < k && visited[nx][ny][tmp.wall+1] == false){
							visited[nx][ny][tmp.wall+1] = true;
							Q.offer(new Point(nx, ny, tmp.dist+1, tmp.wall+1));
						}
					}
				}
			}
			if (tmp.x == n - 1 && tmp.y == m - 1) return tmp.dist;
		}
		return -1;
	}
	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
 
        n = sc.nextInt();
        m = sc.nextInt();
		k = sc.nextInt();
        sc.nextLine();
        
        board = new int[n][m];
        for (int i = 0; i < n ; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }
 
        visited = new boolean[n][m][k+1];
        System.out.println(T.solution(board));
	}
	
}
