import java.util.*;
class Point{
	public int x;
	public int y;
	public int count; //이동거리
	public int wall; //벽을 부시면서 왔는지 아닌지(0|1) 1이면 벽을 부심.

	public Point(int x, int y, int count, int wall){
		this.x = x;
		this.y = y;
		this.count = count; //이동거리
		this.wall = wall; //0이면 벽을 부시지 않음 / 1이면 벽을 부쉼
	}
}
class Main {
	static int n, m;
	static int[][] board;
	static boolean[][][] visited;
	//int[][] dist = new int[n][m];
	
	public int solution(int x, int y){
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};

		Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y, 1, 0));
        visited[x][y][0] = true; //0은 벽을 부시지 않고 방문한 노드의 방문 여부
        visited[x][y][1] = true; //1은 벽을 부시면서 방문한 노드의 방문 여부
 
        while (!q.isEmpty()) {
          Point cur = q.poll();
          //cur.x , cur.y는 현재 좌표
          if (cur.x == n - 1 && cur.y == m - 1) return cur.count;
          // 문제에서  (1, 1)과 (N, M)은 항상 0이라고 가정하자. 이동거리를 리턴
 
          for (int i = 0; i < 4; i++) {
            int nx = cur.x + dx[i];
            int ny = cur.y + dy[i];
 
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
              if(board[nx][ny] == 0) { //벽이 아닐 때
                //현재까지 온 방법
                if (visited[nx][ny][cur.wall] == false) { 
                //(벽을 부쉈는지 아닌지)으로 방문한 적이 없다면 방문한다.
                  q.add(new Point(nx, ny, cur.count + 1, cur.wall));
                  visited[nx][ny][cur.wall] = true;
                  }
              }    
              else if (board[nx][ny] == 1) { //벽일때
                if (cur.wall == 0 && visited[nx][ny][1] == false) { //현재까지 벽을 부순적이 없고, 벽을 부숴서 방문한 적이 없다면 방문한다.
                  q.add(new Point(nx, ny, cur.count + 1, 1));
                  visited[nx][ny][1] = true;
                }
              }
            }
          }
        }
 
        return -1;
	}
		
	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
 
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        
        board = new int[n][m];
        for (int i = 0; i < n ; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }
 
        visited = new boolean[n][m][2];
        System.out.println(T.solution(0, 0));
	}
}
