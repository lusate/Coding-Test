import java.util.*;
class Main {
	int[] dx={-1, 0, 1, 0};
	int[] dy={0, 1, 0, -1};
	public int solution(int[][] board){
		int answer=0;
		int n=board.length;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				boolean flag=true;
				for(int k=0; k<4; k++){
					int nx=i+dx[k];
					int ny=j+dy[k];
					if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny]>=board[i][j]){
						//범위는 board[n][n] 안 &&
						//봉우리(board[i][j])가 상하좌우 값보다 작은 경우 false하고 break
						flag=false;
						break;
					}
				}
				if(flag) answer++;
			}
		}
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		int[][] arr={{5, 3, 7, 2, 3}, 
			{3, 7, 1, 6, 1}, 
			{7, 2, 5, 3, 4}, 
			{4, 3, 6, 4, 1}, 
			{8, 7, 3, 5, 2}};
		System.out.println(T.solution(arr));
		
	}
}

