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
				//차를 구할 때 nums[1] - nums[0]으로 바로 옆에 있는 값끼리만 구하는 게 아니라
				//거리가 떨어져 있는 값끼리의 차를 구해야 하므로 +=을 한다.
				height += nums[i+1] - nums[i];
			}
			else{
				//증가수열이 아닌 경우로 answer, height 최대값을 구하고 height를 0으로 초기화
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
