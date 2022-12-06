import java.util.*;
class Main {
	private static int solution(int n) {
		int answer = 0;
		int[] ch = new int[n+1];
		for(int i=2; i<=n; i++){
			if(ch[i] == 0){
				answer++;
				for(int j=i; j<=n; j=j+i){ //j가 i의 배수로 돌아야 하기 때문에 i씩 증가
					ch[j] = 1;
				}
			}
		}

		return answer;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		System.out.println(solution(n));
	}
}



/* 입력
20
*/

/* 출력
8 
*/
