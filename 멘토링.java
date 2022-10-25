import java.util.*;
class Main{
	public int solution(int N, int M, int[][] arr){
		int answer = 0;
		//짝 짓는 경우의 수가 총 학생 수* 학생 수 
		for(int i=1; i<=N; i++){
			for(int j=1; j<=N; j++){
				//(i, j) i번 학생과 j번 학생의 등수를 구해줌

				int cnt = 0; // 짝이 된 경우의 수 카운트
				for(int k=0; k<M; k++){ //k는 테스트
					int pi=0, pj=0;
					for(int s=0; s<N; s++){ //s는 등수
						//(3, 1) 이라 할 때
						// 0번째 테스트에서 3번 학생의 등수는 0, 1번 학생의 등수는 2
						//pi는 i번 학생의 등수
						if(arr[k][s] == i) pi = s;
						if(arr[k][s] == j) pj = s;
					}
					//3번 등수가 0, 1번 등수가 2
					if(pi < pj) cnt++;
					//System.out.println("cnt = " + cnt);
				}
				if(cnt == M){ //M개의 테스트에서 
					answer++; //짝이 될 수 있음
				}
			}
		}

		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); //학생 수
		int M = sc.nextInt(); //등수

		int[][] arr = new int[M][N];
		for(int i=0; i<M; i++){
			for(int j=0; j<N; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		System.out.print(T.solution(N, M, arr));
	}
}
//i 가 4, j 가 3 으로 (3, 4) 일 때 첫 번째 테스트에서 3번은 0등, 4번은 1등
//두 번째 테스트에서 3번은 2등 4번은 1등 이므로 pi(2) < pi(1) 로 만족하지 못해 cnt를 증가시키지 못함 
//즉 3번째 테스트까지 했을 때 3번 학생이 4번 학생보다 등수가 앞서는 조건이 만족해야 짝을 이룰 수 있는 것이다.
// (3, 4) 일 경우는 cnt가 2가 된다. 따라서 M개 테스트인 3이 되지 못해서 짝을 이룰 수가 없다.


/* 입력
4 3
3 4 1 2
4 3 2 1
3 1 4 2
*/

/* 출력
3
*/
