import java.util.*;
class Main{
	public String solution(String s){
		Stack<Character> stack = new Stack<>();
		String answer = "";
		for(char x : s.toCharArray()){
			if(x == '('){
				stack.push(x);
			}
			else if(x == ')'){
				stack.pop();
			}
			else{ //알파벳인 경우
				//알파벳인데 '(' 가 있으면 if문 안하고 넘어감, 알파벳은 push 안 함
				//(A(BC)D)) 해서 stack이 비어있다면 answer+=x 즉 EF 가 됨
				if(stack.empty()) answer+=x;
			}
		}

		for(char x : stack) answer += x;

		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution("(A(BC)D)EF(G(H)(IJ)K)LM(N)"));
	}
}


//답
//EFLM

------------------------------------------------------------------------------------------------------
	
//다른 방법
import java.util.*;
class Main{
	public String solution(String s){
		Stack<Character> stack = new Stack<>();
		String answer = "";
		for(char x : s.toCharArray()){
			if(x == ')'){
				while(stack.pop() != '('); //( 만날 때까지 반복해서 pop()
			}
			else{//닫는 괄호가 아니면 다 넣음
				stack.push(x);
			}
		}

		for(char x : stack) answer += x;

		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution("(A(BC)D)EF(G(H)(IJ)K)LM(N)"));
	}
}
