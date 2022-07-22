import java.util.*;
class Main{
	public void DFS(int n){
		if(n == 0) return;
		else{
			DFS(n-1);
			System.out.print(n+" ");
			//1 -> 2 -> 3 출력

			
			//System.out.print(n+" ");
			//DFS(n-1);
			//DFS(3) -> DFS(2) -> (1)
			//3 -> 2 -> 1 출력
		}
	}
	public static void main(String[] args){
		Main T = new Main();
		T.DFS(3);
	}
}
//DFS는 기본적으로 스택으로 함
