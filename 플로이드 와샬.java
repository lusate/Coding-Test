import java.util.*;
class Solution {
    public int solution(int n, int[][] edges){
		int[][] dy = new int[n+1][n+1];
		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++){
				if(i == j) dy[i][j] = 0;
				else dy[i][j] = 100000; //Integer.MAX_VALUE로 하면 안됨 
				//밑에서 계산하다가 오버플로우 발생함
			}
		}
		for(int[] x : edges){
			dy[x[0]][x[1]] = x[2];
		}

		//플로이드
		for(int k=1; k<=n; k++){
			for(int i=1; i<=n; i++){
				for(int j=1; j<=n; j++){
					if(dy[i][k] + dy[k][j] < dy[i][j]){
						dy[i][j] = dy[i][k] + dy[k][j];
					}
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
		System.out.println(T.solution(5, new int[][]{{1, 2, 6}, {1, 3, 3}, {3, 2, 2}, 
			{2, 4, 1}, {2, 5, 13}, {3, 4, 5}, {4, 2, 3}, {4, 5, 7}}));
	}
}
