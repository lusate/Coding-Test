import java.util.*;
class Main {	
	public int[] solution(String s, char t){
		int[] answer=new int[s.length()];
		int p=1000;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i)==t){
				p=0;
				answer[i]=p;
			}
			else{
				p++;
				answer[i]=p;
			}
		}
		p=1000;
		for(int i=s.length()-1; i>=0; i--){
			if(s.charAt(i)==t) p=0;
			else{
				p++;
				answer[i]=Math.min(answer[i], p);
			}
		}
		for(int x : answer){
			System.out.print(x + " ");
		}
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		String s=sc.next();
		char t=sc.next().charAt(0);
		T.solution(s, t);
	}
}


/* 입력
teachermode e
*/

/* 출력
1 0 1 2 1 0 1 2 2 1 0
*/
