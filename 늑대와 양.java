import java.util.*;
//늑대만 이동
class Point{
	public int x,y;
	public Point(int x, int y){
		this.x=x;
		this.y=y;
	}
}
class Main {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int r,c;
	static int result = 1;
	static char[][] map;
	private static void bfs(){
		Queue<Point> Q = new LinkedList<>();
		for(int i=0; i<r; i++){ //Q에 현재 늑대 좌표 저장.
			for(int j=0; j<c; j++){
				if(map[i][j] == 'W'){
					Q.offer(new Point(i, j));
				}
			}
		}

		while(!Q.isEmpty()){
			Point tmp = Q.poll();
			for(int i=0; i<4; i++){
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if(nx>=0 && ny>=0 && nx<r && ny<c){ //늑대 이동.
					if(map[nx][ny] == 'S'){ //늑대가 양을 만난다면 그냥 0출력.
						result = 0;
						return;
					}

					else if(map[nx][ny] == '.'){ // 늑대가 이동하는 구간 D로
						map[nx][ny] = 'D';
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

		for(int i=0; i<r; i++){
			String s = sc.next();
			for(int j=0; j<c; j++){
				map[i][j] = s.charAt(j);
			}
		}

		bfs();
		System.out.println(result);

		if(result == 1){
			for(int i=0; i<r; i++){
				for(int j=0; j<c; j++){
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}




/* 입력
6 6
..S...
..S.W.
.S....
..W...
...W..
......



1 2
SW



5 5
.S...
...S.
S....
...S.
.S...
*/


/* 출력
1
..SD..
..SDW.
.SD...
.DW...
DD.W..
......


0


1
.S...
...S.
S.D..
...S.
.S...
*/
