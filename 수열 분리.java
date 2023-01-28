import java.util.*;
class Solution {
    public int solution(int[] nums) {
		int answer = 0;
		int n = nums.length;

		int[] minR = new int[n];
		minR[n-1] = nums[n-1]; // 맨 끝부분은 값이 그대로.
		
		//2개, 3개, 4개 비교해서 최소값을 삽입
		for(int i=n-2; i>=0; i--){
			minR[i] = Math.min(nums[i], minR[i+1]);
		}

		int curMax = nums[0];
		for(int i=1; i<n; i++){
			curMax = Math.max(curMax, nums[i-1]);
			if(curMax <= minR[i]) return i;
		}


		return answer;
    }

	public static void main(String args[]){
		Solution T = new Solution();
		System.out.println(T.solution(new int[]{1, 3, 2, 0, 7, 9, 8, 7}));
		// System.out.println(T.solution(new int[]{3, 5, 3, 1, 2, 5, 3, 5, 7}));
		// System.out.println(T.solution(new int[]{5, 4, 3, 2, 1, 5, 4, 3, 2, 1, 5}));
	}
}


/* 출력
4
7
3
*/
