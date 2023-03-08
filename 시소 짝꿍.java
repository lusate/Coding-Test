import java.util.*;
class Solution {
    public long solution(int[] weights) {
		long answer=0;

        Arrays.sort(weights);
		HashMap<Double, Integer> map = new HashMap<>();

		for(int x : weights){
			Double w = Double.valueOf(x);

			if(map.containsKey(w)){
				
				answer += map.get(w);
			}

			map.put(w, map.getOrDefault(w, 0) + 1); // 비율이 1 : 1의 경우
			map.put(w*4/3, map.getOrDefault(w * 4 / 3, 0) + 1); //비율이 4 : 3의 경우
			map.put(w*3/2, map.getOrDefault(w * 3 / 2, 0) + 1); //비율이 3 : 2의 경우
			map.put(w*4/2, map.getOrDefault(w * 4 / 2, 0) + 1); //비율이 4 : 2의 경우
		}

		return answer;
    }

	public static void main(String args[]){
		Solution T = new Solution();
		System.out.println(T.solution(new int[]{100,180,360,100,270}));
		System.out.println(T.solution(new int[]{100,180,300,100,270}));
	}
}

/* 출력
4
2
*/
