import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = s.length();

		int cnt = 1; //같은 문자열 개수.
		for(int i=1; i<=s.length()/2; i++){ //i는 단위 개수
			StringBuilder sb = new StringBuilder();

			String str = s.substring(0, i);
			for(int j=i; j<=s.length(); j+=i){
				int end = Math.min(j+i, s.length()); // j+=i가 될 때 s.length()를 넘어서 가버리기 때문에 end가 필요하다.

				String tmp = s.substring(j, end);
				if(str.equals(tmp)){ //맨 앞의 str과 그 다음 tmp와 같은지 확인하면서 진행
					cnt++;
				}

				else{
					if(cnt >= 2){
						sb.append(cnt);
					}
					sb.append(str);
					str = tmp; //str과 같은 나머지 문자열.
					cnt = 1;
				}
			}

			sb.append(str);
			System.out.println(sb);
			answer = Math.min(answer, sb.length());
		}
        return answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution("aabbaccc"));
		System.out.println(T.solution("ababcdcdababcdcd"));
		System.out.println(T.solution("abcabcdede"));
		System.out.println(T.solution("abcabcabcabcdededededede"));
		System.out.println(T.solution("xababcdcdababcdcd"));
	}
}


/* 출력
7
9
8
14
17
*/
