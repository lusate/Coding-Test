import java.util.*;
class Main{
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	private static int solution(int[][] board){
		int r = board.length;
		int c = board[0].length;
		int[][] dist = new int[r][c];
		
		Queue<int[]> Q = new LinkedList<>();
		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				if(board[i][j] == 2 || board[i][j] == 3){
					Q.offer(new int[]{i, j});
					int[][] ch = new int[r][c];
					ch[i][j] = 1;

					int L=0;
					while(!Q.isEmpty()){
						int len = Q.size();
						L++;
						for(int d=0; d<len; d++){
							int[] tmp = Q.poll();

							for(int k=0; k<4; k++){
								int nx = tmp[0] + dx[k];
								int ny = tmp[1] + dy[k];

								//장애물만 아니면 다 지나갈 수 있음. (기사든 딸기든 영희든 다 지나갈 수 있음.)
								if(nx>=0 && nx<r && ny>=0 && ny<c && board[nx][ny] != 1){
									if(ch[nx][ny] == 0){ //체크되어 있는 곳은 가면 X.
										ch[nx][ny] = 1;
										dist[nx][ny] += L;
										Q.offer(new int[]{nx, ny});
									}
								}
							}
						}
					}
				}
			}
		}

		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				System.out.print(dist[i][j] + " ");
			}
			System.out.println();
		}

		int min = Integer.MAX_VALUE;
		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				//딸기 위치 4에 도달해도 dist가 0이면 벽이 있어서 지나갈 수 없는 것이다.
				if(dist[i][j] > 0 && board[i][j] == 4){
					min = Math.min(min, dist[i][j]);
				}
			}
		}

		return min;

	}
	
	public static void main(String[] args){
		System.out.println(solution(new int[][]{
			{4, 1, 0, 0, 0, 0, 1, 0},
			{0, 0, 0, 1, 0, 1, 0, 0}, 
			{0, 2, 1, 1, 3, 0, 4, 0}, 
			{0, 0, 1, 4, 1, 1, 1, 0}}));

		// System.out.println(solution(new int[][]{
		// 	{3, 0, 0, 0, 1, 4, 4, 4},
		// 	{0, 1, 1, 0, 0, 0, 1, 0}, 
		// 	{0, 1, 4, 0, 1, 0, 0, 0}, 
		// 	{0, 0, 0, 1, 0, 0, 0, 0}, 
		// 	{1, 0, 1, 0, 0, 1, 1, 0}, 
		// 	{4, 0, 0, 0, 1, 0, 0, 0}, 
		// 	{4, 1, 0, 0, 1, 0, 0, 0}, 
		// 	{4, 0, 0, 0, 0, 0, 1, 2}}));
	}
}

/* 출력
11
16
*/
