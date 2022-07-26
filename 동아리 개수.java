import java.util.*;
class Main {
	int target, answer=0;
	//큰 List 안에 객체들이 들어간다. (ArrayList 객체들이 Integer로 들어간다.)
	ArrayList<ArrayList<Integer>> graph;
	int[] ch;
	public void DFS(int v){
		for(int nv : graph.get(v)){
			if(ch[nv] == 0){
				ch[nv] = 1;
				DFS(nv);
				//ch[nv]=0; 체크를 할 때 0으로 바꾸지 않음
			}
		}
	}
	public int solution(int n, int[][] edge){// n: 정점 개수, edge: 인접행렬
		graph = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=n; i++){
			graph.add(new ArrayList<Integer>());
		}
		ch = new int[n+1];
		target = n; //목표는 정점개수
		for(int[] x : edge){
			graph.get(x[0]).add(x[1]);
			graph.get(x[1]).add(x[0]); // 무방향 그래프이므로 반대로도 해줌
		}

		for(int i=1; i<=n; i++){
			if(ch[i] == 0){
				ch[i] = 1;
				answer++;
				System.out.print(answer);
				DFS(i);
			}
		}
		return answer;
		
	}
		
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(7, new int[][]{{1, 2}, {2, 3}, {1, 4}, {1, 5}}));
	}
}
