import java.util.*;
class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
class Main{
	int[] dx = {-1, 0, 1, 0};
	int[] dy = {0, 1, 0, -1};
	public boolean BFS(String[] board, int x, int y) {
		int n = board.length;
        Queue<Point> Q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n]; //방문 체크
        Q.offer(new Point(x, y));
        visited[x][y] = true;
        
        while(!Q.isEmpty()) {
            Point tmp = Q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                int manhattan = Math.abs(x - nx) + Math.abs(y - ny);
				//맨허튼 거리 계산
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < n){
					if(visited[nx][ny] || manhattan > 2){
						continue;
					}//이동했을 때 방문한 적이 있거나 맨허튼 거리가 2보다 크면 패스

					visited[nx][ny] = true;
					if(board[nx].charAt(ny) == 'X'){
						continue;
					}//이동했을 때 칸막이라면 패스

					else if(board[nx].charAt(ny) == 'P'){
						return false;
					}//이동한 곳이 P면 사람이 있는 것으로 거리두기 지키지 않음
					else{
						Q.offer(new Point(nx, ny));
					}
				}
                
            }
        }
        return true;
    }

	public int isCorrext(String[] board) {
		int n = board.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < board[i].length(); j++){
				//System.out.print(board[i].charAt(j)); -> places에 모든 값들
                if(board[i].charAt(j) == 'P') {
                    if(!BFS(board, i, j)) return 0; 
                }//거리두기 지키지 않았으므로 return 0
            }
        }
        return 1;
    }

	public int[] solution(String[][] places) {
		int n = places.length;
        int[] answer = new int[n];
        for(int i = 0; i < n; i++){
            answer[i] = isCorrext(places[i]);
        }
        return answer;
    }
	public static void main(String[] args){
		Main T = new Main();
		String[][] tmp = new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, 
		{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		for(int x : T.solution(tmp)){
			System.out.print(x + " ");
		}
	}
}
