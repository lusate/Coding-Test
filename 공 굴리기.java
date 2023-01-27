import java.util.*;
class Solution {
	int[] dx = {-1, 0, 1, 0};
	int[] dy = {0, 1, 0, -1};
    public int solution(int[][] board, int[] s, int[] e) {
		int n = board.length;
		int m = board[0].length;
		boolean[][] visit = new boolean[n][m];
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);

		pq.offer(new int[]{s[0], s[1], 0});
		while(!pq.isEmpty()){
			int[] tmp = pq.poll();
			visit[tmp[0]][tmp[1]] = true;

			if(tmp[0] == e[0] && tmp[1] == e[1]) return tmp[2];
			
			for(int k=0; k<4; k++){
				int nx = tmp[0];
				int ny = tmp[1];
				int len = tmp[2];

				while(nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0){
					nx += dx[k];
					ny += dy[k];
					len++;
				}

				nx -= dx[k];
				ny -= dy[k];
				len--;

				if(!visit[nx][ny]){
					pq.offer(new int[]{nx, ny, len});
				}
				
			}
		}

		return -1;
    }


	public static void main(String args[]){
		Solution T = new Solution();
		System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, 
		{0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{1, 0}, new int[]{4, 5}));


		System.out.println(T.solution(new int[][]{{1, 0, 1, 0, 0}, 
		{0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 3}, new int[]{4, 2}));

		System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, 
		{0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 2}));
	}
}



/* 출력
8
9
-1
*/
