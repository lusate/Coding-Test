import java.util.*;
public class Main {
	static int m,n,k;
	static int[][] map;
	static int width;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static ArrayList<Integer> arr;
	private static void dfs(int x, int y) {
		//직사각형이 아닌 부분을 1로 해줌 -> 처음 (0,0) 을 1로 해줌.
		map[x][y] = 1;
		
		width++;
		for(int i=0; i<4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && nx<m && ny>=0 && ny<n && map[nx][ny] == 0){
				dfs(nx, ny);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		k = sc.nextInt();
		map = new int[m][n];


		//직사각형 좌표
		for(int i=0; i<k; i++){
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			for(int j=y1; j<y2; j++){
				for(int k=x1; k<x2; k++){
					map[j][k] = 1; //직사각형 부분을 1로 만듦. 나머지는 0
				}
			}
		}
		
		arr = new ArrayList<>();
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){ 
				//직사각형이 아닌 영역인 경우
				if(map[i][j] == 0){
					width = 0;
					dfs(i, j);
					arr.add(width);
				}
			}
		}

		System.out.println(arr.size());

		Collections.sort(arr);
		for(int i=0; i<arr.size(); i++){
			System.out.println(arr.get(i));
		}

	}
}


/* 입력
5 7 3
0 2 4 4
1 1 2 5
4 0 6 2
*/


/* 출력
3
1 7 13
*/
