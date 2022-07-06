import java.util.*;
class Main{
	public int solution(String s){
		HashMap<Character, Integer> map = new HashMap<>();

		//한번만 사용한 문자를 찾아야하므로 카운팅해준다.
		for(char x : s.toCharArray()){
			map.put(x, map.getOrDefault(x, 0) + 1);
		}

		//카운팅 해준 것에서 개수가 1개이면
		for(int i=0; i<s.length(); i++){
			//map.get(s.charAt(i)) 라고 하면 입력한 문자열에서 각 문자의 개수를 세서 출력한다.
			//System.out.println("map : " + map.get(s.charAt(i)));

			//한 번만 사용한 문자라면 인덱스를 리턴
			if(map.get(s.charAt(i)) == 1){
				return i+1; //인덱스가 1부터 시작하므로 +1을 해준다.
			}
		}
		
		return -1;
	}

	public static void main(String args[]){
		Main T = new Main();
		System.out.println(T.solution("statitsics"));
		//System.out.println(T.solution("aabb"));
	}

}
