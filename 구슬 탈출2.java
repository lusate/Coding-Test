import java.util.*;
class Point{
	int x, y, time;
	public Point(int x, int y, int time){ 
		this.x=x;
		this.y=y;
		this.time=time;
	}
}

class Main {
	static int n, m;
	static Point rball, bball;
	static int result = -1;
	static char[][] map;
	static boolean[][][][] visit;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	private static void bfs(Point rball, Point bball) {
		Queue<Point> redQ = new LinkedList<>();
		Queue<Point> blueQ = new LinkedList<>();

		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(map[i][j] == 'R'){
					rball = new Point(i, j, 0); // red 현재 위치
				}
				else if(map[i][j] == 'B'){
					bball = new Point(i, j, 0); // blue 현재 위치
				}
			}
		}

		redQ.offer(rball);
        blueQ.offer(bball);
		
		visit[rball.x][rball.y][bball.x][bball.y] = true; //빨간, 파란 공 위치 방문처리.

		while(!redQ.isEmpty() && !blueQ.isEmpty()){ //visit 를 한 번에 처리해주기 위해서 Q를 2개 해줌.
			Point tmpR = redQ.poll();
			Point tmpB = blueQ.poll();

			if(tmpR.time > 10){
				result = -1;
				return;
			}
			
			if(map[tmpB.x][tmpB.y] == 'O'){
				continue;
			}

			if(map[tmpR.x][tmpR.y] == 'O'){
				result = tmpR.time;
				return;
			}

			for(int i=0; i<4; i++){
				//기울일 때 #을 만날 때까지 이동하기 때문에 while
				int bx = tmpB.x;
				int by = tmpB.y;
				while(true){
					bx = bx + dx[i];
					by = by + dy[i];

					if(map[bx][by] == 'O') break;
					else if(map[bx][by] == '#'){
						bx -= dx[i];
                        by -= dy[i];
                        break;
					}
				}

				int rx = tmpR.x;
				int ry = tmpR.y;
				while(true){
					rx = rx + dx[i];
					ry = ry + dy[i];

					if(map[rx][ry] == 'O') break;
					else if(map[rx][ry] == '#'){
						rx -= dx[i];
                        ry -= dy[i];
                        break;
					}
				}

				//기울였을 때 두 구슬이 만날 경우, 두 구슬이 빠져나가지 못하는 경우
				if(rx == bx && ry == by && map[rx][ry] != 'O'){
					int red = Math.abs(tmpR.x - rx) + Math.abs(tmpR.y - ry);
					int blue = Math.abs(tmpB.x - bx) + Math.abs(tmpB.y - by);

					//기울였을 때 빨강이 더 많이 움직였다면
					if(red > blue){
						rx = rx - dx[i];
						ry = ry - dy[i];
					}
					else{
						bx = bx - dx[i];
						by = by - dy[i];
					}
				}


				if(!visit[rx][ry][bx][by]) {
                    // 방문처리
                    visit[rx][ry][bx][by] = true;
                    // 두 구슬을 큐에 추가
                    redQ.offer(new Point(rx, ry, tmpR.time + 1));
                    blueQ.offer(new Point(bx, by, tmpB.time + 1));
                }
			}

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new char[n][m];
		visit = new boolean[n][m][n][m];

		for(int i=0; i<n; i++){
			String s = sc.next();
			for(int j=0; j<m; j++){
				map[i][j] = s.charAt(j);

			}
		}

		bfs(rball, bball);
		System.out.println(result);
	}
}


/* 입력
7 7
#######
#..R#B#
#.#####
#.....#
#####.#
#O....#
#######



7 7
#######
#...RB#
#.#####
#.....#
#####.#
#O....#
#######


3 10
##########
#.O....RB#
##########
*/

/* 출력
5


5


-1
*/
