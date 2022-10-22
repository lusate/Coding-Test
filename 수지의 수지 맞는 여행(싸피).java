import java.util.*;
import java.io.*;

class Solution{
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[] visited;
	static char[][] board;
	static int R,C;
	static int cnt;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			R = sc.nextInt();
			C = sc.nextInt();
			board = new char[R][C];
			visited = new boolean[26];

			for(int i=0; i<R; i++){
				String s = sc.next();
				for(int j=0; j<C; j++){
					board[i][j] = s.charAt(j);
				}
			}

			cnt=0;
			visited[board[0][0] - 'A'] = true;
			dfs(0,0,1);
			System.out.println("#" + test_case + " " + cnt);
		}
	}

	public static void dfs(int x, int y, int depth){
		if(depth > cnt){
			cnt = depth;
		}
		for(int i=0; i<4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[board[nx][ny] - 'A']){
				visited[board[nx][ny] - 'A'] = true;
				dfs(nx, ny, depth+1);
				visited[board[nx][ny] - 'A'] = false;
			}
		}
	}
}


/* 입력

3
2 4
CAAB
ADCB
3 6
HFDFFB
AJHGDH
DGAGEH
5 5
IEFCJ
FHFKC
FFALF
HFGCF
HMCHH
*/

/* 출력
#1 3
#2 6
#3 10
*/
