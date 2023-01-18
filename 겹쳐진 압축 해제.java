import java.util.*;
class Solution{
	public String solution(String s){
		String answer = "";
		Stack<String> stack = new Stack<>();
		
		for(char x : s.toCharArray()){
			if(x == ')'){
				String tmp = "";
				while(!stack.empty()){
					String str = stack.pop();
					//System.out.print(str + " ");
					//d  c  (  cd  (  cdcdcd  b  a  (
					if(str.equals("(")){
						//숫자화
						String num = "";
						while(!stack.empty() && Character.isDigit(stack.peek().charAt(0))){
							//stack.peek() 는 2(ab3 에서 마지막 원소 3.
							num += stack.pop();
						}

						int cnt = 0;
						if(num.equals("")) cnt=1; //아무것도 없으면 cnt는 1로 그냥 1번만 더해줌.
						else cnt = Integer.parseInt(num);

						String res = "";
						for(int i=0; i<cnt; i++){
							res += tmp; //3이면 3번 더해줌. -> cdcdcd
						}
						stack.push(res);
						System.out.println(stack);
						break; // while(!stack.empty()){ 를 빠져나옴.

					}

					else{
						tmp = str + tmp;
						//System.out.print(tmp + " ");
						//d  cd  cd  cdcdcd  bcdcdcd  abcdcdcd
					}

				}
			}

			else{ // '(', 알파벳, 숫자
				stack.push(String.valueOf(x));
			}
		
		}
		for(String x : stack) answer += x;

		return answer;
	}
	public static void main(String[] args){
		Solution T = new Solution();
		//System.out.println(T.solution("2(ab)k3(bc)"));
		System.out.println(T.solution("2(ab3((cd)))"));
	}
}


/* 출력
"ababkbcbcbc"
"abcdcdcdabcdcdcd"
*/
