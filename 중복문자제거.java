import java.util.*;
public class Main{
	public String solution(String s){
		String answer = "";
		
		for(int i=0; i<s.length(); i++){
			//indexOf() 로 이미 나왔던 index의 문자는 제거
			//System.out.println(s.charAt(i) + " " + i + " " + s.indexOf(s.charAt(i)));

			//i는 그 문자의 현 위치
			//s.indexOf(s.charAt(i)) 는 그 문자가 나온 위치
			if(s.indexOf(s.charAt(i)) == i){
				answer += s.charAt(i);
			}
		}
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		System.out.println(T.solution(s));
	}
}


/*입력
ksekset
*/

/*출력
kset
*/
