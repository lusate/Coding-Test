import java.util.*;
class Point{
	public int x, y, time;

	public Point(int x, int y){
		this.x=x;
		this.y=y;
	}

	public Point(int x, int y, int time){
		this.x=x;
		this.y=y;
		this.time=time;
	}
}
class Main {
	static int r,c;
	static int answer=Integer.MAX_VALUE;
	static char[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	//static boolean[][] visit;
	//static boolean[][] watervisit;
	static Queue<Point> water = new LinkedList<>(); //물이 이동하는 Q
	static Queue<Point> Q = new LinkedList<>(); //고슴도치가 이동하는 Q

	private static void bfs() {
		while(!Q.isEmpty()){
			int len = water.size();
			for(int i=0; i<len; i++){
				Point tmp = water.poll();
				for(int j=0; j<4; j++){
					int vx = tmp.x + dx[j];
					int vy = tmp.y + dy[j];
					//물이 이동하는 방향.
					if(vx>=0 && vy>=0 && vx<r && vy<c && (map[vx][vy] == '.' || map[vx][vy] == 'S')){
						map[vx][vy] = '*';
						water.offer(new Point(vx, vy));
						//watervisit[vx][vy] = true;
					}
				}
			}


			len = Q.size();
			for(int i=0; i<len; i++){
				Point tmp = Q.poll();
				for(int j=0; j<4; j++){
					int nx = tmp.x + dx[j];
					int ny = tmp.y + dy[j];
					if(nx>=0 && ny>=0 && nx<r && ny<c){
						if(map[nx][ny] == 'D'){ //비버 집에 도착
							answer = Math.min(answer, tmp.time+1);
							return;
						}
						else if(map[nx][ny] == '.'){
							map[nx][ny] = 'S';
							Q.offer(new Point(nx, ny, tmp.time+1));
						}
					}
				}
	
				
			}
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt(); 
		map = new char[r][c];
		//visit = new boolean[r+1][c+1];
		//watervisit = new boolean[r+1][c+1];

		for(int i=0; i<r; i++){
			String s = sc.next();
			for(int j=0; j<c; j++){
				map[i][j] = s.charAt(j);
				//map[r][c] = sc.next().charAt(j);
				if(map[i][j] == 'S'){
					Q.offer(new Point(i, j, 0));
				}
				else if(map[i][j] == '*'){
					water.offer(new Point(i, j));
				}
			}
		}

		bfs();
		if(answer == Integer.MAX_VALUE){
			System.out.println("KAKTUS");
		}
		else System.out.println(answer);
	}
}


/* 입력
3 6
D...*.
.X.X..
....S.


5 4
.D.*
....
..X.
S.*.
....
*/


/* 출력
6

4
*/
