import java.util.*;
class Solution{
	public int solution(int[] nums) {
		int answer=0;
		int sum=0;
		int[] arr = new int[2];
		arr[0]=1;

		for(int x : nums){
			sum += x;
			//if(sum % 2 == 1) answer++;
			if(sum % 2 == 1){//홀수인 경우
				answer += arr[0];
			}
			else answer += arr[1];
			
			//sum이 홀수면 arr의 홀수 자리에 +1 누적
			arr[sum%2] += 1;

			//sum이 홀수라면 홀수 + 짝수이다. 그래서 if문에서 짝수쪽에 +1 해주고 밑에 arr[홀수]에 +1 누적해주는 것이다.
			//반대로 짝수라면 홀수 + 홀수 또는 짝수 + 짝수이므로 if문에 홀수쪽 +1, arr[홀수] +1
			//System.out.println(answer);
		}
		

		return answer;
	}
	
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[]{1, 3, 5}));
		System.out.println(T.solution(new int[]{2, 3, 2, 4, 5}));
		System.out.println(T.solution(new int[]{1, 2, 6, 2, 4, 3, 5, 3, 5, 3, 6, 3, 5, 4, 2, 3, 5, 1, 4, 3, 6}));
	}
}

/* 출력
4
9
121
*/
