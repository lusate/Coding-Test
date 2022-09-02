import java.util.*;

class Main{
	public ArrayList<Integer> solution(String s){
		HashMap<Character, Integer> map = new HashMap<>();
		ArrayList<Integer> answer = new ArrayList<>();

		for(char x : s.toCharArray()){
			map.put(x, map.getOrDefault(x, 0) + 1);
		}

		int max = Integer.MIN_VALUE;
		for(char key : map.keySet()){
			if(map.get(key) > max){
				//최대 빈도수를 구함
				max = map.get(key);
			}
		}

		//for(char x : s.toCharArray()){
			//answer ArrayList 에 .add() 함수로 추가해준다.

			//answer.add(map.get(x));
			//출력하면 [3, 3, 3, 1, 1]
			//출력하면 [2, 2, 2, 2]

			//answer.add(max - map.get(x));
			//출력하면 [0, 0, 0, 2, 2]
			//출력하면 [0, 0, 0, 0]

			//answer.add(max-map.getOrDefault(x, 0));
		//}
		
		String tmp = "abc";
		for(char x : tmp.toCharArray()){
			//answer.add(map.get(x));
			//출력하면 [3, 1, 1]
			//출력하면 [2, 2, null]

			//answer.add(max - map.get(x));
			//출력하면 [0, 2, 2]
			//출력하면 "java.util.HashMap.get(Object)" is null

			answer.add(max-map.getOrDefault(x, 0));
			
		}

		//HashMap의 경우 동일 키 값을 추가할 경우 Value의 값이 덮어쓰기가 된다.
		//따라서 기존 key 값의 value를 계속 사용하고 싶을 경우 getOrDefault 메서드를 사용


		return answer;
	}
	
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution("aaabc"));
		System.out.println(T.solution("aabb"));
		System.out.println(T.solution("abc"));
	}
}


//답
//[0, 2, 2]
//[0, 0, 2]
//[0, 0, 0]
