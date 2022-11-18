import java.util.*;
class Main{
	static int n, c=0;
	static int answer=Integer.MIN_VALUE;
	public void dfs(int L, int sum, int[] arr){
		if(sum > c) return;
		if(L == n){
			answer = Math.max(answer, sum);
		}
		else{
			dfs(L+1, sum+arr[L], arr);
			dfs(L+1, sum, arr);
			//바둑이 무게 {81, 58, 42, 33, 61} 이 있는데
			//81부터 시작해서 이 무게를 포함한다||하지 않는다. 를 기준으로 dfs 함.
		}
	}
	public static void main(String args[]) throws Exception{
		Main T = new Main();
		Scanner sc = new Scanner(System.in);

		c = sc.nextInt(); //최대 무게
		n = sc.nextInt(); //바둑이 수
		int[] arr = new int[n]; //내가 만든 부분 집합.

		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt(); //바둑이 무게 입력
		}
		T.dfs(0, 0, arr);
		System.out.println(answer);
	}
}


/* 입력
259 5
81
58
42
33
61
*/

/* 출력
242
*/
