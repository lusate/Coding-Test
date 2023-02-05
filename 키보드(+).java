import java.util.*;
class Solution {
    public int solution(String[] s, int k) {
		int answer = 0;
		int cnt = 1 << s.length; //원소 x개일 때 부분집합 개수, 현재 4개이므로 총 집합 개수 16개.
		
		HashMap<Character, Integer> map = new HashMap<>();

		for(int i=0; i<cnt; i++){
			int sum = 0;
			int shift = 0;

			for(int j=0; j<s.length; j++){
				// 부분 집합에 속하는지를 판단
				if((i & (1 << j)) == 0) continue;

				int score = s[j].length();
				for(char x : s[j].toCharArray()){
					//공백이면 패스, 공백도 키의 개수에서 제외하지 않는다면 공백을 키로 잡음.
					if(x == ' ') continue;

					if(x >= 65 && x <= 90){
						x = (char)(x+32); //소문자로 교체
						shift = 1;
						score++;
					}

					map.put(x,1);
					// System.out.println(map);

				}
				sum += score;
			}

			if(map.size() + shift <= k) answer = Math.max(answer, sum);
			map.clear();
		}
		return answer;
    }

	public static void main(String args[]){
		Solution T = new Solution();
		System.out.println(T.solution(new String[]{"Ges Big", "Ges in Big", "Big size", "Ges size"}, 7));
		System.out.println(T.solution(new String[]{"Time is Gold", "Gold", "Gold line Ggg"}, 9));
	}
}


/* 출력
27
20
*/
