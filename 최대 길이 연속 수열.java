import java.util.*;
class Solution {
    public int solution(int[] nums) {
		int answer = 0;
		HashSet<Integer> set = new HashSet<>(); //()안에 asList은 int[] 불가.
		
		for(int x : nums) set.add(x);
	  	//[0, 1, 2, 3, 4, 8, 9, 10]

		for(int x : set){
			if(set.contains(x-1)) continue; //이미 확인했던 숫자면 continue

			int cnt = 0;
			while(set.contains(x)){
				x++;
				cnt++;
			}

			answer = Math.max(answer, cnt);
		}

		return answer;
    }

	public static void main(String args[]){
		Solution T = new Solution();
		System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));

	}
}



/* 출력
5
10
1
3
*/
