import java.util.*;
class Main{
	static int[] dx={-1 ,0 ,1 , 0};
	static int[] dy={0, 1, 0, -1};
	private static int solution(int[][] board){
		int[][] dist = new int[7][7];
		int L = 0; //이동 거리
		Queue<int[]> Q = new LinkedList<>();
		Q.offer(new int[]{0,0});

		while(!Q.isEmpty()){
			int len = Q.size();
			L++;
			for(int i=0; i<len; i++){
				int[] p = Q.poll();
				for(int k=0; k<4; k++){
					int nx = p[0] + dx[k];
					int ny = p[1] + dy[k];

					if(nx>=0 && nx<7 && ny>=0 && ny<7 && board[nx][ny] == 0){
						board[nx][ny] = 1;
						Q.offer(new int[]{nx, ny});
						dist[nx][ny] = L;
					}
				}
			}
		}
		if(dist[6][6] == 0) return -1;
		else return dist[6][6];
	}
	
	public static void main(String[] args){
		System.out.println(solution(new int[][]{
			{0, 0, 0, 0, 0, 0, 0},
			{0, 1, 1, 1, 1, 1, 0}, 
			{0, 0, 0, 1, 0, 0, 0}, 
			{1, 1, 0, 1, 0, 1, 1}, 
			{1, 1, 0, 1, 0, 0, 0},
			{1, 0, 0, 0, 1, 0, 0}, 
			{1, 0, 1, 0, 0, 0, 0}}));



		// System.out.println(solution(new int[][]{
		// 	{0, 0, 0, 0, 0, 0, 0},
		// 	{0, 1, 1, 1, 1, 1, 0}, 
		// 	{0, 0, 0, 1, 0, 0, 0}, 
		// 	{1, 1, 0, 1, 1, 1, 1}, 
		// 	{1, 1, 0, 1, 0, 0, 0},
		// 	{1, 0, 0, 0, 1, 0, 0}, 
		// 	{1, 0, 1, 0, 1, 0, 0}}));
	}
}

/* 출력
12
-1
*/
