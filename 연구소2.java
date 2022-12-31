import java.util.*;
class Point{
	int x,y,time;
	Point(int x, int y, int time){
		this.x=x;
		this.y=y;
		this.time=time;
	}
}
class Main {
	static int n, m;
	static int[][] map, copy;
	static int min, max;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	private static void dfs(int cnt){ //바이러스 위치.
		if(cnt == m){
			bfs();
			return;
		}
		else{
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					if(map[i][j] == 2){ //2면 바이러스 설치.
						map[i][j] = 0; //0으로 설치
						dfs(cnt+1);
						map[i][j] = 2; //다시 2로 빽
					}
				}
			}
		}
	}

	private static void bfs() { //바이러스 퍼짐
		Queue<Point> Q = new LinkedList<>();
		//원본이 아닌 바이러스가 퍼지는 copy로 bfs 돌림.
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				copy[i][j] = map[i][j];
			}
		}

		//바이러스 삽입.
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				Q.offer(new Point(i,j,0));
			}
		}

		while(!Q.isEmpty()){
			Point tmp = Q.poll();
			for(int i=0; i<4; i++){
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<n){
					//바이러스 퍼짐.
					if(copy[nx][ny] == 0){ //바이러스 퍼짐
						copy[nx][ny] = tmp.time + 1;
					}
				}
			}
		}
		
		//copy에서 최대값이 바이러스가 퍼지는 시간.
		max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				max = Math.max(max, copy[i][j]);
			}
		}

		//그런데 dfs로 바이러스 위치를 다르게 하여 다른 경우의 copy도 있으므로
		//따로 모든 경우의 copy 최대값의 최소를 구해줌.
		min = Integer.MAX_VALUE;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				min = Math.min(max, min);
			}
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][n];
		copy = new int[n][n];

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				map[i][j] = sc.nextInt();
			}
		}

		dfs(0);
		System.out.println(min);
	}
}


/* 입력
7 3
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 2 0 1 1
0 1 0 0 0 0 0
2 1 0 0 0 0 2



7 4
2 0 2 0 1 1 0
0 0 1 0 1 2 0
0 1 1 2 1 0 0
2 1 0 0 0 0 2
0 0 0 2 0 1 1
0 1 0 0 0 0 0
2 1 0 0 2 0 2



7 2
2 0 2 0 1 1 0
0 0 1 0 1 0 0
0 1 1 1 1 0 0
2 1 0 0 0 0 2
1 0 0 0 0 1 1
0 1 0 0 0 0 0
2 1 0 0 2 0 2
*/

/* 출력
5

4

-1
*/
