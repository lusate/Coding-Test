import java.util.*;
class Main{
	static int n,m=0;
	static int answer=Integer.MIN_VALUE;
	//ps는 문제 점수, pt는 문제 타임
	public void dfs(int L, int sum, int time, int[] ps, int[] pt){
		if(time > m) return; //제한 시간 넘어가면 끝내기.
		if(L == n){
			answer = Math.max(answer, sum);
		}
		else{
			//dfs(L, sum, time, a,b); //x번 문제를 푼다||풀지 않는다 로 구분해서 dfs 함
			dfs(L+1, sum + ps[L], time + pt[L], ps, pt); //문제를 푼다.
			dfs(L+1, sum , time, ps, pt); //문제를 안 푼다.
		}
	}
	public static void main(String args[]) throws Exception{
		Main T = new Main();
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt(); //문제 수
		m = sc.nextInt(); //제한 시간
		int[] ps = new int[n];
		int[] pt = new int[n];

		for(int i=0; i<n; i++){
			ps[i] = sc.nextInt();
			pt[i] = sc.nextInt();
		}
		T.dfs(0,0,0,ps,pt);
		System.out.println(answer);
	}
}


/* 입력
5 20
10 5
25 12
15 8
6 3
7 4
*/

/* 출력
41
*/
