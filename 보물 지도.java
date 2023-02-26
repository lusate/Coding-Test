import java.util.*;
class Node{
	int n, m, time, jumpCount;

	public Node(int n, int m, int time, int jumpCount) {
		this.n = n;
		this.m = m;
		this.time = time;
		this.jumpCount = jumpCount;
	}
}
class Solution {
	int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};
    public int solution(int n, int m, int[][] hole) {
		boolean[][][] visit = new boolean[n][m][2];
        int[][] map = new int[n][m];

		for (int[] data : hole) {
            map[data[0] - 1][data[1] - 1] = 1;
        }

		visit[0][0][1] = true;
		int answer = Integer.MAX_VALUE;
		Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, 1));
		while(!q.isEmpty()){
			Node tmp = q.poll();
			if(tmp.n == n-1 && tmp.m == m-1) answer = Math.min(answer, tmp.time);

			for(int k=0; k<4; k++){
				int nx = tmp.n + dx[k];
				int ny = tmp.m + dy[k];

				if(nx>=0 && nx<n && ny>=0 && ny<m && map[nx][ny] != 1 && !visit[nx][ny][tmp.jumpCount]){
					visit[nx][ny][tmp.jumpCount] = true;
					q.offer(new Node(nx, ny, tmp.time + 1, tmp.jumpCount));
				}
			}

			if(tmp.jumpCount > 0){
				for(int k=0; k<4; k++){
					int nx = tmp.n + dx[k] * 2;
					int ny = tmp.m + dy[k] * 2;
	
					if(nx>=0 && nx<n && ny>=0 && ny<m && map[nx][ny] != 1 && !visit[nx][ny][tmp.jumpCount - 1]){
						visit[nx][ny][tmp.jumpCount - 1] = true;
						q.offer(new Node(nx, ny, tmp.time + 1, tmp.jumpCount - 1));
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
