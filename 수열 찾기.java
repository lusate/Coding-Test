import java.util.*;
class Main{
	private static int[] solution(int[] nums){
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] answer = new int[nums.length/2];
		
		Arrays.sort(nums);
		for(int x : nums){
			map.put(x, map.getOrDefault(x, 0)+1);
		}

		int idx = 0;
		for(int x : nums){
			//map에서 개수를 보니 0이면 answer가 아니므로 pass
			if(map.get(x) == 0) continue;
			//answer에는 nums의 숫자들을 삽입.
			answer[idx++] = x;

			//nums의 숫자면 map에서 개수를 -1해줌.
			map.put(x, map.get(x) - 1);
			//nums의 숫자 * 2를 해서 map에서 똑같이 개수를 -1해줌.
			map.put(x*2, map.get(x*2) - 1);
		}


		return answer;
	}
	
	public static void main(String[] args){
		//System.out.println(Arrays.toString(solution(new int[]{1, 10, 2, 3, 5, 6})));
		System.out.println(Arrays.toString(solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
		//System.out.println(Arrays.toString(solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
	}
}



/* 출력
[1, 3, 5]

[1, 1, 3, 7]

[2, 3, 5, 5, 7, 7]
*/
