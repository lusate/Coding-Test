import java.util.*;
class Main{
	public int solution(String s, int n){
		//아스키 코드를 기억
		//소문자는 97~122 / 대문자는 65~90 

		int[] used = new int[27]; //알파벳 개수(26) + Shift

		//char가 아닌 int로 잡으면 알파벳의 아스키 코드가 나온다.
		for(int x : s.toCharArray()){
			if(x >= 97 && x <= 122){
				used[x - 97] = 1;
			}
			else if(x >= 65 && x <= 90){
				used[26] = 1; //Shift
				used[x - 65] = 1;
			}
		}

		int cnt = 0;

		//알파벳 0~26까지 모두 했을 때 1인 알파벳은 cnt++
		//Shift도 포함이다.
		for(int i=0; i<27; i++){
			if(used[i] == 1){
				cnt++;
			}
		}
		//n개의 자판 보다 cnt가 같거나 작으면 s의 문자열 길이(점수)를 리턴 
		//(공백도 포함)
		if(cnt <= n){
			return s.length();
		}
		
		//n개 알파벳으로 문자을 완성할 수 없는 경우
		return -1;
	}
	public static void main (String[] args){
		Main T = new Main();
		System.out.println(T.solution("time to time", 5));
		//글자 수만큼 점수를 얻는다. 그래서 12점
		System.out.println(T.solution("Big Life is Good", 10));
		//16점
	}
}
