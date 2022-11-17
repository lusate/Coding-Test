import java.util.*;
class Point{
	public int x, y;
	Point(int x, int y){
		this.x=x;
		this.y=y;
	}
}
class Solution{
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int n = 16;
	static char[][] visited;
	public static void bfs(int x, int y){
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(x, y));
		visited[x][y] = '1';
		while(!Q.isEmpty()){
			Point tmp = Q.poll();
			for(int i=0; i<4; i++){
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if(nx >= 0 && nx < n && ny >= 0 && ny < n && visited[nx][ny] == '0'){
					Q.offer(new Point(nx, ny));
					visited[nx][ny] = '1';
				}
				if(visited[nx][ny] == '3'){
					System.out.println("1");
					System.exit(0);
				}
			}
		}
		System.out.println("0");
	}
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		//int T = sc.nextInt();
		visited = new char[n][n];
		for(int test_case = 1; test_case <= 10; test_case++){
			int test = sc.nextInt();
			for(int i=0; i<n; i++){
				String s = sc.next();
				for(int j=0; j<n; j++){
					visited[i][j] = s.charAt(j);
				}
			}
			System.out.print("#" + test + " ");
			bfs(1, 1);
		}
	}
}


/* 입력
1
1111111111111111
1210000000100011
1010101110101111
1000100010100011
1111111010101011
1000000010101011
1011111110111011
1010000010001011
1010101111101011
1010100010001011
1010111010111011
1010001000100011
1011101111101011
1000100000001311
1111111111111111
1111111111111111
2
1111111111111111
1200000010000011
1011111011111011
1000001010000011
1110101010111011
1010101010100011
1011111010111111
1000001010000011
1011101011111011
1010101010000011
1010101010111111
1010100000130011
1010111111111011
1000000000000011
1111111111111111
1111111111111111
3
1111111111111111
1210001000100011
1010101010101011
1000100010101011
1011111110101011
1000001010101011
1111101010101011
1010001000001011
1010111111111011
1010000000100011
1011111110101111
1000001010100011
1011101010111011
1000100000130011
1111111111111111
1111111111111111
4
1111111111111111
1200100000000011
1011101110111011
1000001010101011
1111111011101011
1000100010000011
1010101010111111
1010001010001011
1011111011101011
1000100010100011
1110101110111111
1010100000130011
1010111111111011
1000000000000011
1111111111111111
1111111111111111
5
1111111111111111
1210000000100011
1010111011101011
1010100010001011
1011101010111011
1000001010001011
1111111011111011
1000100010000011
1011101010111011
1010001000001011
1010101011111111
1010101000000011
1010101110111011
1000100010001311
1111111111111111
1111111111111111
6
1111111111111111
1210001010000011
1010101010111111
1010100000100011
1010111111101011
1000100000001011
1110101111111011
1000100000001011
1011101111101011
1000101000101011
1110101010111011
1010100010100011
1010111110101111
1000000000100311
1111111111111111
1111111111111111
7
1111111111111111
1210000000000011
1011101111111011
1000101010000011
1110101010111011
1000001000101011
1010111111101111
1010100000100011
1011101110101111
1000001000100011
1111111011111011
1000100010001011
1010101110111011
1010001300000011
1111111111111111
1111111111111111
8
1111111111111111
1200000010000011
1111111010111011
1000000010001011
1011111111111011
1010000000000011
1010111111101011
1010000000001011
1010111011111011
1000100010001011
1111111011101011
1000001000100011
1110111110101011
1000000000101311
1111111111111111
1111111111111111
9
1111111111111111
1200000000001011
1011111111101011
1000000010001011
1111111010111011
1000100010000011
1011101111111011
1010001000001011
1010111011101011
1010000010101311
1011111110101111
1000100000100011
1011101011111011
1000001000000011
1111111111111111
1111111111111111
10
1111111111111111
1200001000100011
1111101110101011
1000100010001011
1011101111101111
1000100000000011
1110111111101011
1000000010001011
1110111011101011
1010001000001011
1010101111111011
1000101010000011
1010101010101111
1010100000100311
1111111111111111
1111111111111111
*/

/* 출력
#1 1
#2 1
#3 1
#4 0
#5 1
#6 1
#7 0
#8 1
#9 1
#10 1
*/
