//가장 높은 증가수열
import java.util.*;
class Main{	
	public int solution(int[] nums){
		//차
		int height = 0;
		//가장 높은 부분증가수열을 뽑은 후 높이
		int answer = 0;

		for(int i=0; i < nums.length-1; i++){
			if(nums[i] < nums[i+1]){
				height += nums[i+1] - nums[i];
			}
			else{
				answer = Math.max(answer, height);
				height = 0;
			}
		}
		answer = Math.max(answer, height);

		return answer;
	}
	public static void main (String[] args){
		Main T = new Main();
		int[] tmp1 = new int[]{8, 12, 2, 3, 7, 6, 12, 20, 3};
		System.out.println(T.solution(tmp1));
		
		int[] tmp2 = new int[]{5, 2, 4, 7, 7, 3, 9, 10, 11};
		System.out.println(T.solution(tmp2));
	}
}
