import java.util.*;
class Solution {
	int[] dx = {-1, 0, 1, 0};
	int[] dy = {0, 1, 0, -1};
    public int solution(int[][] board) {
		int answer = 0;
		int n = board.length;
		int m = board[0].length;

		int[][] cost = new int[n][m];
		for(int i=0; i<n; i++){
			Arrays.fill(cost[i], Integer.MAX_VALUE);
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);

		pq.offer(new int[]{0,0,0});
		while(!pq.isEmpty()){
			int[] tmp = pq.poll();
			if(tmp[2] > cost[tmp[0]][tmp[1]]) continue;

			for(int k=0; k<4; k++){
				int nx = tmp[0] + dx[k];
				int ny = tmp[1] + dy[k];

				if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				if(board[nx][ny] == 0 && cost[nx][ny] > tmp[2]){
					cost[nx][ny] = tmp[2];
					pq.offer(new int[]{nx, ny, tmp[2]});
				}

				if(board[nx][ny] == 1 && cost[nx][ny] > tmp[2] + 1){
					cost[nx][ny] = tmp[2] + 1;
					pq.offer(new int[]{nx, ny, tmp[2] + 1});
				}
			}
		}

		
		answer = cost[n-1][m-1];


		return answer;
    }

	public static void main(String args[]){
		Solution T = new Solution();
		System.out.println(T.solution(new int[][]{
			{0, 1, 1, 0},
			{1, 0, 1, 1},
			{0, 1, 0, 0}}));

		System.out.println(T.solution(new int[][]{
			{0, 1, 1, 0},
			{1, 1, 0, 1},
			{0, 0, 1, 0},
			{0, 1, 1, 1},
			{0, 1, 1, 0}}));
	}
}

/* 출력
2
3
*/
