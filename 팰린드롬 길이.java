import java.util.*;

class Main{	
	public int solution(String s){
		HashMap<Character, Integer> map = new HashMap<>();
		
		int answer = s.length();
		for(char x : s.toCharArray()){
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		
		//펠린드롬(앞 뒤 문자열이 같음)을 할 때 알파벳 개수가 짝수면 양쪽에 배치함
		//홀수는 그렇게 못 함 그래서 홀수면 중심에 둬서 하나로 한다.
		//ex) abcbbbccaa -> bbcaaacbb    
		//예제에서는 aaa 를 가운데에 둠
		
		int cnt = 0;
		for(char key : map.keySet()){
			if(map.get(key) % 2 == 1){ //홀수인 경우
				//홀수를 하나로 묶어서 카운트
				cnt++;
				//System.out.println("cnt : " + cnt);
				//a:3, b:4, c:3 으로 홀수인 키는 a,c로 cnt는 2를 출력
			}
		}

		//answer는 s의 길이
		//cnt가 0보다 크면 앞에 실행 0보다 작으면 홀수가 없으므로 그대로 answer(s의 길이) 출력
		if(cnt > 0) return answer - cnt + 1;
		else return answer;
		//return cnt > 0 ? answer - cnt + 1 : answer;
	}
	public static void main (String[] args) throws java.lang.Exception{
		Main T = new Main();
		System.out.println(T.solution("abcbbbccaa"));
		System.out.println(T.solution("abcde"));
		System.out.println(T.solution("ccc"));
	}
}


//답
//9
//1
//3
