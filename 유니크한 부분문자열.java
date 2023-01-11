import java.util.*;
class Solution{
	private static int solution(String s, int k) {
		int answer=300000;
		int n = s.length();
		HashMap<Character, Integer> map = new HashMap<>();

		int left=0;
		for(int right=0; right<n; right++){
			map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
			
			while(map.size() == k){
				answer = Math.min(answer, right-left+1);
				map.put(s.charAt(left), map.get(s.charAt(left)) - 1);

				//remove 시키고 left 증가.
				if(map.get(s.charAt(left)) == 0){
					map.remove(s.charAt(left));
				}
				left++;
				System.out.println(map);
			}
		}


		return answer;
	}
	
	public static void main(String[] args){
		System.out.println(solution("abacbbcdede", 5));
		//System.out.println(solution("acbbcdbbedeade", 4));
	}
}


/* 출력
7
5
*/
