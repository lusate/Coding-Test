import java.util.*;
class Point{
	int z; // 면
    int x; // 세로
    int y; // 가로
    public Point(int z, int x, int y){
        this.z = z;
        this.x = x;
        this.y = y;
    }
}
class Main {
	static int n, m, h; //세로, 가로, 높이
	static int[] dx = {-1,1,0,0,0,0};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dz = {0,0,0,0,-1,1};

	public int solution(int m, int n, int h, int[][][] box){
		Queue<Point> Q = new LinkedList<>();
		box = new int[h][n][m];
		for(int i=0; i<h; i++){
			for(int j=0; j<n; j++){
				for(int k=0; k<m; k++){
					if(box[i][j][k] == 1){ //토마토가 익은 경우 Q에 삽입
						Q.offer(new Point(i, j, k));
					}
				}
			}
		}
		
		while(!Q.isEmpty()){
			Point tmp = Q.poll();
			int z = tmp.z;
			int x = tmp.x;
			int y = tmp.y;
			for(int i=0; i<6; i++){
				int nz = z + dz[i];
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && nx < n && ny >= 0 && ny < m && nz >= 0 && nz < h){
					if(box[nz][nx][ny] == 0){ //토마토가 익지 않은 경우
						Q.offer(new Point(nz, nx, ny));
						box[nz][nx][ny] = box[z][x][y] + 1;
					}
				}
			}
		}
		int result = 0;
		for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    // 토마토가 안 익은게 있다면
                    if(box[i][j][k] == 0){
                        return -1; // 안 익었으므로 -1 출력
                    }
                    //날짜 최댓값 구하기
                    result = Math.max(result, box[i][j][k]);
                }
            }
        }
		if(result == 1){
			return 0;
		}
		else{
			return result - 1;
		}
	}
		
	public static void main(String[] args){
		Main T = new Main();
		//int[][][] arr1 = new int[][][]{{{0,-1,0,0,0},{-1,-1,0,1,1},{0,0,0,1,1}}};
		//System.out.println(T.solution(5, 3, 1, arr1));

		int[][][] arr2 = new int[][][]{{{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,1,0,0},{0,0,0,0,0}}};
		System.out.println(T.solution(5, 3, 2, arr2));

		//int[][][] arr3 = new int[][][]{{{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{-1,-1,-1,-1},{1,1,1,-1}}};
		//System.out.println(T.solution(4, 3, 2, arr3));
	}
}
