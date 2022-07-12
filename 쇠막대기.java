//쇠막대기
import java.util.*;
class Main {
	public int solution(String s){
		int answer=0;
		Stack<Character> stack = new Stack<>();

		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == '('){  //'('면 push를 한다
				stack.push(s.charAt(i));
			}
			else{
				//')' 만났을 때 레이저인지 막대기의 끝을 나타내는지 판단해야함
				//')' 만나면 일단 pop
				stack.pop();

				if(s.charAt(i-1) == '('){ //레이저인 경우, ()인 경우
					answer += stack.size();
				}
				else{ // ')' 만났는데 연속으로 나오면
					answer++;
				}
			}
		}
		
		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution("()(((()())(())()))(())"));
		System.out.println(T.solution("(((()(()()))(())()))(()())"));
	} 
}
