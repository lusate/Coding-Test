import java.util.*;
public class Main {
	public int solution(int A, int B) {
		int answer = 1;
		
		while(A != B) {
			if(B < A) {
				answer = -1;
				break;
			}
			if(B % 2 == 0) {
				B = B / 2;
			}
			else if(B % 10 == 1) {
				B = B / 10;
			}
			else {
				answer = -1;
				break;
			}
			
			answer++;
		}
		System.out.println(answer);
		return answer;
	}
	
	public static void main(String[] args) throws Exception {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();

		T.solution(A, B);
	}
}
