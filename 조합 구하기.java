import java.util.*;
class Main{
	static int n, m;
	Stack<Integer> pm = new Stack<>();
	public void DFS(int L, int s){
		if(L == m){
			for(int x : pm) System.out.print(x + " ");
			System.out.println();
		}
		else{
			for(int i=s; i<=n; i++){
				pm.push(i);
				DFS(L+1, i+1);
				pm.pop();
			}
		}
	}
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		n=kb.nextInt();
		m=kb.nextInt();
		T.DFS(0, 1);
	}
}
