import java.util.*;
class Point{
	int x, y, time;

	public Point(int x, int y){ //blue
		this.x=x;
		this.y=y;
	}

	public Point(int x, int y, int time){ //red
		this.x=x;
		this.y=y;
		this.time=time;
	}
}

class Main {
	static int n, m;
	static int x1, y1, x2, y2;
	static int result = -1;
	static char[][] map;
	static boolean[][][][] visit;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	private static void bfs(int x1, int y1, int x2, int y2) {
		Queue<Point> redQ = new LinkedList<>();
		Queue<Point> blueQ = new LinkedList<>();

		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(map[i][j] == 'R'){
					redQ.offer(new Point(i, j, 0)); // red 현재 위치
				}
				else if(map[i][j] == 'B'){
					blueQ.offer(new Point(i, j)); // blue 현재 위치
				}
			}
		}

		visit[Point.x1][Point.y1][Point.x2][Point.y2] = true; //빨간, 파란 공 위치 방문처리.

		while(!blueQ.isEmpty() && !redQ.isEmpty()){ //visit 를 한 번에 처리해주기 위해서 Q를 2개 해줌.
			Point tmpR = redQ.poll();
			Point tmpB = blueQ.poll();

			if(tmpR.time > 10){
				result = -1;
				return;
			}
			
			if(tmpR.x1)

			for(int i=0; i<4; i++){
				//기울일 때 #을 만날 때까지 이동하기 때문에 while
				int bx = tmpB.x2;
				int by = tmpB.y2;
				while(true){
					bx = tmpB.x2 + dx[i];
					by = tmpB.y2 + dy[i];

					if(map[bx][by] == 'O') break;
					else if(map[bx][by] == '#'){
						bx -= dx[i];
                        by -= dy[i];
                        break;
					}
				}

				int rx = tmpR.x1;
				int ry = tmpR.y1;
				while(true){
					rx = tmpR.x1 + dx[i];
					ry = tmpR.y1 + dy[i];

					if(map[rx][ry] == 'O') break;
					else if(map[rx][ry] == '#'){
						rx -= dx[i];
                        ry -= dy[i];
                        break;
					}
				}

				//두 구슬이 만날 경우
				if(rx == bx && ry == by && map[rx][ry] != 'O'){

				}


				if(!visit[rx][tmp.y1][tmp.x2][tmp.y2]) {
                    // 방문처리
                    visit[rx][tmp.y1][tmp.x2][tmp.y2] = true;
                    // 두 구슬을 큐에 추가
                    redQ.offer(new Ball(rx, ry, tmpR.count + 1));
                    blueQ.offer(new Ball(bx, by, tmpB.count + 1));
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

		bfs(x1, y1, x2, y2);
		System.out.println("답은 = {}", result);
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
*/

/* 출력
5
*/
