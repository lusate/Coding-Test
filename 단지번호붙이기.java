import java.util.*;
class Main {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	static int n, cnt;
	static int[][] map;
	static boolean[][] visit;
	private static int dfs(int x, int y){
		visit[x][y] = true;
		for(int i=0; i<4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && nx<n && ny>=0 && ny<n){
				if(map[nx][ny] == 1 && visit[nx][ny] == false){
					dfs(nx, ny);
					cnt++; //각 단지내 집의 수를 카운트
				}
			}
		}
		return cnt;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		visit = new boolean[n][n];
		//size로 총 단지수를 구함.
		ArrayList<Integer> arr = new ArrayList<>(); // 각 단지내 집의 수를 저장할 리스트.

		for(int i=0; i<n; i++){
			String s = sc.next();
			for(int j=0; j<n; j++){
				map[i][j] = s.charAt(j) - '0';
				//숫자 문자 - '0' 을 하면 int형 숫자가 나온다. (암기)
			}
		}

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(map[i][j] == 1 && visit[i][j] == false){
					cnt = 1;
					dfs(i, j);
					arr.add(cnt);
				}
			}
		}

		
		System.out.println(arr.size()); //총 단지수

		Collections.sort(arr);
		for(int i=0; i<arr.size(); i++){
			System.out.println(arr.get(i));	
		}
	}
}



/* 입력
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000
*/


/* 출력
3
7
8
9
*/
