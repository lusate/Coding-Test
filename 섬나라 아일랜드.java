import java.util.*;
class Main { //송아지처럼 목적지를 찾아서 가는 것이 아니고 섬이 몇 개 있는지 구하는 것이므로 BFS 쓰지 않는다.
	int answer=0, n;
	int[] dx={-1, -1, 0, 1, 1, 1, 0, -1};
	int[] dy={0, 1, 1, 1, 0, -1, -1, -1};
	public void DFS(int x, int y, int[][] board){
		for(int i=0; i<8; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1){
				board[nx][ny] = 0;
				DFS(nx, ny, board);
			}
		}
	}
	public int solution(int[][] board){
		n = board.length;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(board[i][j] == 1){
					answer++;
					board[i][j] = 0;
					DFS(i, j, board);
				}
			}
		}
		
		return answer;
	}
		
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(new int[][]{{1, 1, 0, 0, 0, 1, 0}, {0, 1, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 0, 1, 1}, {1, 1, 0, 1, 1, 0, 0}, {1, 0, 0, 0, 1, 0, 0}, {1, 0, 1, 0, 1, 0, 0}}));
	}
}


//5
