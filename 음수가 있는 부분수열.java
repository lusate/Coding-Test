import java.util.*;
class Solution{
	public int solution(int[] nums, int m){
		int answer = 0;
		HashMap<Integer, Integer> map = new HashMap<>();

		int sum=0;
		for(int x : nums){
			//sum을 키로 해서 카운팅.
			sum += x;

			if(sum == m){
				answer++;
			}
	
			if(map.containsKey(sum-m)){
				answer += map.get(sum-m);
			}

			map.put(sum, map.getOrDefault(sum, 0)+1);
		}

		return answer;
	}

	//투 포인터로는 m의 값이 되기 위해 값이 계속 증가해야 한다는 조건때문에 가능했음.
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
		System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
		System.out.println(T.solution(new int[]{-1, 0, 1}, 0));
		System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));
	}
}


/* 출력
5
6
2
1
*/
