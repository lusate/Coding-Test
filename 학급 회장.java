import java.util.*;
class Main{
	public char solution(String s){
		//HashMap 을 써야한다는 것을 빨리 파악하고 key, value 의 type이 뭔지 파악한다.
		//입력 예제가 A기호 3표, B기호 3표 이런 식이므로 Character, Integer로 해야한다.
		HashMap<Character, Integer> map = new HashMap<>();
		char answer = ' ';

		//HashMap에서 카운팅이라는 것을 항상 기억하자.
		//s.toCharArray() 함수 : 문자열을 char형 배열로 바꿔준다
		for(char x : s.toCharArray()){
			//각 키의 value들을 0으로 초기화하고 개수를 카운트 해줌
			map.put(x, map.getOrDefault(x, 0) + 1);
			//System.out.println("x : " + x);
			//출력하면 x : B / x : A ~ x : D / x : E 까지 출력됨

		}

		int max = Integer.MIN_VALUE; //max 최솟값을 초기화

		for(char key : map.keySet()){
			//카운팅하여 map.get(key) 는 각 기호들의 투표 수를 센
			//key : 3,3,5,2,2 가 출력됨
			
			//System.out.println("key:" + key); key가 출력됨
			//System.out.println("key : " + map.get(key)); 각 key가 몇 개 있는지 개수를 셈
			if(map.get(key) > max){
				max = map.get(key);
				answer = key;
			}
		}

		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution("BACBACCACCBDEDE"));
		//System.out.println(T.solution("AAAAABBCCDDDD"));
	}
}
