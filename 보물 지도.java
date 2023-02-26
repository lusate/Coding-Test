import java.util.*;
class Solution {
	int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};
    public int solution(int n, int m, int[][] hole) {
		int[][] map = new int[n][m];
		boolean[][][] visit = new boolean[n][m][2]; //2는 2점프 횟수.
		
		for(int[] x : hole){
			map[x[0] - 1][x[1] - 1] = 1;
		}

		visit[0][0][1] = true;
		int answer = Integer.MAX_VALUE;

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{0, 0, 0, 1});
		while(!q.isEmpty()){
			int[] tmp = q.poll();

			if(tmp[0] == n-1 && tmp[1] == m-1) answer = Math.min(answer, tmp[2]);

			for(int k=0; k<4; k++){
				int nx = tmp[0] + dx[k];
				int ny = tmp[1] + dy[k];

				if(nx>=0 && ny>=0 && nx<n && ny<m && map[nx][ny] == 0 && !visit[nx][ny][tmp[3]]){
					visit[nx][ny][tmp[3]] = true;
					q.offer(new int[]{nx, ny, tmp[2]+1, tmp[3]});
				}
			}

			//점프 횟수를 1로 해야하는데 처음에 q에 {0, 0, 0, 0}을 넣으면 점프하려는 개수를 늘릴 수 없어서 처음에 {0, 0, 0, 1}로 잡음.
			if(tmp[3] > 0){
				for(int k=0; k<4; k++){
					int kx = tmp[0] + dx[k] * 2;
					int ky = tmp[1] + dy[k] * 2;
					if(kx>=0 && ky>=0 && kx<n && ky<m && map[kx][ky] == 0 && !visit[kx][ky][tmp[3] - 1]){ // 점프 부분을 -1해서 한 칸만 움직이도록 함.
						visit[kx][ky][tmp[3] - 1] = true;
						q.offer(new int[]{kx, ky, tmp[2] + 1, tmp[3] - 1});
					}
				}
			}
		}
        
		return answer == Integer.MAX_VALUE ? -1 : answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(4, 4, new int[][]{{2, 3}, {3, 3}}));
		System.out.println(T.solution(5, 4, new int[][]{{1, 4}, {2, 1}, {2, 2}, {2, 3}, 
		{2, 4}, {3, 3}, {4, 1}, {4, 3}, {5, 3}}));
	}
}
