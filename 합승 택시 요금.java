import java.util.*;
class Main {
	public int solution(int n, int s, int a, int b, int[][] fares) {
		int answer=Integer.MAX_VALUE;
		int[][] dy = new int[n+1][n+1];
		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++){
				if(i == j) dy[i][j] = 0;
				else dy[i][j] = 100000;
			}
		}

		for(int[] x : fares){
			dy[x[0]][x[1]] = x[2];
			dy[x[1]][x[0]] = x[2];
		}

		for(int k=1; k<=n; k++){
			for(int i=1; i<=n; i++){
				for(int j=1; j<=n; j++){
					if(dy[i][k] + dy[k][j] < dy[i][j])
						dy[i][j] = dy[i][k] + dy[k][j];
				}
			}
		}
		
		for(int i=1; i<=n; i++){
			answer = Math.min(answer, dy[s][i] + dy[i][a] + dy[i][b]);
		}
		return answer;
	}
		
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(6, 4, 6, 2, new int[][]{{4,1,10}, {3,5,24},{5,6,2},{3,1,41},{5,1,24},{4,6,50},
		{2,4,66},{2,3,22},{1,6,25}}));

		System.out.println(T.solution(7, 3, 4, 1, new int[][]{{5,7,9}, {4,6,4},{3,6,1},{3,2,3},{2,1,6}}));

		System.out.println(T.solution(6, 4, 5, 6, new int[][]{{2,6,6}, {6,3,7},{4,6,7},{6,5,11},{2,5,124},{5,3,20},
		{2,4,8},{4,3,9}}));
	}
}
