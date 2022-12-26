import java.util.*;
class Point{
	int rx, ry, bx, by, cnt;

	Point(int rx, int ry, int bx, int by, int cnt){
		this.rx=rx;
		this.ry = ry;
		this.bx = bx;
		this.by = by;
		this.cnt = cnt;
	}
}

class Main {
	static int n, m;
	static char[][] map;
	static boolean[][][][] visit;
	static int holeX, holeY;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	private static void bfs() {
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new char[n][m];
		visit = new boolean[n][m][n][m];

		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){

			}
		}
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
