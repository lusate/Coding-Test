import java.util.*;
class Main{
	public int solution(int[][] board){
		int answer=0;
		int n = board.length;
		//n = 4
		int[] row = new int[n];
		int[] col = new int[n];

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				//앞으로 봤을 때 최대
				//i = 0일 때 board[0][0~3] 돌면서 최대를 찾아준다.
				if(board[i][j] > row[i]){
					row[i] = board[i][j];
					//System.out.println("row:"+row[i]);
				}
				//옆으로 봤을 때 최대
				if(board[j][i] > col[i]){
					col[i] = board[j][i];
					//System.out.print("col:"+col[i]);
				}
			}
		}

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				answer += Math.min(row[i], col[j]) - board[i][j];
				//row[2] = 5 이고 col[1] = 8 이라 할 때
				//row[i] 와 col[i] 에서 최소에서 스카이라인은 5보다 커지면 안됨
				//5보다 커지게 되면 row 와 맞지 않게 됨
				//그래서 최대 5까지만 증가시킬 수 있으므로 최대 3을 증가시킬 수 있다.
			}
		}
		
		
		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		int[][] arr1={{2, 5, 7, 3}, 
			{6, 8, 9, 7}, 
			{3, 2, 4, 5}, 
			{7, 2, 5, 8}};
		System.out.println(T.solution(arr1));

	}
}
