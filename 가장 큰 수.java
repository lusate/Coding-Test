import java.util.*;
class Main {
	public String solution(String s, int m){
		String answer = "";
		Stack<Integer> stack = new Stack<>();
		
		//s 가 String 인데 int x로 했으므로 숫자 아스키코드가 나옴
		for(int x : s.toCharArray()){
			//x = 53, 50, 55, 54, 56, 50, 51
			//숫자 아스키코드는 48~57 (그래서 48을 뺌)
			
			//stack.peek() 스택 상단에 있는게 x 보다 작으면
			while(!stack.empty() && m > 0 && stack.peek() < (x-48)){
				//자신이 오른쪽 보다 작으면 pop -> 내림차순인데 커지는 내림차순
				stack.pop();
				m--;
			}
			//x를 push 함
			stack.push(x-48);
		}
		//이게 없으면 753421 를 할 때 m=2에서 멈춰버리고 더 이상 제거를 하지 않는다.
		//그래서 m이 0이 될 때까지 반복해서 제거한다.
		while(m>0){
			stack.pop();
			m--;
		}
		for(int x : stack){
			answer += x;
		}
		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution("5276823", 3));
		//System.out.println(T.solution("9977252641", 5));
		//System.out.println(T.solution("753421", 3));
	} 
}

//반대로 자신이 왼쪽 보다 크면 pop -> 오름차순인데 작아지는 오름차순이다.
