import java.util.*;
class Solution {
	int[] dx = {0,0,1,-1};
	int[] dy = {1,-1,0,0};
    public int solution(int[][] board) {
		int answer = 0;
		int n = board.length;
		int m = board[0].length;
		int[][] cost = new int[n][m];

		for(int i=0; i<n; i++){
			Arrays.fill(cost[i], Integer.MAX_VALUE);
		}
		cost[0][0] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
		pq.offer(new int[]{0,0,0});


		while(!pq.isEmpty()){
			int[] tmp = pq.poll();
			int dir = board[tmp[0]][tmp[1]] - 1;
			if(tmp[2] > cost[tmp[0]][tmp[1]]) continue;

			for(int k=0; k<4; k++){
				int nx = tmp[0] + dx[k];
				int ny = tmp[1] + dy[k];

				if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

				if(k == dir && cost[nx][ny] > tmp[2]){ //방향이 같음
					cost[nx][ny] = tmp[2];
					pq.offer(new int[]{nx, ny, tmp[2]});
				}
				else{ //k != dir 로 방향이 바뀐 나머지 3 방향
					if(cost[nx][ny] > tmp[2] + 1){ //방향을 바꾸면서 비용 1 플러스.
						cost[nx][ny] = tmp[2] + 1;
						pq.offer(new int[]{nx, ny, tmp[2] + 1});
					}
				}
			}
		}
		answer = cost[n-1][m-1];

		return answer;
    }

	public static void main(String args[]){
		Solution T = new Solution();
		System.out.println(T.solution(new int[][]{
			{3, 1, 3},
			{1, 4, 2},
			{4, 2, 3}}));

		System.out.println(T.solution(new int[][]{
			{3, 2, 1, 3},
			{1, 1, 4, 2},
			{3, 4, 2, 1},
			{1, 2, 2, 4}}));


		System.out.println(T.solution(new int[][]{
			{1, 2, 3, 2, 1, 3, 1, 2, 2, 2},
			{1, 2, 2, 1, 1, 1, 4, 2, 1, 1},
			{3, 2, 2, 2, 2, 1, 2, 2, 3, 4},
			{3, 3, 1, 3, 3, 4, 4, 4, 3, 1},
			{1, 1, 1, 2, 2, 3, 3, 4, 3, 4},
			{1, 1, 1, 2, 2, 3, 3, 1, 1, 1}}));
	}
}


/* 출력
1
2
5
*/
