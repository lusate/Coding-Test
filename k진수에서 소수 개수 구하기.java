import java.util.*;
class Solution{
	//k진수로 변환
	public String convert(int n, int k){
		int a = n / k;
		int b = n % k;

		//몫이 0이 될 때까지 반복해서 나눔.
		if(a != 0){
			return convert(a, k) + String.valueOf(b);
		}
		else return String.valueOf(b);
	}

	//소수 체크
	public boolean check(long num){
		if(num == 1) return false;
		if(num == 2) return true;
		if(num % 2 == 0) return false;

		for(int i=3; i<=(long)Math.sqrt(num); i+=2){ //3,5,7,9... 로 num을 나눔.
			if(num % i == 0) return false; 
		}
		return true;
	}
	public int solution(int n, int k) {
		int answer = 0;

		//진수로 변환한 숫자
		String num = k==10 ? String.valueOf(n) : convert(n, k);
		String[] nums = num.split("0+");

		for(String x : nums){ //nums 부분 타입이 long이 될 수도 있음
			if(check(Long.parseLong(x))){
				answer++;
			}
		}
		
		return answer;
	}

	
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(437674, 3));
		System.out.println(T.solution(110011, 10));
	}
}

// 진법 확인
// 진수를 구할 때 현재 값에서 구하고자 하는 진법의 수를 나눈 나머지를 보면 된다.
// 437674 % 3 계속

// 소수 확인
// 현재 값에서 약수를 찾는데 현재 값의 루트 값까지만 진행.

/* 출력
3
2
*/
