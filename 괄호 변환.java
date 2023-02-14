import java.util.*;
class Solution {
	public boolean check(String s){
		Stack<Character> stack = new Stack<>();
		for(char x : s.toCharArray()){
			if(x == '('){
				stack.push(x);
			}
			else{
				if(stack.empty()) return false;
				stack.pop();
			}
		}

		return true;
	}
	public String dfs(String s){
		if(s.length() == 0){
			return "";
		}

		String u = "";
		String v = "";
		int lt = 0;
		int rt = 0;

		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == '('){
				lt++;
			}
			else rt++;

			u += s.charAt(i);
			
			if(lt == rt){
				v = s.substring(i+1);
				break;
			}
		}

		if(check(u)){
			return u += dfs(v);
		}
		else{
			String tmp = "(";
			tmp += dfs(v);  // )( 의 방향을 뒤집음.
			tmp += ")";

			u = u.substring(1, u.length() - 1);
			for(int i=0; i<u.length(); i++){
				if(u.charAt(i) == '(') tmp += ')';
				else tmp += '(';
			}
			return tmp;
		}
	}
	public String solution(String p) {
		
		String answer = dfs(p);
		return answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution("(()())()"));
		System.out.println(T.solution("()"));
		System.out.println(T.solution("()))((()"));
	}
}


/* 출력
(()())()
()
()(())()
*/
