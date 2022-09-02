import java.util.*;

class Main{	
	public String solution(String s){
		HashMap<Character, Integer> map = new HashMap<>();
		String answer = "";

		//s를 대문자로
		String tmp = s.toUpperCase();

		for(char x : tmp.toCharArray()){
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		
		//카운팅해서 max 값 찾고 max 보다 작으면 더해줘서 빈도수를 맞춘다.
		//1) max값 찾기
		int max = Integer.MIN_VALUE;
		for(char key : map.keySet()){
			if(map.get(key) > max){
				max = map.get(key);
			}
		}
		
		//2) max보다 작으면 더해준다.
		for(int i=0; i<s.length(); i++){
			if(map.get(tmp.charAt(i)) < max){
				//이렇게 하면 answer는 String인데 s.charAt(i)는 문자여서 출력 불가
				//answer = s.charAt(i);
				answer += s.charAt(i);
				//System.out.println("ans : " + answer);
			}
		}
		
		return answer;
	}
	public static void main (String[] args){
		Main T = new Main();
		System.out.println(T.solution("abcabcdefabc"));
		System.out.println(T.solution("ABCabcA"));
		System.out.println(T.solution("abcabca"));
		System.out.println(T.solution("ABCabcA"));
	}
}


//답
//def
//BCbc
//bcbc
//BCbc
