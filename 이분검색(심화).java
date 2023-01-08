import java.util.*;
class Main{
	private static int solution(int[] nums, int m){
		int answer = 0;
		int n = nums.length;
		int left = 0;
		int right = n-1;

		Arrays.sort(nums);

		while(left <= right){
			int mid = (left+right)/2;
			
			if(nums[mid] == m){
				answer = mid + 1; //인덱스 0부터 시작이므로 1 플러스 해줌.
			}

			if(nums[mid] > m) right = mid - 1;
			else left = mid + 1;
		}

		return answer;
	}
	
	public static void main(String[] args){
		System.out.println(solution(new int[]{23, 87, 65, 12, 57, 32, 99, 81}, 32));
	}
}


/* 출력
3
*/
