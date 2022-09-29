import java.util.*;
public class Main {
	public int solution(String word) {
		int answer=word.length();
		char[] ch = {'A','E','I','O','U'};
		int[] num = {781, 156, 31, 6, 1};

		for(int i=0; i<word.length(); i++){
			for(int j=0; j<5; j++){
				if(word.charAt(i) == ch[j]){
					answer += num[i] * j;
				}
			}
		}
		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution("AAAAE"));
		System.out.println(T.solution("AAAE"));
		System.out.println(T.solution("I"));
		System.out.println(T.solution("EIO"));
	}
}
