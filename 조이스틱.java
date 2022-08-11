import java.util.*;
public class Main {
	public int solution(String name) { //name : JAN
		int answer=0;
		int n = name.length();

		//오른쪽으로만 이동한다면 n-1
		int cnt = n-1; //오른쪽으로만 이동했을 때 몇 번 움직였는지 카운트

		for(int i=0; i<n; i++){
			//상하이동
			if(name.charAt(i) > 'N'){ //Z -> Y -> X 순으로 갈 때
				answer += 'Z' - name.charAt(i) + 1;
			}//N이 모든 알파벳의 가운데
			else{ //A -> B -> C 순으로 갈 때
				answer += name.charAt(i) - 'A'; //B - A 이면 1
			}

			int a = i+1; //다음 글자가 A인지
			while(a < n && name.charAt(a) == 'A'){
				a++; //A 가 있으면 인덱스 + 해서 다음 것으로 넘어감
			}//A가 연속해서 있을 수도 있음  ex) _ _ _ A A A _ _

			cnt = Math.min(cnt, i+n-a+Math.min(i,n-a));
			//A가 마지막 까지 있는 경우도 생각
		}
		answer += cnt;
		return answer;
	}
	
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution("HEROEN"));
		System.out.println(T.solution("JAN"));
	}
}
