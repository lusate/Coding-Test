import java.util.*;
class Main{
	static String answer = "NO";
	static int n, total=0;
	boolean flag = false;
	public void dfs(int L, int sum, int[] arr){
		if(flag) return; //넘어오는 재귀 모두 return
		if(sum > total/2) return; //sum이 total보다 더 커질 때는 탐색을 더 이상 하지 않아도 되므로 return
		if(L == n){
			if((total-sum) == sum){
				answer = "YES";
				flag = true; // 조건이 맞아 answer 가 "YES"가 되면 더 이상 재귀하지 않음
			}
		}
		else{
			dfs(L+1, sum + arr[L], arr); //L번 째에 있는 값을 사용함.
			dfs(L+1, sum, arr); //L번 째에 있는 값을 사용 안 함
		}
	}
	public static void main(String args[]) throws Exception{
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] arr = new int[n]; //내가 만든 부분 집합.
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
			total = total + arr[i]; //total은 입력한 값들의 합
		}
		T.dfs(0, 0, arr);
		System.out.println(answer);
	}
}


/* 입력
6
1 3 5 6 7 10
*/

/* 출력
YES
*/
