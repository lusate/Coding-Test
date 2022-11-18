import java.util.*;
class Main {
	public int dfs(int n, int r){
		int[][] dy = new int[n+1][r+1];
		if(dy[n][r] > 0) return dy[n][r];
		if(n == r || r == 0) return 1;
		else return dfs(n-1, r-1) + dfs(n-1, r);
	}
	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		//nCr

		System.out.println(T.dfs(n,r));
	} 
}


/* 입력
5 3
*/

/* 출력
10
*/
