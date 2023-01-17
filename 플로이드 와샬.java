import java.util.*;
class Main {
	public int solution(int n, int[][] edges){
		int[][] dy=new int[n+1][n+1];
		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++){
				if(i==j) dy[i][j]=0;
				else dy[i][j] = 100000; //Integer.MAX_VALUE로 하면 안됨 
				//밑에서 계산하다가 오버플로우 발생함
			}
		}
		for(int[] x : edges){
			dy[x[0]][x[1]]=x[2];
		}
		
		//플로이드 시작
		for(int k=1; k<=n; k++){
			for(int i=1; i<=n; i++){
				for(int j=1; j<=n; j++){
					if(dy[i][k]+dy[k][j]<dy[i][j]) 
						dy[i][j]=dy[i][k]+dy[k][j];
				}
			}
		}
		
		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++){
				if(dy[i][j]==100000) System.out.print("M ");
				else System.out.print(dy[i][j]+" ");
			}
			System.out.println();
		}
		return 0;
	}
		
	public static void main(String[] args){
		Main T = new Main();
		//n은 정점 개수
		System.out.println(T.solution(5, new int[][]{{1, 2, 6}, {1, 3, 3}, {3, 2, 2}, 
			{2, 4, 1}, {2, 5, 13}, {3, 4, 5}, {4, 2, 3}, {4, 5, 7}}));
	}
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
//백준 플로이드
import java.util.*;
public class Main {
	static int INF = 1000000;
	public int solution(int n, int m, int[][] dy) {
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(dy[i][j] > dy[i][k] + dy[k][j]) {
						dy[i][j] = dy[i][k] + dy[k][j];
					}
				}
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(dy[i][j] == INF) dy[i][j] = 0;
				else System.out.print(dy[i][j] + " ");
			}
			System.out.println();
		}
		return 0;
	}
	
	public static void main(String[] args) throws Exception {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //도시 개수
		int m = sc.nextInt(); //버스 개수
		int[][] dy = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i == j) dy[i][j] = 0;
				else dy[i][j] = INF;
			}
		}
		
		for(int i=1; i<=m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt(); //비용
			
			dy[a][b] = Math.min(dy[a][b], c);
		}
		T.solution(n,m,dy);
	}
}

/*입력 
5
14
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
3 5 10
3 1 8
1 4 2
5 1 7
3 4 2
5 2 4
*/

/* 출력
0 2 3 1 4 
12 0 15 2 5 
8 5 0 1 1 
10 7 13 0 3 
7 4 10 6 0
*/
