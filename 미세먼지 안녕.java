/*
***암기
* 반시계 방향 -> 아래,왼,위,오른
* 시계 방향 -> 위,왼,아래,오른
*/

import java.util.*;
class Point{
	public int x, y, w;
	public Point(int x, int y, int w){
		this.x=x;
		this.y=y;
		this.w=w;
	}
}
public class Main {
	static int r,c,t;
	static int[][] map;
	static int cleaner = -1;
	static Queue<Point> Q;
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};

	private static void bfs() {
		while(!Q.isEmpty()){ //미세먼지 확산
			Point tmp = Q.poll();
			//int amount = tmp.w / 5;
			int cnt = 0; // 확산되는 방향 개수.
			for(int i=0; i<4; i++){
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if(nx>=0 && nx<r && ny>=0 && ny<c){
					if(map[nx][ny] == -1) continue; //공기청정기 있으면 패스.
					
					map[nx][ny] += tmp.w/5; //확산했을 때 미세먼지 양
					++cnt;
				}
			}
			map[tmp.x][tmp.y] -= (tmp.w / 5) * cnt; //현재 남은 미세먼지 양
		}

		//공기 청정기 움직임.
		//공기 청정기 움직이는 방향으로 미세먼지가 한 칸씩 밀려감.
		// 시계 방향으로 이동
		int top = cleaner; //위쪽 공기 청정기 위치.
		int down = cleaner + 1; //아래쪽 공기 청정기 위치.

		//위쪽 공기 청정기 이동 (반시계방향)
		for(int i=top-1; i>0; i--){ //아래쪽으로 이동.
			map[i][0] = map[i-1][0];
		}
		for(int i=0; i<c-1; i++){ //왼쪽으로 이동.
			map[0][i] = map[0][i+1];
		}
		for(int i=0; i<top; i++){ //위쪽으로 이동.
			map[i][c-1] = map[i+1][c-1];
		}
		for(int i=c-1; i>1; i--){ //오른쪽으로 이동.
			map[top][i] = map[top][i-1];
		}
		
		
		map[top][1] = 0;


		//아래쪽 공기 청정기 이동(시계방향)
		for(int i=down+1; i<r-1; i++){ //위쪽으로 이동
			map[i][0] = map[i+1][0];
		}
		for(int i=0; i<c-1; i++){ //왼쪽으로 이동
			map[r-1][i] = map[r-1][i+1];
		}
		for(int i=r-1; i>down; i--){ //아래쪽으로 이동
			map[i][c-1] = map[i-1][c-1];
		}
		for (int i = c - 1; i > 1; i--){ //오른쪽으로 이동
            map[down][i] = map[down][i-1];
		}
		map[down][1] = 0;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		t = sc.nextInt(); //t초
		map = new int[r][c];

		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				map[i][j] = sc.nextInt();
				if(map[i][j] == -1 && cleaner == -1){
					cleaner = i;
				}
			}
		}

		for(int time=0; time<t; time++){
			//미세먼지가 있는지 확인.
			Q = new LinkedList<>();

			for(int i=0; i<r; i++){
				for(int j=0; j<c; j++){
					if(map[i][j] == -1 || map[i][j] == 0){
						continue;
					}
					Q.offer(new Point(i, j, map[i][j]));
				}
			}

			bfs();
		}

		int answer = 0; //총 남은 미세먼지 양
		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				if(map[i][j] == -1) continue;
				answer += map[i][j];
			}
		}

		System.out.println(answer);
	}
}


/* 입력
7 8 1
0 0 0 0 0 0 0 9
0 0 0 0 3 0 0 8
-1 0 5 0 0 0 22 0
-1 8 0 0 0 0 0 0
0 0 0 0 0 10 43 0
0 0 5 0 15 0 0 0
0 0 40 0 0 0 20 0


7 8 3
0 0 0 0 0 0 0 9
0 0 0 0 3 0 0 8
-1 0 5 0 0 0 22 0
-1 8 0 0 0 0 0 0
0 0 0 0 0 10 43 0
0 0 5 0 15 0 0 0
0 0 40 0 0 0 20 0
*/

/* 출력
188

186
*/
