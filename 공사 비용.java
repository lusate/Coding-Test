import java.util.*;
class Solution{
	private static int solution(int[] cost, int m) {
		int answer=0;

		int left=0;
		int sum=0;
		for(int right=0; right<cost.length; right++){
			sum += cost[right];

			while(sum > m){
				sum -= cost[left];
				left++;
			}

			answer = Math.max(answer, (right-left+1));
		}
		
		return answer;
	}
	
	public static void main(String[] args){
		System.out.println(solution(new int[]{0, 150, 100, 10, 150, 10, 70, 140}, 350));
		System.out.println(solution(new int[]{100, 200, 300, 400, 500, 100}, 300));
		System.out.println(solution(new int[]{0, 10, 50, 0, 100, 50, 50, 30, 70, 150, 0, 10,
			50, 0, 10}, 500));
	}
}
