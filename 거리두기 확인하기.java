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
        boolean[][] visited = new boolean[n][n];
        Q.offer(new Point(x, y));
        visited[x][y] = true;
        
        while(!Q.isEmpty()) {
            Point tmp = Q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                int manhattan = Math.abs(x - nx) + Math.abs(y - ny);
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < n){
					if(visited[nx][ny] || manhattan > 2){
						continue;
					}
					visited[nx][ny] = true;
					if(board[nx].charAt(ny) == 'X'){
						continue;
					}
					else if(board[nx].charAt(ny) == 'P'){
						return false;
					}
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
                if(board[i].charAt(j) == 'P') { 
                    if(!BFS(board, i, j)) return 0; 
                }
            }
        }
        return 1;
    }

	public int[] solution(String[][] places) {
		int n = places.length;
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            result[i] = isCorrext(places[i]);
        }
        return result;
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
