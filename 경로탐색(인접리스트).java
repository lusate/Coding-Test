import java.util.*;
class Main {
	int target, answer=0;
	//큰 List 안에 객체들이 들어간다. (ArrayList 객체들이 Integer로 들어간다.)
	ArrayList<ArrayList<Integer>> graph; //이거 암기
	int[] ch;
	public void DFS(int v){
		if(v == target) answer++;
		else{
			for(int nv : graph.get(v)){
			//nv는 정점들로 입력값대로 1 2 2 3 4 4 2 1 3 4 2 2 2 4 1 4 2 2 3 2 4 가 된다.
				if(ch[nv] == 0){
					ch[nv] = 1;
					DFS(nv);
					ch[nv]=0;
				}
			}
		}
	}
	public int solution(int n, int[][] edge){// n: 정점 개수, edge: 인접행렬
		graph = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=n ;i++){
			graph.add(new ArrayList<Integer>());
		} //요거 암기
		ch = new int[n+1];
		target = n; //목표는 정점개수
		for(int[] x : edge){
			graph.get(x[0]).add(x[1]); // 방향 그래프일 때
		}//인접리스트 만들어짐
		ch[1]=1;
		DFS(1);
		return answer;
	}
		
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(5, new int[][]{{1, 2}, {1, 3}, {1, 4}, 
			{2, 1}, {2, 3}, {2, 5}, {3, 4}, {4, 2}, {4, 5}}));
	}
}
