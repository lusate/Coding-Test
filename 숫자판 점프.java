import java.util.*;

class Main {
	static int[][] map;
	static HashSet<String> list;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	private static void dfs(int x, int y, int length, String s) {
		if(length == 6){
			list.add(s);
			return;
		}

		for(int i=0; i<4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && nx<5 && ny>=0 && ny<5){
				dfs(nx, ny, length+1, s + map[nx][ny]);
			}
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[5][5];
		list = new HashSet<String>();
		
		for(int i=0; i<5; i++){
			for(int j=0; j<5; j++){
				map[i][j] = sc.nextInt();
			}
		}


		String s = "";
		for(int i=0; i<5; i++){
			for(int j=0; j<5; j++){
				dfs(i,j,0, s);
			}
		}

		System.out.println(list.size());
	}
}


/* 입력
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
1 1 1 2 1
1 1 1 1 1
*/

/* 출력
15
*/
