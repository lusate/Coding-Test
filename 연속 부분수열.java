import java.util.*;
class Main {
	public int solution(int[] nums, int m){
		int answer=0;
		int sum=0;
		int left = 0;

		//right는 0~끝까지
		for(int right = 0; right < nums.length; right++){
			sum+=nums[right];
			while(sum > m){
				sum -= nums[left];
				left++;
			}
			if(sum == m){
				answer++;
			}
		}
		
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		int[] arr1 = new int[]{1, 2, 1, 3, 1, 1, 1, 2};
		System.out.println(T.solution(arr1, 6));
		int[] arr2 = new int[]{1, 1, 1, 1, 1, 1};
		System.out.println(T.solution(arr2, 3));
		int[] arr3 = new int[]{1, 2, 1, 2, 1, 2, 1};
		System.out.println(T.solution(arr3, 3));
	}
}
