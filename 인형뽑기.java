import java.util.*;
class Main {
    public int solution(int[][] board, int[] moves) {
		Stack<Integer> stack = new Stack<>();
		int answer=0; //제거된 인형 개수

		for(int i=0; i<moves.length; i++){
			for(int j=0; j<board.length; j++){
				if(board[j][moves[i]-1] != 0){
					if(!stack.empty() && stack.peek() == board[j][moves[i]-1]){
						answer++; //인형 터짐
						stack.pop();
						board[j][moves[i]-1] = 0;
						break;
					}
					else{
						stack.push(board[j][moves[i]-1]);
						board[j][moves[i]-1] = 0;
						break;
					}
				}
			}
		}

		return answer*2;
	}

	public static void main(String[] args){
		Main T = new Main();
		int[][] board = new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = new int[]{1,5,3,5,1,2,1,4};
		System.out.println(T.solution(board, moves));
	}
}
