import java.util.*;
public class Main {
	static int c, r, cnt;
	static int answer=0; //이동 거리.
	static int[][] map;
	static boolean[] visit = new boolean[26]; //알파벳 26개이므로 이걸로 방문 처리하면 됨.
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	private static void dfs(int x, int y, int cnt) {
		if(visit[map[x][y]]){ //이전 알파벳들과 같다면 return.
			answer = Math.max(answer, cnt);
			return;
		}

		else{
			visit[map[x][y]] = true;
			for(int t=0; t<4; t++){
				int nx = x + dx[t];
				int ny = y + dy[t];
	
				if(nx>=1 && nx<=r && ny>=1 && ny<=c){
					dfs(nx, ny, cnt+1);
				}
			}
      // dfs 결과 나온 후 다시 빽해서 다른 경우의 수 시도함.
			visit[map[x][y]] = false;
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt(); //가로
		c = sc.nextInt(); //세로
		map = new int[r+1][c+1];

		for(int i=1; i<=r; i++){
			String s = sc.next();
			for(int j=1; j<=c; j++){
				map[i][j] = s.charAt(j-1) - 'A';
			}
		}

		dfs(1,1, 0); // 1,1 에서 시작.
		System.out.println(answer);
	}
}


/* 입력
2 4
CAAB
ADCB


3 6
HFDFFB
AJHGDH
DGAGEH
*/


/* 출력
3

6
*/
