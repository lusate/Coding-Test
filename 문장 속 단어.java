import java.util.*;
public class Main{
	public String solution(String str){
		String answer = "";
		int max = Integer.MIN_VALUE; //가장 작은 값으로 초기화.

		String[] s = str.split(" ");
		for(String x : s){
			int len = x.length();
			if(len > max){
				max = len;
				answer = x;
			}
		}
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		System.out.println(T.solution(str));
	}
}

----------------------------------------------------------------------------------
//substring(), indexOf() 이용

import java.util.*;
public class Main{
	public String solution(String str){
		String answer = "";
		int max = Integer.MIN_VALUE;
		int pos;

		//index를 찾을 때 공백을 발견하면 리턴 공백을 발견 못하면 -1리턴
		while((pos = str.indexOf(" ")) != -1){
			String tmp = str.substring(0, pos); //공백 발견까지
			// 그럼 tmp가 it이 된다.

			int len = tmp.length();
			if(len > max){
				max = len;
				answer = tmp;
			}

			str = str.substring(pos+1);
		} 
		//공백이 없어서 마지막 study를 보지 않음
		if(str.length() > max) answer = str;
		//그래서 마지막 문자 study가 max 보다 크면 이게 answer가 됨.

		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		System.out.println(T.solution(str));
	}
}


//입력 - it is time to study
//출력 - study
