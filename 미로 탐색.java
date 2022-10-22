import java.util.*;
public class Main{
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] board;
	static int answer=0;

	public void dfs(int x, int y){
		if(x == 7 && y == 7){ //도착점에 도착한 경우
			answer++;
		}
		else{
			for(int i=0; i<4; i++){
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0){
					//board[nx][ny] == 0 통로로 내가 갈 수 있어야 함.

					board[nx][ny] = 1; //갔으므로 1로 체크
					dfs(nx, ny);
					board[nx][ny] = 0; //다시 통로로 체크를 풀어주어야 한다.
					//풀어주지 않으면 다음 경우의 수를 볼 수 없음.
				}
			}
		}
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		board = new int[8][8];

		for(int i=1; i<=7; i++){
			for(int j=1; j<=7; j++){
				board[i][j] = sc.nextInt();
			}
		}
		board[1][1] = 1;
		T.dfs(1,1);
		System.out.print(answer);
	}
}


/* 입력
0 0 0 0 0 0 0
0 1 1 1 1 1 0
0 0 0 1 0 0 0
1 1 0 1 0 1 1
1 1 0 0 0 0 1
1 1 0 1 1 0 0
1 0 0 0 0 0 0
*/

/* 출력
8
/*
