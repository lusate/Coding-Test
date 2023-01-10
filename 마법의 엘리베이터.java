import java.util.*;
class Solution{
	private static int solution(int storey) {
		int answer=0;

		//문자로 바꾸기
		String s = String.valueOf(storey);
		int cnt = 0;

		for(int i=1; i<=s.length(); i++){
			
			if((int)s.charAt(s.length() - i) - 48 >= 0 && (int)s.charAt(s.length() - i) - 48 <= 5){
				cnt = (int)s.charAt(s.length() - i) - 48;
				//System.out.println("cnt = " + cnt);
				storey -= cnt * Math.pow(10, i-1);
			}
			else{
				cnt = 10 - ((int)s.charAt(s.length() - i) - 48);
				storey += cnt * Math.pow(10, i-1);
			}
			s = String.valueOf(storey);
			System.out.println(storey);
			

			answer += cnt;
		}
		
		return answer;
	}
	
	public static void main(String[] args){
		//System.out.println(solution(16));
		System.out.println(solution());
		//System.out.println(solution());
	}
}


/* 출력
6
16
*/
