import java.util.*;

public class Main {
	static int n;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0,- 1, 0, 1};
	private static void dfs(int x, int y, int height) {
		visit[x][y] = true;
		for(int i=0; i<4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && nx<n && ny>=0 && ny<n && !visit[nx][ny]){
				if(map[nx][ny] >= height){
					visit[nx][ny] = true;
					dfs(nx, ny, height);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];

		int maxHeight = 0;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				map[i][j] = sc.nextInt();
				maxHeight = Math.max(maxHeight, map[i][j]);
			}
		}

		int answer = 0;
		for(int height=0; height<=maxHeight; height++){
			int cnt = 0;
			visit = new boolean[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j] >= height && !visit[i][j]){
						cnt++;
						dfs(i, j, height);
					}
				}
			}

			answer = Math.max(answer, cnt);
		}
		
		System.out.println(answer);
	}
}


/* 입력
5
6 8 2 6 2
3 2 3 4 6
6 7 3 3 2
7 2 5 3 6
8 9 5 2 7


7
9 9 9 9 9 9 9
9 2 1 2 1 2 9
9 1 8 7 8 1 9
9 2 7 9 7 2 9
9 1 8 7 8 1 9
9 2 1 2 1 2 9
9 9 9 9 9 9 9
*/


/* 출력
5

6
*/
