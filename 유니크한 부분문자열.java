import java.util.*;
class Solution{
	public int solution(String s, int k) {
		int answer=300000;
		int n = s.length();
		HashMap<Character, Integer> map = new HashMap<>();

		int left=0;
		for(int right=0; right<n; right++){
			//원래는 map{a=2, b=3, c=2, d=1, e=1} 까지 하면 이제 map.size()가 5가 되므로 while문 실행
			
			map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
			
			while(map.size() == k){ //map size가 5라면 계속 반복.
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
		Solution T = new Solution();
		System.out.println(T.solution("abacbbcdede", 5));
		System.out.println(T.solution("acbbcdbbedeade", 4));
	}
}


/* 출력
7
5
*/
