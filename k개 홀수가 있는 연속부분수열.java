import java.util.*;
class Main {
	public int counting(int[] nums, int k){
		int left=0;
		int answer = 0;
		int cnt=0;

		for(int right=0; right<nums.length; right++){
			if(nums[right] % 2 == 1){
				cnt++;
				System.out.println(cnt);
			}
			while(cnt > k){ // 홀수 개수가 k개 이상
				if(nums[left] == 1) cnt--;
				left++;
			}
			//cnt > k인 상태에서 nums[left] == 1 이어야 left가 움직인다.

			answer += (right-left+1);
			//System.out.println("answer:"+answer);
			//counting(nums, k) -> 1,3,6,9,13
			//counting(nums, k) -> 1,3,5,6,8
		}

		return answer;
	}
	public int solution(int[] nums, int k){
		int answer=counting(nums, k)-counting(nums, k-1);
		//counting(nums, 2) 는 홀수가 0~2개 이다. (즉 홀수가 0개, 1개일 때도 포함되어 있다)
		//counting(nums, 2) 는 홀수가 0~k-1 이므로 빼준다. (즉 홀수가 0개 일 때도 포함되어 있다.)
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		int[] arr1 = new int[]{1, 2, 1, 1, 2};
		System.out.println(T.solution(arr1, 2));
		//int[] arr2 = new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
		//System.out.println(T.solution(arr2, 2));
	}
}
