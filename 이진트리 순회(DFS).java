import java.util.*;
class Main{
	public void DFS(int v){ //v가 부모
		if(v>7) return;
		else{
			//전위 순회
			System.out.println(v+" "); //부모
			DFS(v*2); //왼쪽 자식
			DFS(v*2+1); //오른쪽 자식

			//중위 순회
			DFS(v*2); //왼쪽 자식
			System.out.println(v+" "); //부모
			DFS(v*2+1); //오른쪽 자식

			//후위 순회
			DFS(v*2); //왼쪽 자식
			DFS(v*2+1); //오른쪽 자식
			System.out.println(v+" "); //부모
		}
	}
	public static void main(String[] args){
		Main T = new Main();
		T.DFS(1);
	}
}
