import java.util.*;
class Main{
	public int solution(String str){
		int answer=0;
		Stack<Integer> stack = new Stack<>();
		for(char x : str.toCharArray()){
			if(Character.isDigit(x)) stack.push(x - 48);
			else{
				int rt = stack.pop();
				int lt = stack.pop();
				if(x == '+') stack.push(lt+rt);
				else if(x == '-') stack.push(lt - rt);
				else if(x == '*') stack.push(lt * rt);
				else if(x == '/') stack.push(lt / rt);
			}
		}
		answer = stack.get(0);
		System.out.println(answer);
		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		T.solution(str);
	}
}


/* 입력
352+*9-
*/

/* 출력
12
*/
