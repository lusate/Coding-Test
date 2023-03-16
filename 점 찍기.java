import java.util.*;
class Solution{
	public long solution(int k, int d) {
		long answer = 0;

		// 원의 방정식처럼 생각
		// x^2 + y^2 <= d^2

		for(int i=0; i<=d; i+=k){
			// y의 최대값
			int y = (int) Math.sqrt(Math.pow(d, 2) - Math.pow(i, 2)); //i가 x

			answer += y / k; //최대값 y에서 나누기 k한 것이 나올 수 있는 좌표 개수
			answer += 1; //(0, 0)이 포함되지 않았으므로 1 더해줌.
		}

		return answer;
	}

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(2, 4));
		System.out.println(T.solution(1, 5));
	}
}

/* 출력
6
26
*/
