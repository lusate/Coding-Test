import java.util.*;
class Main {
	public int solution(int[] nums, int k){
		int answer, sum=0;
		for(int i=0; i<k; i++){
			sum += nums[i];
		}
    //윈도우로 묶어서 sum을 구함

		answer = sum;
    
		for(int i=k; i<nums.length; i++){
			sum += nums[i] - nums[i-k];
			answer = Math.max(sum, answer);
		}//묶은 윈도우를 오른쪽으로 계속 밀고감
    //계속 밀고 가면서 맨 앞 원소값을 빼주면서 감
    
		
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		int[] arr = new int[]{12, 15, 11, 20, 25, 10, 20, 19, 13, 15};
		System.out.println(T.solution(arr, 3));
		
	}
}


//답
//56
//26
