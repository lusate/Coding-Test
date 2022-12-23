import java.util.*;
class Point{
	int z, x, y;
	public Point(int z, int x, int y){
		this.z=z;
		this.x=x;
		this.y=y;
	}
}
class Main {
	static int L,r,c;
	static char[][][] map; //현재 문자가 들어있는 3차원
	static int[][][] arr; //거리를 넣어줄 배열
	static boolean[][][] visit;
	static boolean flag;
	static int[] dx = {-1,1,0,0,0,0};
	static int[] dy = {0,0,-1,1,0,0};
	static int[] dz = {0,0,0,0,-1,1};

	private static void bfs() {
		Queue<Point> Q = new LinkedList<>();

		for(int k=0; k<L; k++){
			for(int i=0; i<r; i++){
				for(int j=0; j<c; j++){
					if(map[k][i][j] == 'S'){
						Q.offer(new Point(k,i,j));
						visit[k][i][j] = true;
					}
				}
			}
		}
		

		while(!Q.isEmpty()){
			Point tmp = Q.poll();
			for(int i=0; i<6; i++){
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				int nz = tmp.z + dz[i];

				if(map[tmp.z][tmp.x][tmp.y] == 'E'){ //도착한 경우
					System.out.println("Escaped in " + arr[tmp.z][tmp.x][tmp.y] + " minute(s).");
					flag = true;
					return;
				}

				if(nx>=0 && ny>=0 && nz>=0 && nx<r && ny<c && nz<L && !visit[nz][nx][ny]){
					if(map[nz][nx][ny] == '.' || map[nz][nx][ny] == 'E'){ //이동 가능
						visit[nz][nx][ny] = true;
						arr[nz][nx][ny] = arr[tmp.z][tmp.x][tmp.y] + 1;
						Q.offer(new Point(nz, nx, ny));
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			L = sc.nextInt(); // 상범빌딩 층 수
			r = sc.nextInt(); // 상범빌딩 한 층의 행과 열.
			c = sc.nextInt();
			map = new char[L][r][c];
			arr = new int[L][r][c];
			visit = new boolean[L][r][c];
			flag = false;

			if(L==0 && r==0 && c==0) {
				break;
			}

			
			for(int k=0; k<L; k++){ //3번 -> 3차원.
				for(int i=0; i<r; i++){
					String s = sc.next();
					for(int j=0; j<c; j++){
						map[k][i][j] = s.charAt(j);
					}
				}
			}

			bfs();
			if(!flag)
				System.out.println("Trapped!");
			
		}

	}
}


/* 입력
3 4 5
S....
.###.
.##..
###.#

#####
#####
##.##
##...

#####
#####
#.###
####E

1 3 3
S##
#E#
###

0 0 0
*/


/* 출력
Escaped in 11 minute(s).
Trapped!
*/
