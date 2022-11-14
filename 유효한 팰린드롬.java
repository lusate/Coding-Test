import java.util.*;
class Main {
	public String solution(String s){
		String answer = "no";

		//대문자가 아니면 아닌 것들을 모두 빈 문자화 시킨다.
		s = s.toUpperCase().replaceAll("[^A-Z]", "");
		System.out.println(s); // FOUNDTIMESTUDYYDUTSEMITDNUOF
		
		String tmp = new StringBuilder(s).reverse().toString();

		if(s.equals(tmp)) answer = "yes";
		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		System.out.println(T.solution(s));
	}
}


/* 입력
found7, time: study; Yduts; emit, 7Dnuof
*/

/* 출력
yes
*/
