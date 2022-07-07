//제곱수 정렬 sort() 사용하지 말 것
import java.util.*;
class Main{	
	public int[] solution(int[] nums){
		//배열을 리턴한다.
		int n = nums.length;
		int[] answer = new int[n];

		int left = 0;
		int right = n-1;

		for(int i=n-1; i>=0; i--){
			//절대값 쓰고 
			if(Math.abs(nums[left] < nums[right])){
				answer[i] = nums[right] * nums[right];
				right--;
			}
			//양쪽 끝을 절대값으로 만들고 nums[right]가 크다면 nums[right] 를 제곱
			//nums[left] 가 크다면 nums[left]를 제곱
			else{
				answer[i] = nums[left] * nums[left];
				left++;
			}
		}
		return answer;
	}
	public static void main (String[] args){
		Main T = new Main();
		int[] tmp1 = new int[]{"-4, -1, 0, 3, 10"};
		for(int x : T.solution(tmp1)){
			System.out.println(T.solution(tmp1));
		}
		//String[] tmp2 = new String[]{"-7, -3, 2, 3, 11"};
		//System.out.println(T.solution(tmp2));
	}
}
