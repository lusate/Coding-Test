import java.util.*;
class Main {
	String answer="";
	public void DFS(int n){
		if(n==0) return;
		else{
			DFS(n/2);
			answer+=(n%2);
		}
	}
	public String solution(int n){
		DFS(n);
		return answer;
	}
		
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(11));
	}
}
