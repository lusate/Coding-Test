import java.util.*;
class Main{
	static int n,m,answer=Integer.MAX_VALUE;
	public void dfs(int L, int sum, Integer[] arr){
		if(sum > m) return;
		if(L >= answer) return;
		if(sum == m){
			answer = Math.min(answer, L);
			System.out.println(answer);
		}
		else{
			for(int i=0; i<n; i++){
				dfs(L+1, sum+arr[i], arr);
			}
		}
	}
	public static void main(String args[]) throws Exception{
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		Integer[] arr = new Integer[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr, Collections.reverseOrder());
		m = sc.nextInt();
		T.dfs(0, 0, arr);
	}
}

/* 입력
3
1 2 5
15
*/

/* 출력
3
*/
