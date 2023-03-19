import java.util.*;
class Solution{
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        char[][] map = new char[n][m];
        boolean[][] visit = new boolean[n][m];

        //공 위치
        int x=0, y=0;

	// PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); 이걸로 해도 결과는 같
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = board[i].charAt(j);
                if(map[i][j] == 'R'){
                    q.offer(new int[]{i, j, 0});
                }
                if(map[i][j] == 'G'){
                    x=i;
                    y=j;
                }
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();

            if(cur[0] == x && cur[1] == y) return cur[2];

            for(int k=0; k<4; k++){
                int nx = cur[0];
                int ny = cur[1];

		//최대 움직일 수 있는 거리로 해줌. Math.max(n, m)
                for(int i=1; i<Math.max(n, m); i++){
                    nx += dx[k];
                    ny += dy[k];

			//범위 벗어나거나 벽이라면 빼줌.
                	if(nx<0 || nx>=n || ny<0 || ny>=m || map[nx][ny] == 'D'){
                     	nx -= dx[k];
                     	ny -= dy[k];
                    }
                }

		//방문한 곳이라면 continue;
                if(visit[nx][ny]) continue;

		// 방문처리하고 q에 추가.
                visit[nx][ny] = true;
                q.add(new int[]{nx, ny, cur[2]+1});
            }

        }

        return -1;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
		System.out.println(T.solution(new String[]{".D.R", "....", ".G..", "...D"}));
	}
}


// -----------------------------------------------------------------------------------------------


// 다른 풀이 (||가 아닌 &&)
import java.util.*;
class Solution{
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        char[][] map = new char[n][m];
        boolean[][] visit = new boolean[n][m];

        //공 위치
        int x=0, y=0;

        // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = board[i].charAt(j);
                if(map[i][j] == 'R'){
                    q.offer(new int[]{i, j, 0});
                }
                if(map[i][j] == 'G'){
                    x=i;
                    y=j;
                }
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
			visit[cur[0]][cur[1]] = true;
            if(cur[0] == x && cur[1] == y) return cur[2];

            for(int k=0; k<4; k++){
                int nx = cur[0];
                int ny = cur[1];

				//최대 움직일 수 있는 거리로 해줌. Math.max(n, m)
                for(int i=0; i<4; i++){

					//범위 벗어나거나 벽이라면 빼줌.
                    while(nx>=0 && nx<n && ny>=0 && ny<m && map[nx][ny] != 'D'){
                        nx += dx[k];
                    	ny += dy[k];
                    }
					nx -= dx[k];
					ny -= dy[k];

					if(visit[nx][ny]) continue;

					visit[nx][ny] = true;
					q.add(new int[]{nx, ny, cur[2]+1});
                }
            }

        }

        return -1;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
		System.out.println(T.solution(new String[]{".D.R", "....", ".G..", "...D"}));
	}
}
