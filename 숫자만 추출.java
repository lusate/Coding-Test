import java.util.*;
class Main {
	public int solution(String s){
		int answer = 0;
		//아스키 코드 사용.
		//문자 '0'은 48, 문자 '9'는 57
		for(char x : s.toCharArray()){
			if(x >= 48 && x <= 57){ //문자인 숫자.
				answer = answer * 10 + (x-48);
			}
		}
		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		System.out.println(T.solution(s));
	}
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.*;
class Main {
	public int solution(String s){
		String answer = "";
		
		for(char x : s.toCharArray()){
			//isDigit() - char 값이 숫자 인지 여부를 판단하여 숫자면 더함.
			if(Character.isDigit(x)) answer += x;
		}
    //0208 이라는 문자열 의 결과가 나오므로 이것을 parseInt() 하여 숫자화 해줌.
		return Integer.parseInt(answer);
	}
	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		System.out.println(T.solution(s));
	}
}

/* 입력
tge0a1h205er

g0en2T0s8eSoft
*/
/* 출력
1205

208
*/
