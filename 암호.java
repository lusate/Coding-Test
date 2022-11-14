import java.util.*;
class Main {	
	public String solution(int n, String s){
		String answer = "";
		for(int i=0; i<n; i++){
			String tmp = s.substring(0, 7)
			.replace('#', '1').replace('*', '0');

			//10진수화
			int num = Integer.parseInt(tmp, 2); //tmp와 2진수
			answer += (char)num; //문자를 더함
			s = s.substring(7); //7개씩 끊어서 출력됨.
			//System.out.println(tmp);
		}
		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		T.solution(n, s);
	}
}


/* 입력
4
#****###**#####**#####**##**
*/

/*출력
COOL
*/
