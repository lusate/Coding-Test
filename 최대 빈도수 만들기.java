import java.util.*;
class Solution{
	public int solution(int[] nums, int k) {
		int answer=0;
		int sum = 0;

		Arrays.sort(nums);
		int left=0;
		for(int right=0; right<nums.length; right++){
			int n = nums[right];  // 7
			sum += n;

			while(n * (right - left + 1) > sum + k){ // 35 > 33
				sum -= nums[left];
				left++;
			}
			//System.out.println(nums[left]);
			//최대 빈도수는 5
			answer = Math.max(answer, (right-left+1));
		}
		
		return answer;
	}
	
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[]{5, 7, 8, 2, 9, 6, 3}, 10));
		System.out.println(T.solution(new int[]{1, 2, 4, 7}, 5));
		System.out.println(T.solution(new int[]{-1, 1, 2, 4, 0, -2}, 6));
	}
}

/* 출력
5
3
4
*/
