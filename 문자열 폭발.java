//백준 방식
import java.util.*;
import java.io.*;
class Main{
	static String s, bomb;
	static Stack<Character> stack = new Stack<>();

	public String solution(String s, String bomb) {
		String answer="";
		
		for(int i=0; i<s.length(); i++){
			//스택에 s를 한 번에 다 넣는 것이 아님.
			stack.push(s.charAt(i));

			//스택에 있는 문자열의 길이가 bomb보다 길어야 함.
			if(stack.size() >= bomb.length()){
				boolean contain = true;
				for(int j=0; j<bomb.length(); j++){
					if(stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)){
						contain = false;
						break;
					}
				}
				if(contain){
					for(int j=0; j<bomb.length(); j++){
						stack.pop();
					}
				}
			}
			//System.out.println(stack);
		}
		
		/*if(stack.empty()){
			answer = "FRULA";
		}
		else{
			for(Character c : stack){
				answer += c;
			}
		}*/

		StringBuilder sb = new StringBuilder();
		for(Character c : stack) {
			sb.append(c);
		}
		
		// 문자열의 길이가 0이라면 FRULA 출력, 아니라면 문자열 출력
		return sb.length() == 0? "FRULA" : sb.toString();
		
	}
	public static void main(String[] args) throws Exception {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s = br.readLine();
		bomb = br.readLine();

		System.out.println(T.solution(s, bomb));
		//System.out.println(T.solution("mirkovC4nivCC44", "C4"));
		//System.out.println(T.solution("12ab112ab2ab", "12ab"));
	}
}


------------------------------------------------------------------------------------------
프로그래머스 방식
import java.util.*;
class Main{
	static String s, bomb;
	static Stack<Character> stack;

	public String solution(String s, String bomb) {
		String answer="";
		stack = new Stack<>();
		
		for(int i=0; i<s.length(); i++){
			//스택에 s를 한 번에 다 넣는 것이 아님.
			stack.push(s.charAt(i));

			//스택에 있는 문자열의 길이가 bomb보다 길어야 함.
			if(stack.size() >= bomb.length()){
				boolean contain = true;
				for(int j=0; j<bomb.length(); j++){
					if(stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)){
						contain = false;
						break;
					}
				}
				if(contain){
					for(int j=0; j<bomb.length(); j++){
						stack.pop();
					}
				}
			}
			//System.out.println(stack);
		}
		
		if(stack.empty()){
			answer = "FRULA";
		}
		else{
			for(Character c : stack){
				answer += c;
			}
		}
		
		return answer;
	}
	public static void main(String[] args) throws Exception{
		Main T = new Main();

		System.out.println(T.solution("mirkovC4nivCC44", "C4"));
		System.out.println(T.solution("12ab112ab2ab", "12ab"));
	}
}
