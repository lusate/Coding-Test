import java.util.*;
class Main {
	public int solution(int[] nums, int k){
		int answer=0;
		int cnt=0; //0을 만나는 개수
		int left=0; 
		for(int right=0; right<nums.length; right++){
			if(nums[right] == 0){
				cnt++;
			}
			while(cnt > k){ //0의 개수의 개수가 k를 넘으면 반복
				if(nums[left] == 0) cnt--;
				left++;
				//0 이 k보다 크면 num[left] == 0을 만날 때까지
				//반복해서 left 인덱스를 증가
			}
			answer = Math.max(answer, right - left + 1);
		}
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		int[] arr = new int[]{1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1};
		System.out.println(T.solution(arr, 2));
		
	}
}
