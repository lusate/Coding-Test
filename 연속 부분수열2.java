import java.util.*;
class Main {
	public int solution(int[] nums, int m){
		int answer=0;
		int sum=0;
		int left = 0;

		for(int right = 0; right < nums.length; right++){
			sum+=nums[right];
			
			while(sum > m){
				sum-=nums[left];
				left++;
				//sum에서 맨앞 원소 nums[left]를 빼주고
				//left++
			}

			//부분수열 개수를 구함
			answer+=(right-left+1);
		}
		
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		int[] arr1 = new int[]{1,3,1,2,3};
		System.out.println(T.solution(arr1, 5));
		int[] arr2 = new int[]{1,1,1,1,1,1};
		System.out.println(T.solution(arr2, 3));
		int[] arr3 = new int[]{1,1,2,2,1,2,1,3,2};
		System.out.println(T.solution(arr3, 5));
	}
}
