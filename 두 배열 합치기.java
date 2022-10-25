//그냥 두 배열을 합쳐서 정렬하는 것으로 쉬운 문제지만
//투 포인터를 사용해서 정렬하도록 면접에서도 그런 식으로 말하는 것이 훨씬 좋음
//시간 복잡도도 훨씬 좋음


import java.util.*;
class Main{
	public ArrayList<Integer> solution(int N, int M, int[] num1, int[] num2){
		ArrayList<Integer> answer = new ArrayList<>();
		int p1=0, p2=0;

		while(p1 < N && p2 < M){
			if(num1[p1] < num2[p2]){
				//작은 값을 answer에 추가하고 1증가
				answer.add(num1[p1]);
				p1++;
			}
			else{
				answer.add(num2[p2]);
				p2++;
			}
		}
		while(p1<N){
			answer.add(num1[p1++]);
		}
		while(p2<M){
			answer.add(num2[p2++]);
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
// num1[p1] < num2[p2] 라면 차례대로 answer 배열에 넣고 P1 증가
// 아니라면 P2 증가


/* 입력
3
1 3 5
5
2 3 6 7 9
*/

/* 출력
1 2 3 3 5 6 7 9
*/
