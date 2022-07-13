import java.util.*;
class Main{
	public String solution(String s){
		String answer = "YES";
		Stack<Character> stack = new Stack<>();

		for(char x : s.toCharArray()){
			if(x == '('){ //열린 괄호 '(' 면 스택에 넣음
				stack.push(x);
			}
			else{ ')' 일 때
				if(stack.empty()) return "NO";
				//x 가 ')' 인데 스택이 비어있다면 NO (즉 비어있는 상태인데 ')' 가 가장 먼저 나올 경우)
				
				//닫힌 괄호 ')' 인데
				stack.pop();
				//스택에서 뺀다.
			}
		}

		//스택이 비어있지 않은 경우 (즉 '(' 가 남아있는 경우)
		//'(' , ')' 가 pop() 되어 스택이 비어져야 YES다
		if(!stack.empty()) return "NO";
		return answer;
		
	}
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution("(()(()))(()"));
		System.out.println(T.solution("(())()"));
	}
}
