//중복순열 (자바는 스택으로 하는게 편함)
import java.util.*;
class Main{
	Stack<Integer> pm = new Stack<>();
	static int n, m; // n=3, m=2
	public void DFS(int L){
		if(L==m){
			for(int x : pm) System.out.print(x+" ");
			System.out.println();
		}
		else{
			for(int i=1; i<=n; i++){
				pm.push(i);
				DFS(L+1);
				pm.pop();
			}
			//push(1), L=0, DFS(1)해서 i=1, push(1) 하고 출력한 뒤(1 1) pop()
			//(1, ) 에서 push(2), DFS(2) 해서 출력한 뒤(1, 2) pop()
			//(1, ) 에서 push(3), DFS(2) 해서 출력한 뒤(1, 3) pop()
			
			//i=1부터 시작
			//push(2), L=1, DFS(1) 해서 i=1, push(1) 하고 출력한 뒤(2 1) pop()
			//(2, ) 에서 push(2), DFS(2) 해서 출력한 뒤 (2, 2) pop()
			//(2, ) 에서 push(3), DFS(2) 해서 출력한 뒤 (2, 3) pop()
		}
	}
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		n=kb.nextInt();
		m=kb.nextInt();
		T.DFS(0);
	}
}
