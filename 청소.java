import java.util.*;
public class Main {
	int[] dx = {-1, 0, 1, 0};
	int[] dy = {0, 1, 0, -1};
	public int[] solution(int[][] board, int k){
		int n = board.length;
		int[] answer = new int[2];
		int x=0, y=0;
		int time = 0;
		int d = 1; //오른쪽부터 시작하기 때문에 1로 설정해줌.
		while(time < k){
			time++;
			int nx = x + dx[d];
			int ny = y + dy[d];

			if(nx>=0 && nx<n && ny>=0 && ny<n){
		                if(board[nx][ny] == 0){
		                    d = (d+1) % 4;
		                }
	             	} // if일 때 이동, else일 때 회전.


			if(nx<0 || nx>=n || ny<0 || ny>=n || board[nx][ny] == 1){
				d = (d+1) % 4;
				continue;
			}

			x = nx;
			y = ny;
		}
		answer[0] = x;
		answer[1] = y;
		
		return answer;
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		int[][] board = new int[][]{{0,0,0,0,0},{0,1,1,0,0},{0,0,0,0,0}, {1,0,1,0,1}, {0,0,0,0,0}};
		int k = 10;

		System.out.println(Arrays.toString(T.solution(board, k)));
	}
}


/* 출력
[2,2]
*/
