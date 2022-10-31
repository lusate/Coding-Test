import java.util.*;
class Point{
	public int x, y;
	Point(int x, int y){
		this.x=x;
		this.y=y;
	}
}
class Main {
	static int[] dx={-1, 0, 1, 0};
	static int[] dy={0, 1, 0, -1};
	static int[][] board, dis;
	static int n, m;
	static Queue<Point> Q=new LinkedList<>();
	public void BFS(){
		while(!Q.isEmpty()){
			Point tmp=Q.poll();
			for(int i=0; i<4; i++){
				int nx=tmp.x+dx[i];
				int ny=tmp.y+dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny]==0){
					board[nx][ny]=1;
					Q.offer(new Point(nx, ny));
					//현재 위치에서 +1하여 퍼짐
					dis[nx][ny]=dis[tmp.x][tmp.y]+1;
				}
			}
		}	
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		m=kb.nextInt();
		n=kb.nextInt();
		board=new int[n][m];
		dis=new int[n][m];
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				board[i][j]=kb.nextInt();
				if(board[i][j]==1) Q.offer(new Point(i, j));
				//익은 토마토 1이면 그 위치를 Q에 삽입 이 때가 0레벨
				//출발점이 여러 개라면 BFS 돌기 전에 미리 Q에 넣어놔야 한다.
			}
		}
		T.BFS();
		boolean flag=true;
		int answer=Integer.MIN_VALUE;
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(board[i][j]==0) flag=false;
			}
		}

		//다 익지 않았을 때가 false이므로 flag 하면 true로 다 익은 상태이다.
		if(flag){
			for(int i=0; i<n; i++){
				for(int j=0; j<m; j++){
					answer=Math.max(answer, dis[i][j]);
				}
			}
			System.out.println(answer);
		}
		else System.out.println(-1);
	}
}


/* 입력
6 4
0 0 -1 0 0 0
0 0 1 0 -1 0
0 0 -1 0 0 0
0 0 0 0 -1 1
*/

/* 출력
4
*/
