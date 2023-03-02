import java.util.*;
class Main{
	public int solution(int[][] board){
		//이 방법은 장애물이 없는 경우만 가능한 로직.
		int answer = 0;
		int n = board.length;

		ArrayList<Integer> row = new ArrayList<>();
		ArrayList<Integer> col = new ArrayList<>();
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(board[i][j] == 1){
					row.add(i);
					col.add(j);
				}
			}
		}
		//col은 정렬을 해줘야 하지만 row는 필요없음.
		Collections.sort(col);
		
		//모이는 곳
		//학생들 수가 홀수여야 크기에서 2를 나누는 것이 모이는 곳의 좌표가 됨. ??
		int x = row.get(row.size()/2);
		int y = col.get(col.size()/2); //(x,y) 가 모이는 곳.
		System.out.println(x);
		System.out.println(y);

		// for(int p : row) answer += Math.abs(x - p);
		// for(int p : col) answer += Math.abs(y - p);
    //모임장소까지의 거리를 구함.
		for(int i=0; i<row.size(); i++){
			answer += Math.abs(x - row.get(i));
		}
		for(int i=0; i<col.size(); i++){
			answer += Math.abs(y - col.get(i));
		}

		return answer;
	}
	
	public static void main(String[] args){
		System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1},
		{0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
		System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}}));
		System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0},
		{0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
	}
}


/* 출력
8
8
37
*/
