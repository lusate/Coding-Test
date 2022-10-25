import java.util.*;
class Main{
	public ArrayList<Integer> solution(int N, int M, int[] num1, int[] num2){
		ArrayList<Integer> answer = new ArrayList<>();
		int p1=0, p2=0;
		Arrays.sort(num1);
		Arrays.sort(num2);

		while(p1 < N && p2 < M){
			if(num1[p1] == num2[p2]){
				answer.add(num1[p1]);
				p1++;
				p2++;
			}
			else if(num1[p1] < num2[p2]) p1++;
			else p2++;
		}

		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] num1 = new int[N];
		for(int i=0; i<N; i++){
			num1[i] = sc.nextInt();
		}

		int M = sc.nextInt();
		int[] num2 = new int[M];
		for(int i=0; i<M; i++){
			num2[i] = sc.nextInt();
		}
		for(int x : T.solution(N, M, num1, num2)){
			System.out.print(x + " ");
		}
	}
}
// num1 배열과 num2 배열을 만듦
// num1에서 P1, num2에서 P2로 포인터 2개를 만듦
// num1[p1] < num2[p2] 라면 차례대로 answer 배열에 넣지 않고 p1만 증가
// 아니라면 P2 증가
// num1[p1] == num2[p2] 여야 answer 배열에 추가.


/* 입력
5
1 3 9 5 2
5
3 2 5 7 8
*/

/* 출력
2 3 5
*/
